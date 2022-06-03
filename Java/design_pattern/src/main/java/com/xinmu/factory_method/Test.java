package com.xinmu.factory_method;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:40
 */


public class Test {
    public static void main(String[] args) {
        PhoneFactory factory = new HuaweiPhoneFactory();
        Phone phone = factory.createPhone();
        phone.display();
        factory = new XiaomiPhoneFactory();
        phone =  factory.createPhone();
        phone.display();
    }
}
