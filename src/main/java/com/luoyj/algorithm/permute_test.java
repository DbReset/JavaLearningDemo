package com.luoyj.algorithm;

public class permute_test {
    //算法 全排列

    /**
     * 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再将第一个字符与后面每一个字符交换，同样递归获得其字符串组合；
     * 每次递归都是到最后一位时结束，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，
     * 然后继续处理子串。
     */


    public void permute(char[] str, int low, int high) {

/*
        System.out.println("begin>>>>>>>>>low>>>"+ low + ">>>>>high>>>>>" + high);
*/

        if (low   >= high) {
            System.out.println("RESULT>>>>>>>>>>>>>" + new String(str));
            return;
        }
        for (int i = low; i < high; i++) {//i遍历第low~high个数，str[low]所存的数值为打头的数
            //swap
           /* char c = str[low];
            str[low] = str[i];
            str[i] = c;*/
            swap(str,low,i);
/*            if ( i != low){
                System.out.println("low>>>"+ low);
                System.out.println("i>>>"+i);
            }*/
            //  System.out.println("low>>>"+ low + ">>>>i>>>"+ i + ">>>>第"+low+"组，第" + p + "次循环");

            permute(str, low + 1, high);

            //swap back 为避免重复排序，每个数打头结束后都恢复初始排序,防止重复的方法很多，不止这一种
/*            if (i != low) {
                System.out.println("swap back_low>>>" + low);
                System.out.println("swap back_i>>>" + i);
            }*/
            swap(str,low,i);
        }
    }

    public void permute(String str) {
        permute(str.toCharArray(), 0, str.length());
    }


    private void swap(char[] str,int index1,int index2){
        char c = str[index1];
        str[index1] = str[index2];
        str[index2] = c;

    }

}
