package com.xinmu.factory_method;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:36
 */


public class HuaweiPhone implements Phone{
    @Override
    public void display() {
        System.out.println("这是华为手机");
    }
}
