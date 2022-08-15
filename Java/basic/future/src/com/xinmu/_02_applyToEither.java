package com.xinmu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class _02_applyToEither {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("张三走出餐厅, 来到公交站");
        SmallTool.printTimeAndThread("等待 700路 或者 800 路公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("700路公交正在赶来");
            SmallTool.sleepMillis(100);
            return "700路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("800路公交正在赶来");
            SmallTool.sleepMillis(200);
            return "800路到了";
        }), firstComeBus -> {
            SmallTool.printTimeAndThread(firstComeBus);
            if (firstComeBus.startsWith("700")){
                throw new RuntimeException("撞车了");
            }
            return firstComeBus;
        }).exceptionally(e -> {
            SmallTool.printTimeAndThread(e.getLocalizedMessage());
            SmallTool.printTimeAndThread("小白叫出租车");
            return "出租车到了";
        });

        SmallTool.printTimeAndThread(String.format("%s, 小白做车回家", bus.join()));
    }
}
