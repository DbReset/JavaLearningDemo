package com.luoyj.basic.threadtest;

public class testSynchronized {


    public static void testDemo() throws InterruptedException {
        Reservoir r = new Reservoir(100);
        Booth b1 = new Booth(r);
        Booth b2 = new Booth(r);
        Booth b3 = new Booth(r);
/*           main.java.com.luoyj.threadtest.Booth b4 = new main.java.com.luoyj.threadtest.Booth(r);
            main.java.com.luoyj.threadtest.Booth b5 = new main.java.com.luoyj.threadtest.Booth(r);
            main.java.com.luoyj.threadtest.Booth b6 = new main.java.com.luoyj.threadtest.Booth(r);*/

        b1.join();
        b2.join();
        b3.join();
/*           String s  =  b3.toString();
            System.out.println(s);*/
    }


}

/**
 * contain shared resource
 */
class Reservoir {
    private int total;

    public Reservoir(int t) {
        this.total = t;
    }

    /**
     * Thread safe method
     * serialized access to main.java.com.luoyj.threadtest.Booth.total
     */
    public boolean sellTicket() {
        if (this.total > 0) {
            this.total = this.total - 1;
            return true; // successfully sell one
        } else {
            return false; // no more tickets
        }
    }
}

/**
 * create new thread by inheriting Thread
 */
class Booth extends Thread {
    private static int threadID = 0; // owned by Class object

    private Reservoir release;      // sell this reservoir
    private int count = 0;          // owned by this thread object

    /**
     * constructor
     */
    public Booth(Reservoir r) {
        super("ID:" + (++threadID));
        this.release = r;          // all threads share the same reservoir
        this.start();

    }

    /**
     * convert object to string
     */
/*    public String toString() {
        return super.getName();
    }*/

    /**
     * what does the thread do?
     */
    public void run() {
        while (true) {
            if (this.release.sellTicket()) {
                this.count = this.count + 1;
                System.out.println(this.getName() + ": sell 1" + "current sel:" + this.count);
                try {
                    sleep((int) Math.random() * 100);   // random intervals
                    //TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                break;
            }
        }
        System.out.println(this.getName() + " I sold:" + count);
    }
}

