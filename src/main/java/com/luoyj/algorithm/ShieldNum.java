package com.luoyj.algorithm;

public class ShieldNum {

    //屏蔽输入的数字中的相关关键数字  输出屏蔽后比原值大的最小值

    public static  Long ShieldNum(Long InputLong,String ShieldKey){
        Long Result = InputLong;
        String tmpString = String.valueOf(InputLong);
        Double  IncreaseNum = Double.valueOf(0);
        int i = 1;

        while(tmpString.contains(ShieldKey) && i <= tmpString.length()){
            String SingleString = tmpString.substring(i-1,i);
            System.out.println("String" + SingleString);
            System.out.println("I" + i);
            if(SingleString.equals(ShieldKey)){
                Double m =  Math.pow(10, tmpString.length() - i);
                Long lm = new Double(m).longValue();
                Long t = (InputLong / lm) + 1 ;
                Double n = (Double.valueOf(t)) * m;

                Long lString =new  Double(n).longValue();

                tmpString = String.valueOf(lString);
            }
            i++;
        }


        Result  =  Long.valueOf(tmpString);

        return  Result;


    }
    public static  Long ShieldNum2(Long InputLong,String ShieldKey){
        Long Result = InputLong;
        String tmpString = String.valueOf(InputLong);
        Double  IncreaseNum = Double.valueOf(0);

        while(tmpString.contains(ShieldKey)){
            int  i = tmpString.indexOf(ShieldKey) + 1;
            Double m =  Math.pow(10, tmpString.length() - i);
            Long lm = new Double(m).longValue();
            Long t = (Result / lm) + 1 ;
            Double n = (Double.valueOf(t)) * m;
            Long lString =new  Double(n).longValue();
            tmpString = String.valueOf(lString);
            Result  =  Long.valueOf(tmpString);
        }





        return  Result;


    }




}
