package com.MultiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestVolatile {

    volatile static int data = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                data++;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                data++;
            }
        }).start();

        //FutureTask<Integer> task1 = new FutureTask<>(() -> {
        //    for (int i = 0; i < 10000; i++) {
        //        synchronized (TestVolatile.class) {
        //            data++;
        //        }
        //    }
        //    return data;
        //});

        //FutureTask<Integer> task2 = new FutureTask<>(() -> {
        //    for (int i = 0; i < 10000; i++) {
        //        synchronized (TestVolatile.class) {
        //            data++;
        //        }
        //    }
        //    return data;
        //});
        //
        //new Thread(task1).start();
        //new Thread(task2).start();



        Thread.sleep(100);
        System.out.println(data);

        //System.out.println(task1.get());


    }


}
