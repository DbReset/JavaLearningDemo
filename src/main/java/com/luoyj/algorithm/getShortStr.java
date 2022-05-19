package com.luoyj.algorithm;

import com.sun.xml.internal.ws.util.StringUtils;

/*
* 给两个字符串
* 1：abckdkde
* 2:ac
* 求1中包含2所有字符的最小字符子串*/

public class getShortStr {

        private static int cun = 0;
        private static int cun1 = 0;

        public static void main(String[] args) {
            String a = "ADOBANCDEBANC";
            String b = "ABC";
            String str = getStr(a, b);
            System.out.println(str);
        }


        public static String getStr(String a , String b){
            try {
                cun ++;
                if(a == null || b == null){
                    return  "字符串为空";
                }
                if(a.length() < b.length()){
                    return "父字符串长度小于子字符串";
                }
                int length_b = b.length();
                int start = cun-1;
                if(start > (a.length() - b.length()-cun1)){
                    start = 0;
                    cun = 1;
                    cun1 ++;
                }
                int end = start+length_b + cun1;
                String c = a.substring(start,end);
                int count = 0;
                String bb = b;
                for(int i = 0 ; i < c.length(); i++){
                    String value = String.valueOf(c.charAt(i));
                    if(bb.contains(value)){
                        bb = bb.replace(value, "");
                        count++;
                    }
                }
                if(count == length_b){
                    return c;
                }else {
                    String str = getStr(a, b);
                    return  str;
                }
            } catch (Exception e) {
                return "没有找到对应的最小子串";
            }
        }


}
