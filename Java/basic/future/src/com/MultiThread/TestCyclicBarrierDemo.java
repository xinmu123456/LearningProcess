package com.MultiThread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class TestCyclicBarrierDemo {


    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
        System.out.println("优先处理");
    });

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);



        IntStream.range(0, 4)
                .forEach(i -> {
                    fixedThreadPool.execute(() -> {
                        System.out.println("thread num : " + i + " is ready");
                        try {
                            Thread.sleep(1000);
                            cyclicBarrier.await(60, TimeUnit.SECONDS);
                            System.out.println(cyclicBarrier.getNumberWaiting());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        } catch (TimeoutException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("thread num : " + i + " is over");
                    });
                });

        fixedThreadPool.shutdown();

    }
}
