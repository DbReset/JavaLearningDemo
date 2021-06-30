package com.luoyj.algorithm.sort;

public class InsertSort {


    //插入排序算法
    //通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
    //插入排序非常类似于整扑克牌。在开始摸牌时，左手是空的，牌面朝下放在桌上。接着，一次从
    //桌上摸起一张牌，并将它插入到左手一把牌中的正确位置上。为了找到这张牌的正确位置，要将
    //它与手中已有的牌从右到左地进行比较。无论什么时候，左手中的牌都是排好序的。
    public static int[] InsertSort(int[] input_array) {

        for (int i = 1; i < input_array.length; i++) {
            int num_insert = input_array[i]; // 当前需要插入的数
            //被插入的位置(准备和前一个数比较)
            int j = i - 1;
            //如果插入的数比被插入的数小
            while (j >= 0 && (num_insert < input_array[j])) {

                //将把 input_array[j] 向后移动
                input_array[j + 1] = input_array[j];
                j--;

            }

            input_array[j + 1] = num_insert;


        }


        return input_array;


    }


}
