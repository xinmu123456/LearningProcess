package com.xinmu;

import java.util.concurrent.*;

public class _01_ThreadPool {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        CompletableFuture.runAsync(() -> SmallTool.printTimeAndThread("A"), executor)
                .thenRunAsync(() -> SmallTool.printTimeAndThread("B"), executor)
                .join();


    }
}
