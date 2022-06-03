package com.xinmu.adapter.phone;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:10
 */


public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
