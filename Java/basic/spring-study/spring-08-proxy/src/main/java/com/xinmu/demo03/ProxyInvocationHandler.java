package com.xinmu.demo03;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 14:19
 */

//我们会用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent){
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    //处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质就是使用反射机制
        seeHouse();

        Object result = method.invoke(rent, args);

        fare();

        return result;
    }

    public void seeHouse(){
        System.out.println("中介带看负责");
    }

    public void fare(){
        System.out.println("收中介费");
    }
}
