package com.xinmu;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class _01_future {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白点菜");
        long startTime = System.currentTimeMillis();

        //// 点菜
        //ArrayList<Dish> dishes = new ArrayList<Dish>();
        //
        //for (int i = 0; i < 10; i++) {
        //    Dish dish = new Dish("菜" + i, 1);
        //    dishes.add(dish);
        //}
        //
        //// 做菜
        //ArrayList<CompletableFuture> cfList = new ArrayList<>();
        //for (Dish dish : dishes) {
        //    CompletableFuture<Void> cf =  CompletableFuture.runAsync(() -> dish.make());
        //    cfList.add(cf);
        //}

        CompletableFuture[] dishes = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Dish("菜" + i, 1))
                .map(dish -> CompletableFuture.runAsync(dish::make))
                .toArray(size -> new CompletableFuture[size]);



        // 等待所有的任务都执行完毕
        CompletableFuture.allOf(dishes).join();

        SmallTool.printTimeAndThread("菜都做完了, 上桌" + (System.currentTimeMillis() - startTime));

    }
}
