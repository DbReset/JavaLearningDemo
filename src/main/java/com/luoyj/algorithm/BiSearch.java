package com.luoyj.algorithm;

/*二分查找又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。*/
public class BiSearch {


    public static int BiSearchDemo(int[] input_array, int targetNum) {

        int low = 0;
        int high = input_array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (input_array[mid] == targetNum) {
                return mid + 1;

            } else if (input_array[mid] < targetNum) { //向右查找
                low = mid + 1;

            } else { //向左查找
                high = mid - 1;
            }

        }


        return -1; //未找到

    }


}
