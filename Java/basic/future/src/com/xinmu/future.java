package com.xinmu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class future {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getId());
        //    CompletableFuture<Void> subThread = CompletableFuture.supplyAsync(() -> {
        //        System.out.println(Thread.currentThread().getId());
        //        try {
        //            TimeUnit.SECONDS.sleep(1);
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
        //        System.out.println("over for future");
        //        return  "over!";
        //    }).thenApplyAsync(msg -> {
        //        System.out.println(Thread.currentThread().getId());
        //        System.out.println(msg);
        //        return "task2 over";
        //    }).thenAcceptAsync(msg -> {
        //        System.out.println(Thread.currentThread().getId());
        //        System.out.println(msg);
        //    });
        //    TimeUnit.SECONDS.sleep(1);
        //
        //    subThread.get();
        //
        //    System.out.println("over for main");
        //

        //CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        //    System.out.println(Thread.currentThread().getId());
        //    System.out.println("thread1 running");
        //    try {
        //        Thread.sleep(300);
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //    System.out.println("thread1 over");
        //    return "thread1 return";
        //}).thenCombine(CompletableFuture.supplyAsync(() -> {
        //    System.out.println(Thread.currentThread().getId());
        //    System.out.println("thread2 running");
        //    try {
        //        Thread.sleep(200);
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //    System.out.println("thread2 over");
        //    return "thread2 over";
        //}), (ret1, ret2) -> {
        //    return ret1 + ret2;
        //});


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getId());
            System.out.println("thread1 running");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread1 over");
            return "thread1 return";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getId());
            System.out.println("thread2 running");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread2 over");
            return "thread2 over";
        }), (ret1) -> {
            return ret1;
        });

        System.out.println(future.get());

    }

}
