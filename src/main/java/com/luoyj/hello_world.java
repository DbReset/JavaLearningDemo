package com.luoyj;

public class hello_world {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        // System.out.println(a[0]);
        // printArray(a);
        String[] b = {"a", "b", "c"};
        // printArray(b);
        ObjectTool tool = new ObjectTool<>();
        tool.setObj(new String("钟福成"));
        tool.setObj(new Integer(798));
        String s = tool.getObj().toString();

        System.out.println(tool.getObj());
    }


    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
    }


    //泛型类
    public static class ObjectTool<T> {
        private T obj;

        public T getObj() {
            return obj;

        }

        public void setObj(T obj) {
            this.obj = obj;

        }

    }

}
