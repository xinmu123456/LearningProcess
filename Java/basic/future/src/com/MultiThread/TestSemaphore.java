package com.MultiThread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class TestSemaphore {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10 + 5, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        final Semaphore semaphore = new Semaphore(3);

        IntStream.range(0, 100)
                .forEach(i -> {
                    threadPoolExecutor.submit(() -> {
                        try {
                            semaphore.acquire();
                            Thread.sleep(random.nextInt(100));
                            System.out.println("thread num: " + i + " thread-" + Thread.currentThread().getName());
                            Thread.sleep(random.nextInt(100));
                        } catch (InterruptedException e) {

                        } finally {
                            semaphore.release();
                        }
                    });

                });

        Thread.sleep(2000);
        System.out.println("over");
        threadPoolExecutor.shutdown();
    }
}
