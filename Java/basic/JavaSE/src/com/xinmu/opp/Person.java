package com.xinmu.opp;

/**
 * @author xinmu
 * @date 2022/1/18 23:28
 * @description:
 */
public class Person {
    String name="111";
    public void say(){
        System.out.println("Person say");
    }

    {
        System.out.println("匿名代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("Person构造方法");
    }

//    public static void main(String[] args) {
//        new Person();
//    }
}
