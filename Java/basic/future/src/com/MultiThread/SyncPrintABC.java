package com.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrintABC {
    public static void main(String[] args) {
        //ReentrantLock lock = new ReentrantLock();
        //
        //Condition c1 = lock.newCondition();
        //Condition c2 = lock.newCondition();
        //Condition c3 = lock.newCondition();
        //
        //new Thread(new PrintThread1(lock, c1, c2, "A", 0)).start();
        //new Thread(new PrintThread1(lock, c2, c3, "B", 1)).start();
        //new Thread(new PrintThread1(lock, c3, c1, "C", 2)).start();

        Object lock = new Object();

        new Thread(new PrintThread2(lock, 'A'), "A").start();
        new Thread(new PrintThread2(lock, 'B'), "B").start();
        new Thread(new PrintThread2(lock, 'C'), "C").start();

    }
}


class PrintThread1 implements Runnable {

    private Lock lock;
    private Condition self;
    private Condition next;

    private String letter;
    private int flag;
    private static int count = 0;


    public PrintThread1(Lock lock, Condition self, Condition next, String letter, int flag) {
        this.lock = lock;
        this.self = self;
        this.next = next;
        this.letter = letter;
        this.flag = flag;
    }

    @Override
    public void run() {

        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                while (count % 3 != flag) {
                    self.await();
                }
                System.out.println(letter);
                count++;
                next.signalAll();
            }
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }



    }
}

class PrintThread2 implements Runnable {


    public PrintThread2(Object lock, char letter) {
        this.lock = lock;
        this.letter = letter;
    }

    private final Object lock;

    private final char letter;

    private static int count = 0;


    @Override
    public void run() {

        synchronized (lock) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != ((letter) - 'A'))
                        lock.wait();
                    System.out.println(letter);
                    count++;
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {

            }

        }

    }
}