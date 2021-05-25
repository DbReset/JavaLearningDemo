package com.luoyj.basic.DataOrganization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DataOrganization {
    public static void main(String[] args) {
        //map型
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("1", 2);
        map.remove("1");
        Integer i = (Integer) map.get("1");
        System.out.println(i);

        //Hashset
        HashSet<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        //set.remove("1");

        //array 数组
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(array));

        System.out.println(set.toString());
    }


}
