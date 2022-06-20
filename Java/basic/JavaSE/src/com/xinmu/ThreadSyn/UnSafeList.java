package com.xinmu.ThreadSyn;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author xinmu
 * @date 2022/2/25 11:34
 * @description:
 */

public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }

            }).start();
        }
        sleep(1000);
        System.out.println(list.size());
    }
}
