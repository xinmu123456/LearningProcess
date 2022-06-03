package com.xinmu.dynamicProxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:34
 */


public class MonitorUntil {

    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start(){
        tl.set(System.currentTimeMillis());
    }

    //结束打印实践
    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }


}
