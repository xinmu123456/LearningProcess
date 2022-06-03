package com.xinmu.templatemethod;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 12:24
 * 在servlet中，就运用到了模板方法模式
 */


public class Test {
    public static void main(String[] args) {
        Cook cook = new CookTomato();
        cook.cook();
        System.out.println("----------------");
        cook = new CookPotato();
        cook.cook();
    }
}
