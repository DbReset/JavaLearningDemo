package com.luoyj.basic.threadtest.basic;

import java.util.concurrent.TimeUnit;

public class StopByFlag {

    static void stopByFlag() {
        ARunnable ar = new ARunnable();
        new Thread(ar).start();
        ar.tellToStop();
    }

    static class ARunnable implements Runnable {

        volatile boolean stop;

        void tellToStop() {
            stop = true;
        }

        void doingLongTime(int time){
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void run() {
            System.out.println("进入不可停止区域 1。。。");
            doingLongTime(5);
            System.out.println("退出不可停止区域 1。。。");
            System.out.println("检测标志stop = "+String.valueOf(stop));
            if (stop) {
                System.out.println("停止执行");
                return;
            }
            System.out.println("进入不可停止区域 2。。。");
            doingLongTime(5);
            System.out.println("退出不可停止区域 2。。。");
        }

    }

}
