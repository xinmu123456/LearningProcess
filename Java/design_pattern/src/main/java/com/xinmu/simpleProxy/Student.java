package com.xinmu.simpleProxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:12
 */


public class Student implements Person{

    private String name;

    @Override
    public void giveMoney() {
        System.out.println(name + "student上交了班费");
    }

    public Student(String name) {
        this.name = name;
    }
}
