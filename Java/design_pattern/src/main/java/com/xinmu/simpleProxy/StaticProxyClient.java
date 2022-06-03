package com.xinmu.simpleProxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:27
 */


public class StaticProxyClient {

    public static void main(String[] args) {
        //被代理的的对象
        Student zhangsan = new Student("张三");

        //代理的对象
        Person monitor = new StudentsProxy(zhangsan);

        //班长代缴班费
        monitor.giveMoney();

    }

}
