package com.xinmu;

import java.util.SortedMap;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Dish {

    // 菜名
    private String name;

    // 制作时间
    private Integer productionTime;

    public Dish(String name, Integer productionTime){
        this.name = name;
        this.productionTime = productionTime;
    }

    // 做菜

    public void make(){
        SmallTool.sleepMillis(TimeUnit.SECONDS.toMillis(this.productionTime));
        SmallTool.printTimeAndThread(this.name + "制作完毕, 赶紧吃吧");

    }

}
