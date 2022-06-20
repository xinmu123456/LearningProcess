package com.xinmu.ThreadSyn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xinmu
 * @date 2022/2/25 16:51
 * @description:
 */

//测式JUC安全类型的集合
public class TestJUC {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String>list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
