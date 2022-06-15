package com.xinmu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 12:17
 */


public class PrintABCUseLock {

    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    private PrintABCUseLock(int times){
        this.times = times;
    }

    private void printLetter(String name, int targetNum){
        for (int i = 0; i < times;) {
            lock.lock();
            if (state%3 == targetNum){
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCUseLock loopThread = new PrintABCUseLock(1);

        new Thread(()->{
            loopThread.printLetter("A", 0);
        }, "A").start();

        new Thread(()->{
            loopThread.printLetter("B", 1);
        }, "B").start();

        new Thread(()->{
            loopThread.printLetter("C", 2);
        }, "C").start();

    }
}
