package com.xinmu.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 12:28
 */


public class PrintNumAndCharLoop {

    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    private PrintNumAndCharLoop(int times){
        this.times = times;
    }

    private void printNumAndChar(String content, int targetNum){
        for (int i = 0; i < times;) {
            lock.lock();
            if (state%2 == targetNum){
                state++;
                i++;
                System.out.println(content);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintNumAndCharLoop loop = new PrintNumAndCharLoop(5);
        new Thread(() -> {
            loop.printNumAndChar("123456789", 0);
        }).start();
        new Thread(() -> {
            loop.printNumAndChar("abcdefghijk", 1);
        }).start();
    }

}
