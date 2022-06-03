package com.xinmu.singleton;

import com.sun.security.jgss.GSSUtil;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:19
 */


public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(Single::getInstance).start();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
