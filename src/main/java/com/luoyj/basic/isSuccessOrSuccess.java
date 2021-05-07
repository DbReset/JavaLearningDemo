package com.luoyj.basic;

import java.util.StringJoiner;

public class isSuccessOrSuccess {

    public static void main(String[] args) {
        Model model1 = new Model();
        System.out.println("default model : " + model1.toString());
    }
}

class Model {
    /**
     * 定一个Boolean类型的success成员变量
     */
    private Boolean success;
    /**
     * 定一个boolean类型的failure成员变量
     */
    private boolean failure;

    /**
     * 覆盖toString方法，使用Java 8 的StringJoiner
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]")
                .add("success=" + success)
                .add("failure=" + failure)
                .toString();

        //对象的默认值是null，boolean基本数据类型的默认值是false
    }

}
