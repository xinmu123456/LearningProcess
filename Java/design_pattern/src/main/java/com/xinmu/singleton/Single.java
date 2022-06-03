package com.xinmu.singleton;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 13:17
 */


public class Single {
    //volatile禁止指令重排序
    private volatile static Single instance;

    private Single(){
        //每次创建都会打印日志
        System.out.println("创建了single对象");
    }

    public static Single getInstance(){
        if (instance == null) {
            synchronized (Single.class){
                if (instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
