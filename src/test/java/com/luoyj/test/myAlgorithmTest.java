package com.luoyj.test;

import org.junit.Test;

import java.util.*;

import static com.luoyj.algorithm.BiSearch.BiSearchDemo;
import static com.luoyj.algorithm.BubbleSort1.bubbleSortDemo;
import static com.luoyj.algorithm.Greed.ChangeMoney;
import static com.luoyj.algorithm.InsertSort.InsertSort;
import static com.luoyj.algorithm.ShellSort.ShellSort;
import static com.luoyj.algorithm.quicksort.sortMeth;

public class myAlgorithmTest {

    @Test
    public void BiSearchTest() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 3;
        int targetNum = BiSearchDemo(a, target);
        System.out.println("数组下标为："+targetNum);
    }


    @Test
    public void BubbleSort1Test() {
        int[] a = {3, 95, 25, 52, 67, 12};
        bubbleSortDemo(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void InsertSortTest() {
        int[] array_input = {3, 5, 6, 7, 9, 2, 10};
        int[] array_out = InsertSort(array_input);
        System.out.println(Arrays.toString(array_out));
    }

    @Test
    public void PermuteTest() {
            new com.luoyj.algorithm.permute_test().permute("abcd");
    }


    @Test
    public void QuickSortTest() {
        int[] a= {10,4,14,34,33,1,2,35,18,49};
        sortMeth(a);
        System.out.println(Arrays.toString(a));
        // quickSort(a,0,a.length-1);
    }


    @Test
    public void ShellSortTest() {
        int[] a= {10,4,14,34,33,1,2,35,18,49};
        ShellSort(a);
        System.out.println(Arrays.toString(a));
        // quickSort(a,0,a.length-1);
    }

    //贪心算法 找零钱
    @Test
    public void GreedTest() {
        ChangeMoney(895);

    }


    @Test
    public void testSet(){
        Set<Integer> t = new HashSet();
        t.add(0);
        t.remove(-1);

    }

    @Test
    public  void test111() {
            List<String> a = null;
            test(a);
            System.out.println(a.size());
    }


    public static List<String> test(List<String> a) {
       a = new ArrayList<String>();
       a.add("abc");

       return  a;
    }

    @Test
    public void Test111111(){
        int[] stones ={2,3,4,5,6};
        Arrays.sort(stones);

        int tmpi = 0;

        for(int i:stones){

            tmpi = abstrctint(i,tmpi);

        }

       System.out.println(tmpi);


    }
    public int abstrctint(int a,int b){
        int t = a -b;
        if(t > 0){
            return t;

        }else{
            return -t;
        }
    }





}

