package com.luoyj.algorithm.sort;

import java.util.Arrays;

//快速排序算法实现
public class quicksort {

    public static void main(String[] args) {
        int[] a = {10, 4, 14, 34, 33, 1, 2, 35, 18, 49};
        sortMeth(a);
        System.out.println(Arrays.toString(a));
        // quickSort(a,0,a.length-1);
    }


    public static void sortMeth(int[] array) {
        quickSort2(array, 0, array.length - 1);

    }


    /**
     * @param arr   需要排序的数组
     * @param start 一般传入0
     * @param end   一般传入arr[arr.length-1]
     */
    public static void quickSort(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }
        int high = start;  //从前往后找的位置  要找比基准值大的
        int low = end;     //从后往前找的位置  要找比基准值小的
        int numBase = arr[start];
        while (high != low) {   //一直查找并交换 直到两个指针相遇

            while (arr[low] >= numBase && low > high) {
                low--;
            }
            while (arr[high] <= numBase && low > high) {
                high++;
            }

            //交换位置
            int tmp = arr[high];
            arr[high] = arr[low];
            arr[low] = tmp;
//            System.out.println(arr[i] + "《》《》《》《》"+ arr[j]);
            //System.out.println(Arrays.toString(arr));
        }
        //将基准值和相遇位置得值交换
        arr[start] = arr[high];
        arr[high] = numBase;
//        System.out.println(arr[i] + "《》《基准交换》《》"+ arr[start]);
//        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, high - 1);
//        System.out.println("左边递归完成》》》"+Arrays.toString(arr));
        quickSort(arr, low + 1, end);


        //System.out.println(Arrays.toString(arr));
    }


    /*    快速排序的原理：选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
        比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素。
        一次循环：从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有
        继续比较下一个，直到找到第一个比基准值小的值才交换。找到这个值之后，又从前往后开始比
        较，如果有比基准值大的，交换位置，如果没有继续比较下一个，直到找到第一个比基准值大的
        值才交换。直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值
        来说，左右两边就是有序的了。*/
    public static void quickSort2(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int baseNum = arr[start];

        int index_start = start;
        int index_end = end;
        //quicksort2 这种写法更好理解一点   对比quicksort 无论从后往前 还是从前往后 只要匹配到了直接交换就行了
        // 其实 最后和quicksort实现效果一致 直接将从后到前找到的小数和从前到后找到的大数交换，然后基准值再交换到汇聚的点上，避免了一次次传递
        while (index_start < index_end) {

            //从后往前找比base小的数据
            while (arr[index_end] >= baseNum && index_end > index_start) {
                index_end--;
            }
            //交换
            if (baseNum > arr[index_end]) {
                int tmp = arr[index_end];
                arr[index_end] = arr[index_start];
                arr[index_start] = tmp;
            }

            //从前往后找 比base大的数据
            while (arr[index_start] <= baseNum &&  index_end < index_start) {
                index_start++;
            }
            //交换
            if (baseNum < arr[index_start]) {
                int tmp = arr[index_end];
                arr[index_end] = arr[index_start];
                arr[index_start] = tmp;
            }


        }

        //再分别去递归调用基准值的左边
        quickSort2(arr, start, index_start - 1);

        //递归右边的
        quickSort2(arr, index_end + 1, end);


    }


}
