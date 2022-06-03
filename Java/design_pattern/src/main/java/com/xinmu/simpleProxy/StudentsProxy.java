package com.xinmu.simpleProxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:13
 */


public class StudentsProxy implements Person{
    //被代理的对象
    Student stu;

    public StudentsProxy(Person stu){
        //只能代理student对象
        if (stu.getClass() == Student.class) {
            this.stu = (Student) stu;
        }
    }

    //代理上交班费
    @Override
    public void giveMoney() {
        System.out.println("hao");
        stu.giveMoney();
    }
}
