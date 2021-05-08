package com.luoyj.algorithm;


import java.util.Arrays;

//贪心算法
public class Greed {
    //经典 找零钱
    public static void ChangeMoney(int  money){

        int[] moneybox = {100,50,20,10,5,1};
        int[] changArray = new int[moneybox.length];
        System.out.println(Arrays.toString(changArray));
        int change = money;
        if(money > 0){

            while(change > 0){

                for(int i=0;i<moneybox.length;i++){

                    for(int j=1;change - moneybox[i] >= 0;j++) {
                        int tmp = change - moneybox[i];
                        if (tmp >= 0) {
                            change = tmp;
                            changArray[i] = j;
                        } else {
                            break;
                        }
                    }



                }


            }



        }

        for(int p=0;p<moneybox.length;p++){
            if(changArray[p] > 0){
                System.out.println("需要找零"+moneybox[p]+" "+changArray[p]+"张");
            }
        }




    }




}
