package com.luoyj.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBigTxtFile {
    //创建测试用的大文件

    public static void main(String[] args) {

        try {
            //String fileName = CreateBigFile();
            createBigFile() ;
          //  System.out.println(fileName);
        } catch (IOException e) {
            // e.printStackTrace();
        }


    }

    public static void createBigFile() throws IOException {
        //D:\idea\project\Test_tmp
        File file = new File("D:\\idea\\project_tmp\\bigfile_test20210318.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "The transaction price and the net value deviate too muchaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1";
        for (int i = 0; i < 1000000; i++) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    public static String CreateBigFile() throws IOException {
        File newBigFile = new File("/Users/seven/IdeaProjects/test/tmpTest");

        FileWriter FileWalker = new FileWriter(newBigFile);
        BufferedWriter bigFileCreateBuffer = new BufferedWriter(FileWalker);


        String a = "18004024109abc123321abcabc";
        for (int i = 0; i < 100000; i++) {

            bigFileCreateBuffer.write(a);
            bigFileCreateBuffer.newLine();

        }
        bigFileCreateBuffer.write(a);
        bigFileCreateBuffer.flush();
        bigFileCreateBuffer.close();

        return newBigFile.getAbsolutePath();

    }

}
