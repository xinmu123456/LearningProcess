package com.MultiThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //CompletableFuture<Integer> cf = new CompletableFuture<>();
        //
        //System.out.println(cf.isDone());
        //
        //System.out.println(cf.complete(1));
        //
        //System.out.println(cf.isDone());

        //System.out.println(cf.get());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //CompletableFuture<Void> cf1 = CompletableFuture.supplyAsync(() -> {
        //    System.out.println(Thread.currentThread().getName());
        //    return "hello cf";
        //}, executorService).thenAcceptAsync(i -> {
        //    System.out.println(Thread.currentThread().getName());
        //    System.out.println(i);
        //}, executorService);
        //
        //CompletableFuture<Void> cf2 = CompletableFuture.supplyAsync(() -> {
        //    System.out.println(Thread.currentThread().getName());
        //    return "second supply";
        //}, executorService).thenCombine(cf1, (s1, s2) -> {
        //    System.out.println(s1 + s2);
        //    return s1 + s2;
        //}).thenAcceptAsync(s -> {
        //    System.out.println(s + ":then");
        //}, executorService);


        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("123");
            return "123456";
        }, executorService);

        CompletableFuture<?> vcf = CompletableFuture.supplyAsync(() -> {
            return "cf3";
        }, executorService).thenComposeAsync(s -> {
            System.out.println(s);
            return cf3.thenApply(i -> {
                System.out.println("accept " + i + s);
                return "d1";
            });
        }, executorService).thenAcceptAsync(data -> {
            System.out.println("data is " + data);
        }, executorService);

        vcf.get();

        //System.out.println(cf.isDone());

        //System.out.println(cf.get());


        executorService.shutdown();

    }

}
