package com.TestAop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

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

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
}
