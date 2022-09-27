package com.TestAop;

/**
 * @Author: xinmu
 * @DateTime: 2022/9/27 11:13
 */


public class Hello {
    private int data;
    void test() {
        System.out.println("aop正常使用");
    }

    public Hello (int data) {
        this.data = data;
    }

    public Hello () {
        this(0);
    }
}
