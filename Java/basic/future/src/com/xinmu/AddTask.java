package com.xinmu;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddTask {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 100;
        CountDownLatch latch = new CountDownLatch(2);
        ReentrantLock reentrantLock = new ReentrantLock();

        LinkedList<Integer> ans = new LinkedList<>();

        Thread t1 = new Thread(new Task(1, n / 2, latch, ans, reentrantLock));
        Thread t2 = new Thread(new Task(n / 2 + 1, n , latch, ans, reentrantLock));

        t1.start();
        t2.start();

        //t1.run();
        //t2.run();

        try {
            latch.await();
            System.out.printf("和为: %d%n", ans.stream().reduce(0 , Integer::sum));
            System.out.printf("take time: %d%n", System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}


class Task implements Callable<Integer> , Runnable{

    private final int begin;
    private final int end;

    CountDownLatch latch;

    private List<Integer> addTo;

    private Lock ansLock;

    @Override
    public Integer call() throws Exception {
        //System.out.println(Thread.currentThread().getId());
        int ret = 0;
        for (int i = begin; i <= end; i ++) {
            ret += i;
        }
        return ret;
    }

    public Task(int begin, int end, CountDownLatch latch){
        this.begin = begin;
        this.end = end;
        this.latch = latch;
    }

    public Task(int begin, int end, CountDownLatch latch, List<Integer> addTo, Lock lock){
        this.begin = begin;
        this.end = end;
        this.latch = latch;
        this.addTo = addTo;
        this.ansLock = lock;
    }

    @Override
    public void run() {
        try {
            Integer ret = call();
            ansLock.lock();
            addTo.add(ret);
            ansLock.unlock();
            latch.countDown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}