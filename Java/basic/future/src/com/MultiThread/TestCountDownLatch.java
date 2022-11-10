package com.MultiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(300);


        CountDownLatch countDownLatch = new CountDownLatch(10);

        IntStream.range(0, 300)
                .forEach(i -> {
                    executorService.submit(() -> {
                        try {
                            Thread.sleep(100);
                            System.out.println("thread num : " + i + " thread in " + Thread.currentThread().getName());


                            Thread.sleep(200);
                            System.out.println("current count:" + countDownLatch.getCount());
                            countDownLatch.countDown();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    });
                });

        executorService.shutdown();

        countDownLatch.await();

        System.out.println("main over");

    }
}
