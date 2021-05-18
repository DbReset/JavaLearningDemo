package com.luoyj.basic.threadtest;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//三个线程依次循环打印abc 指定的次数
public class printAbcthread {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for(int i=0;i<=10;){

                try{
                    lock.lock();
                    while (state % 3 == 0){
                        System.out.println("A");
                        state ++ ;
                        i++;

                    }

                }finally {
                    lock.unlock();
                }

            }

        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for(int i=0;i<=10;){

                try{
                    lock.lock();
                    while (state % 3 == 1){
                        System.out.println("B");
                        state ++ ;
                        i++;

                    }

                }finally {
                    lock.unlock();
                }

            }

        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for(int i=0;i<=10;){

                try{
                    lock.lock();
                    while (state % 3 == 2){
                        System.out.println("C");
                        state ++ ;
                        i++;

                    }

                }finally {
                    lock.unlock();
                }

            }

        }
    }


    public static void main(String[] args) {
        Thread thread_a = new ThreadA();
        Thread thread_b = new ThreadB();
        Thread thread_c = new ThreadC();
        thread_a.start();
        thread_b.start();
        thread_c.start();
    }

}
