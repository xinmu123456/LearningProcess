package com.xinmu;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        //Inner de = demo.new Inner(); // new成员内部类的方法

        //Demo.Inner inner = new Demo.Inner();
        new Thread(() -> {
            System.out.println(43);
        });
        int i = 10;
        Runnable runnable = () -> {
            System.out.println(42);
        };

        Runnable rn = () -> System.out.println(42);

        new ABS() {
            @Override
            int ab_func() {
                return 0;
            }
        };

        ACN acn = () -> {

        };

        //ABS abs_ = () -> {
        //
        //}
    }

    void func(){
        class BBB {

        }

    }
    public static class Inner { // 一个成员内部类
        static int i = 0;

        public static void main(String[] args) {

        }
    }
}

interface ACN {
    void todo();
}

abstract class ABS {
    abstract int ab_func();

    int add (int a, int b) {
        return  a + b;
    }

}
