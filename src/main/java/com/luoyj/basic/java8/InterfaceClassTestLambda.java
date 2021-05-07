package com.luoyj.basic.java8;

public class InterfaceClassTestLambda {
    public static void main(String[] args) {


        System.out.println(new InterfaceTestForLambda<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println((InterfaceTestForLambda<Integer>) (o1, o2) -> o1 - o2);
    }
}
