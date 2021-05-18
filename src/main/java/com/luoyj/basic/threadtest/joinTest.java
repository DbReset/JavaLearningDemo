package com.luoyj.basic.threadtest;

import java.util.concurrent.TimeUnit;

public class joinTest {
      static  class ThreadA extends Thread{

          @Override
          public void run() {
              try {
                  TimeUnit.SECONDS.sleep(4);
                  System.out.println("线程A,doSomething");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }


    static  class ThreadB extends Thread{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("线程B,doSomething");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread_a = new ThreadA();
        Thread thread_b = new ThreadB();
        thread_a.start();
        thread_b.start();

        //完成a,b线程后再往下执行主线程
        try {
            thread_a.join();
            thread_b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("main方法结束");
    }


}
