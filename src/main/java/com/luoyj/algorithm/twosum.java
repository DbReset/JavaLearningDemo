package com.luoyj.algorithm;

import java.util.HashMap;
import java.util.Map;

public class twosum {
    //经典题  给一个数组 如 [2,3,5,7,8] 和一个目标数字如10  返回累加的和是目标数字的数组下标

    public static String sloution(int[] array,int target){


        Map<Integer,Integer> tmp_map = new HashMap<Integer,Integer>();

        for (int i = 0; i < array.length; i++) {
            tmp_map.put(array[i],i);
        }

        for(int i = 0; i < array.length; i++){
            Integer target_tmp = target - array[i] ;

            if (tmp_map.containsKey(target_tmp) && tmp_map.get(target_tmp) != i){
                return "the solution is :" + i +","+tmp_map.get(target_tmp);
            }


        }

        return "has no solution";


    }


    public static void main(String[] args) {
        int[] tmp = {1,2,3,4,5,6,7};
        String s = sloution(tmp,3);
        System.out.println(s);
    }

}
