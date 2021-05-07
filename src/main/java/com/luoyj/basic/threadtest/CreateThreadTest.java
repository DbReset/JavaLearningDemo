package com.luoyj.basic.threadtest;

/*java创建线程的4种方法：
        1.继承Thread类实现多线程
        2.覆写Runnable()接口实现多线程，而后同样覆写run().推荐此方式
        3.覆写Callable接口实现多线程（JDK1.5）
        4.通过线程池启动多线程 通过Executor 的工具类可以创建三种类型的普通线程池：*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CreateThreadTest {
    public static void main(String[] args) {


        //通过继承Thread类实现多线程
        MyThread mThread1 = new MyThread();
        MyThread mThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        mThread1.start();
        mThread2.start();
        myThread3.start();


        //通过实现runnable 接口 来创建多线程
        Thread thread1_runnable = new Thread(new NewThread_runnable(), "NewThread_runnable_first");
        Thread thread2_runnable = new Thread(new NewThread_runnable(), "NewThread_runnable_second");
        System.out.println("breakpoint");
        thread1_runnable.start(); // start thread1
        thread2_runnable.start(); // start thread2


        //通过实现callable 接口来创建多线程
        Callable<String> callable = new MyThread_impl_callable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread mThread_callable = new Thread(futureTask);
        Thread mThread2_callable = new Thread(futureTask);
        Thread mThread3_callable = new Thread(futureTask);
        mThread_callable.start();
        mThread2_callable.start();
        mThread3_callable.start();

// 通过Executor 的工具类可以创建三种类型的普通线程池：
        //线程池实现  FixThreadPool(int n); 固定大小的线程池
        //使用于为了满足资源管理需求而需要限制当前线程数量的场合。使用于负载比较重的服务器。
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {

                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName());


                }
            });
        }
        ex.shutdown();
    }


}

/*    run()为线程类的核心方法，相当于主线程的main方法，是每个线程的入口
     a.一个线程调用 两次start()方法将会抛出线程状态异常，也就是的start()只可以被调用一次
    b.native生明的方法只有方法名，没有方法体。是本地方法，不是抽象方法，而是调用c语言方法
registerNative()方法包含了所有与线程相关的操作系统方法
c. run()方法是由jvm创建完本地操作系统级线程后回调的方法，不可以手动调用（否则就是普通方法）*/
class MyThread extends Thread {
    public MyThread() {
    }

    public void run() {

        System.out.println(Thread.currentThread() + "MyThread_ex_Thread:");

    }

}

//实现runnable 接口来实现创建线程
class NewThread_runnable implements Runnable {
    /**
     * convert object to string
     */
    public String toString() {
        return Thread.currentThread().getName();
    }

    /**
     * what does the thread do?
     */
    public void run() {
        System.out.println(this);
    }


}

//实现callable接口 来创建线程  核心方法叫call()方法，有返回值
class MyThread_impl_callable implements Callable<String> {

    @Override
    public String call() throws Exception {
        int count = 20;
        for (int i = count; i > 0; i--) {
//			Thread.yield();
            System.out.println(Thread.currentThread().getName() + "MyThread_impl_callable当前票数：" + i);
        }
        return "sale out";
    }

}


