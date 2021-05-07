package com.luoyj.basic;

import java.util.Arrays;

public class Rtti {
    public static void main(String[] args) {
        Human aPerson = new Human();
        Class c1 = aPerson.getClass();
        System.out.println(c1.getName());
        Human anotherPerson = new Woman();
        Class c2 = anotherPerson.getClass();
        System.out.println(c2.getName());

        try {
            Class c3 = Class.forName("com.luoyj.basic.Human");
            System.out.println("c3" + c3.getName());
            System.out.println(Arrays.toString(c3.getFields()));
            System.out.println(Arrays.toString(c3.getMethods()));
            System.out.println(c3.getFields());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());

        }


        Class c4 = Woman.class;
        System.out.println(c4.getName());
    }


}

class Human {
    /**
     * accessor
     */

    public static int poupltion = 2;

    public int getHeight() {
        return this.height;
    }

    /**
     * mutator
     */
    public void growHeight(int h) {
        this.height = this.height + h;
    }

    private int height;
}


class Woman extends Human {
    /**
     * new method
     */
    public Human giveBirth() {
        System.out.println("Give birth");
        return (new Human());
    }

}