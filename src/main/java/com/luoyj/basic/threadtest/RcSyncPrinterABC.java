package com.luoyj.basic.threadtest;



public class RcSyncPrinterABC {
    private static final Object o = new Object();


    public static void main(String[] args) {
        new Thread(()->{
            synchronized (o){
                for (int i = 0; i < 10; ) {
                    System.out.println(Thread.currentThread().getName() + "A");
                    i++;
                    try{
                        o.notify();
                        o.wait();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                o.notify();
            }

        },"A").start();


        new Thread(()->{
            synchronized (o){
                for (int i = 0; i < 10; ) {
                    System.out.println(Thread.currentThread().getName() + "B");
                    i++;
                    try{
                        o.notify();
                        o.wait();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                o.notify();
            }

        },"B").start();
    }

}
