package com.xinmu.ThreadSyn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xinmu
 * @date 2022/2/25 17:30
 * @description:
 */


public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();

    }

}

class TestLock2 implements Runnable{
    int ticketNums =10;

    //定义可重复锁
    private final ReentrantLock lock=new ReentrantLock();


    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();//加锁
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }


        }
    }
}
