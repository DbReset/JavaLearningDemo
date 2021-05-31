package com.luoyj.algorithm;


//检查数字是否是指定数字的次幂
//快速解题的思想是使用位运算进行
public class checkNumNthPower {


    //判断是否是2的次幂
    public static boolean is2NthPower(int n){

        //n如果是2的次幂  则2进制中只有一位是1，其他都是0，n-1 则末位都是1，与运算后都为0
        return n>0 && (n & (n-1)) == 0;

    }


    //是4的次幂 则一定是2的次幂，并且 二进制中1 一定是在奇数位置的
    public static boolean is4NthPower(int n){

        if(n < 0 || (n & n-1) != 0){

            return false;
        }

        return n % 3 == 1;

    }


}
