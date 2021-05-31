package com.luoyj.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordCountDemo {


    public static String CountWords(FileReader file) throws IOException {
        StringBuilder s;
        BufferedReader bufferedReader = new BufferedReader(file);
        s = new StringBuilder(bufferedReader.readLine());
        while (bufferedReader.ready()) {
            s.append(bufferedReader.readLine());
        }

        HashMap<String,Integer> hashmap = new HashMap<>();
        setmap(s, hashmap);
        bufferedReader.close();

        return sortMap(hashmap);
    }



    public static String CountWords_big_file(FileReader file) throws IOException{
        StringBuilder s;
        BufferedReader bufferedReader = new BufferedReader(file);
        s = new StringBuilder(bufferedReader.readLine());

        HashMap<String,Integer>  hashmap = new HashMap<>();
        while (bufferedReader.ready()) {
            setmap(s, hashmap);
            s = new StringBuilder(bufferedReader.readLine());
        }

        setmap(s, hashmap);

        bufferedReader.close();

        return sortMap(hashmap);
    }

    private static void setmap(StringBuilder s, HashMap hashmap) {
        char[] c = s.toString().toCharArray();
        for (char signal_c : c) {
            Integer map_count = (Integer) hashmap.get(String.valueOf(signal_c));
            if (map_count == null) {
                hashmap.put(String.valueOf(signal_c), 1);
            } else {
                hashmap.put(String.valueOf(signal_c), map_count + 1);
            }

        }
    }
    /*public static String CountWords(String file_path) throws IOException {
        FileInputStream inFile = new FileInputStream(file_path);
        FileChannel inputChannel = inFile.getChannel();
        int buffersize = 2000;
        ByteBuffer byteBuffer = ByteBuffer.allocate(buffersize);//申请缓存区
        long position_end = 0l;
        HashMap hashmap = new HashMap();

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

            byte[] tbyte = new byte[byteBuffer.limit()];


            position_end += buffersize;
            byteBuffer.clear(); //清空缓存块指针
            read = inputChannel.read(byteBuffer, position_end);
        }


    }*/
    //基于java8的stream 返回 按value排序后的linkedhashmap
//    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
//     HashMap<K, V> finalOut = new LinkedHashMap<>();
//     aMap.entrySet()
//             .stream()
//             .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
//             .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
//     return finalOut;
// }


    public static String sortMap(Map map) {
        int count = 0;
        //StringBuffer 线程安全  StringBuilder 未实现线程安全
        StringBuffer st = new StringBuffer();
        //那如何转换呢？把map集合转换成Set集合
        // Set entrySet=map.entrySet();
        //在把set 转换层list集合
        // ArrayList<Map.Entry<String,Integer>> list= new ArrayList(entrySet);
        List<Map.Entry<String, Integer>> list_trans = new ArrayList(map.entrySet());

        //此处使用lambda表达式实现Comparator接口中的compare方法   其实Comparator 中有两个方法  但另一个equals（object） 是object类的实现  所以此处直接使用lambda不会有问题
        Collections.sort(list_trans, (o1, o2) -> {
            int temp = o1.getValue() - o2.getValue();
            return temp == 0 ? o2.getKey().compareTo(o1.getKey()) : temp;

        });

        // 利用一次迭代，将总的字符个数算出来，赋值给count 用于计算的百分比
        for (Iterator<Map.Entry<String, Integer>> it = list_trans.iterator(); it.hasNext(); ) {
            Map.Entry m = (Map.Entry) it.next();
            Integer value = (Integer) m.getValue();
            count += value;

        }
        Iterator it = list_trans.iterator();
        // 对出现次数最多的前十个字符进行输出
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> m = (Map.Entry) it.next();
            st.append(m.getKey()).append(":").append(m.getValue()).append("出现频率为").append((float) m.getValue().intValue() / count * 100).append("\r\n");
        }

        return st.toString();


    }


}



