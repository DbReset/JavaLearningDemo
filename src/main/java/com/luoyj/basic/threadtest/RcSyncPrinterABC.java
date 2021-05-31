package com.luoyj.basic.threadtest;

import java.util.concurrent.locks.Condition;

public class RcSyncPrinterABC {
    class syncPrinter implements Runnable{

        private final String printchar;
        private final Condition thisCondition;
        private Condition nextCondition;

        syncPrinter(String printchar,Condition thisCondition,Condition nextCondition) {
            this.thisCondition = thisCondition;
            this.printchar = printchar;
            this.nextCondition = nextCondition;
        }


        @Override
        public void run() {

        }
    }
}
