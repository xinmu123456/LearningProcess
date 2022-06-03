package com.xinmu.myspring;

/**
 * author: xinmu
 * date: 2022/5/30
 * time: 19:43
 */


public class Test {
    public static void main(String[] args) {
        MyAnnotationConfigApplicationContext applicationContext = new MyAnnotationConfigApplicationContext("com.xinmu.myspring.entity");
        System.out.println(applicationContext.getBean("account"));
        System.out.println(applicationContext.getBean("myOrder"));
    }
}
