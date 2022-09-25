package com.xinmu;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TestWait {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object lock = new Object();
        Logger log = Logger.getLogger(TestWait.class);
        FutureTask<Integer> taskA = new FutureTask<>(() -> {
            synchronized (lock) {
                log.info("get lock");
                log.info("休眠一会");
                TimeUnit.SECONDS.sleep(1);
                log.info("准备调用wait A wait前的状态为" + Thread.currentThread().getState());
                lock.wait();
                log.info("被唤醒");
            }
            return 0;
        });
        Thread threadA = new Thread(taskA, "A");
        threadA.start();

        FutureTask<Integer> taskB = new FutureTask<>(() -> {
            synchronized (lock) {
                log.info("get lock");
                log.info("准备唤醒A 当前其状态为" + threadA.getState());
                lock.notify();
                log.info("已经唤醒A 当前其状态为" + threadA.getState());
            }
            return 0;
        });

        Thread threadB = new Thread(taskB, "B");
        threadB.start();

        System.out.println(taskA.get());
        System.out.println(taskB.get());

    }
}
