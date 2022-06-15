package com.xinmu.demo02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 14:09
 */


public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "D").start();
    }
}

class Data2{
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition =lock.newCondition();

    /*
    condition.await();等待
    condition.signalAll(); 唤醒全部
     */

    public  void increment() throws InterruptedException {
        lock.lock();
        try{
            while (number != 0){
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+ "=>" + number);
            //通知其他线程
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while(number == 0){
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+ "=>" + number);
            //通知其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }


    }
}
