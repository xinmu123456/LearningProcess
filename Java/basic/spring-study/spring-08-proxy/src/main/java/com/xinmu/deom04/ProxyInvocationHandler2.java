package com.xinmu.deom04;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: xinmu
 * date: 2022/4/18
 * time: 19:58
 */


public class ProxyInvocationHandler2 implements InvocationHandler {
    //代理的接口(任何)
    private Object target;

    //设置代理的接口
    public void setTarget(Object target) {
        this.target = target;
    }

    //生成代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader()
                ,target.getClass().getInterfaces()
                ,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sayHello(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void sayHello(String msg) {
        System.out.println("hello~=>"+msg);
    }
}
