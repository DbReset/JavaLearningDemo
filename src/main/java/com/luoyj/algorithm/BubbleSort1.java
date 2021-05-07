package com.luoyj.algorithm;

import java.util.Arrays;

public class BubbleSort1 {



/*    （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
      （2）这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉”到数组第 N-1 个位置。
      （3）N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。*/

    public static int[] bubbleSortDemo(int[] input_array) {
        int i_size = input_array.length;

        int i, j;  // i 为外层循环的   j为一次冒泡的处理指针
        for (i = 0; i < i_size; i++) {//循环数组 长度次
            for (j = 1; j < i_size - i; j++) {

                if (input_array[j] < input_array[j - 1]) {  //大于还是小于 可以控制升序还是降序
                    //交换j 和j-1
                    int tmp = input_array[j];
                    input_array[j] = input_array[j - 1];
                    input_array[j - 1] = tmp;
                    System.out.println(Arrays.toString(input_array));

                }


            }

        }


        return input_array;


    }


}
