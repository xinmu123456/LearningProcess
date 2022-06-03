package com.xinmu.factory_method;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:35
 */


public class XiaomiPhone implements Phone{
    @Override
    public void display() {
        System.out.println("这是小米手机");
    }
}
