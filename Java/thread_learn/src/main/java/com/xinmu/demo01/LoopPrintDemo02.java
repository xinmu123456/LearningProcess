package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 12:03
 */


public class LoopPrintDemo02 {

    private int num;
    private static final Object LOCK = new Object();


    private void printABC(int targetNum){
        synchronized (LOCK){
            while (num % 3 != targetNum){
                try{
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            num ++;
            System.out.println(Thread.currentThread().getName());
            LOCK.notifyAll();
        }
    }


    public static void main(String[] args) {
        LoopPrintDemo02 loopPrintDemo02 = new LoopPrintDemo02();
        new Thread(()->{
            loopPrintDemo02.printABC(0);
        }, "A").start();
        new Thread(()->{
            loopPrintDemo02.printABC(1);
        }, "B").start();
        new Thread(()->{
            loopPrintDemo02.printABC(2);
        }, "C").start();
    }
}
