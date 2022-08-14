package com.xinmu;

import java.util.concurrent.CompletableFuture;

public class _01_supplyAsync {

    // demo01
    /*
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("炒菜");
            SmallTool.sleepMillis(200);
            SmallTool.printTimeAndThread("打饭");
            SmallTool.sleepMillis(100);
            return "炒好了";
        });
        SmallTool.printTimeAndThread("打王者");
        SmallTool.printTimeAndThread(String.format("%s, 吃饭", cf1.join()));
    }
    */


    //demo2
    /*
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("炒菜");
            SmallTool.sleepMillis(200);
            return "炒好了";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return  dish + "+ 米饭";
        }));
        SmallTool.printTimeAndThread("打王者");
        SmallTool.printTimeAndThread(String.format("%s, 吃饭", cf1.join()));
    }
    */

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("炒菜");
            SmallTool.sleepMillis(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return  "米饭";
        }), (dish, rice) -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return String.format("%s + %s 好了", dish, rice);
        });
        SmallTool.printTimeAndThread("打王者");
        SmallTool.printTimeAndThread(String.format("%s, 吃饭", cf1.join()));
    }



}
