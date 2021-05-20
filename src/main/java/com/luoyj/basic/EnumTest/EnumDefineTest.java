package com.luoyj.basic.EnumTest;

public class EnumDefineTest {

    public enum E_WTHR_FLG {
        yes("yes", "1", "是"),
        no("no", "0", "否");


        private String __id__;
        private String __value__;
        private String __longName__;

        private E_WTHR_FLG(String id, String value, String longName) {
            this.__id__ = id;
            this.__value__ = value;
            this.__longName__ = longName;
        }

        public String getID() {
            return this.__id__;
        }


    }


}
