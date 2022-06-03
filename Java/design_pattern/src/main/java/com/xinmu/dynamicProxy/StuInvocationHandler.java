package com.xinmu.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 17:41
 */


public class StuInvocationHandler<T> implements InvocationHandler {
    //代理对象
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    // proxy:动态代理对象 method:正在执行的方法 args:传入的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行:" + method.getName() + "方法");
        //插入检测方法,计算方法的耗时
        MonitorUntil.start();
        Object result = method.invoke(target, args);
        MonitorUntil.finish(method.getName());
        return result;
    }
}
