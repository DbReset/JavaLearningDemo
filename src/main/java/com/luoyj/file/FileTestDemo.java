package com.luoyj.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileTestDemo {
    public static void main(String[] args) {


        //制造文件
        try {

            //文件拆分
           //  List<String> lstFile =  FileSplit("D:\\idea\\project_tmp\\bigfile_test20210318.txt",5);
            FileReader newBigFile = new FileReader("D:\\idea\\project_tmp\\bigfile_test20210318.txt");
            String s = wordCountDemo.CountWords_big_file(newBigFile);
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    public static List<String> FileSplit(String filepath, int targetFileCount) throws IOException {
        FileInputStream inFile = new FileInputStream(filepath);
        FileChannel inputChannel = inFile.getChannel();
        final long file_size = inputChannel.size();
        long average = file_size / targetFileCount; //拆分的平均值（非精确值）
        long bufferSize = 200; //缓存块大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(Math.toIntExact(bufferSize));//申请缓存区
        long position_start = 0;
        long position_end = average < bufferSize ? 0 : average - bufferSize;

        List<String> return_file_list = new ArrayList<String>();

        for (int i = 0; i < targetFileCount; i++) {
            if (i + 1 < targetFileCount) {
                int read = inputChannel.read(byteBuffer, position_end);

                readW:
                while (read != -1) {
                    byteBuffer.flip();//切换读模式
                    byte[] array = byteBuffer.array();
                    for (byte v : array) {
                        if (v == 10 || v == 13) { //匹配/r/n
                            position_end += 1;
                            break readW;

                        }

                    }
                    position_end += bufferSize;
                    byteBuffer.clear(); //清空缓存块指针
                    read = inputChannel.read(byteBuffer, position_end);
                }

            } else {
                position_end = file_size; //最后一个文件直接指向文件末尾

            }

            FileOutputStream fos = new FileOutputStream(filepath + (i + 1));
            FileChannel outChannel = fos.getChannel();
            System.out.println(position_start + "END" + position_end);
            inputChannel.transferTo(position_start, position_end - position_start, outChannel);//通道传输数据  更高效
            outChannel.close();
            fos.close();

            return_file_list.add(filepath + (i + 1));
            position_start = position_end + 1;
            position_end += average;

        }
        inputChannel.close();
        inFile.close();

        return return_file_list;


    }


}
