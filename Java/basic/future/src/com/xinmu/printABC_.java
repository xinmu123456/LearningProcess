package com.xinmu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printABC_ {

    public static Integer count = 0;

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        Thread t1 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count + 1 <= 100) {
                    System.out.println("A");
                    count++;
                }
                B.signal();
                try {
                    A.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count + 1 <= 100) {
                    System.out.println("B");
                    count++;
                }
                C.signal();
                try {
                    B.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                lock.lock();
                if (count + 1 <= 100){
                    System.out.println("C");
                    count ++;
                }
                A.signal();
                try {
                    C.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }



}
