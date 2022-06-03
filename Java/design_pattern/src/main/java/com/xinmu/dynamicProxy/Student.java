package com.xinmu.dynamicProxy;

import com.xinmu.simpleProxy.Person;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:33
 */


public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("上交班费50元");
    }
}
