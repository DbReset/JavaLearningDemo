package com.luoyj.algorithm;

//先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列
//中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
/*根据增量将数组分为多组，每组子数列进行插入排序，
将增量逐渐减小到1，此时数组基本有序，此时进行插入排序，使数组有序*/
public class ShellSort {

    public static int[] ShellSort(int[] input_array) {
        int array_length = input_array.length;
        int increment = array_length;
       //挨个遍历步长，缩短步长，直到步长为零
        for(int d = increment/2;d >0;d=d/2){
            //遍历所有的元素
            for(int i = d;i<array_length;i++){
                //遍历本组中所有的元素,从第一个元素开始
                for(int j = i -d;j>=0;j=j-d){//j=j-d本组前面的那个元素
                    //如果当前元素大于加上步长之后的那个元素,（前面的比后面的大了）交换
                    if(input_array[j] > input_array[j + d]){
                        int tmp = input_array[j];
                        input_array[j] = input_array[j + d];
                        input_array[j + d] = tmp;
                    }

                }

            }


        }


        return input_array;


    }




}
