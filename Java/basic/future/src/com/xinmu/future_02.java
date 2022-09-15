package com.xinmu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class future_02 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getId());

        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getId());
            Thread.sleep(1000);
            return 3;
        });

        new Thread(task).start();

        Thread.sleep(500);
        System.out.println(task.get());

        System.out.println(System.currentTimeMillis() - start);
    }
}
