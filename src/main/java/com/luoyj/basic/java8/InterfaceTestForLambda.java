package com.luoyj.basic.java8;

public interface InterfaceTestForLambda<T> {

    int compare(T o1, T o2);

    //此方法在Object中有实现   所以实现InterfaceTestForLambda 接口可以不用实现equals方法
    boolean equals(Object obj);


}
