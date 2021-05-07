package com.luoyj.basic;

import java.util.ArrayList;

//泛型测试
public class test_Generic {


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        System.out.println(a[0]);
        printArray(a);
        String[] b = {"a", "b", "c"};
        printArray(b);

        ArrayList testArray = new ArrayList();
        testArray.add("1");
        testArray.add(1);
        System.out.println();

    }


    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {

        for (E element : inputArray) {
            System.out.printf("%s ", element);
            System.out.printf("%s ", element);
        }
    }


}
