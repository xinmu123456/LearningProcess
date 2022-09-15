package com.xinmu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CalculTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int n = 6;

        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 0; i <= n / 2; i++) {
                sum += i;
            }
            return sum;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = n / 2 + 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }), (r1, r2) -> {
            return r1 + r2;
        });

        System.out.println(task.get());

    }
}
