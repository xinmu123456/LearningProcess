package com.xinmu.demo02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 14:19
 */


public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}

class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    public void printA(){
        lock.lock();
        try {
            //业务
            while (number != 1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> AAAAAAAAAA");
            //唤醒
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printB(){

        lock.lock();

        try {
            //判断
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> BBBBBBBB");
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public void printC(){
        lock.lock();
        try{
            while (number !=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> CCCCCCCCCCCC");
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
}