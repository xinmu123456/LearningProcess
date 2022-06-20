package com.xinmu.demo03;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 14:26
 */


public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host=new Host();

        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //通过调用程序处理角色来处理我们要调用的接口对象
        proxyInvocationHandler.setRent(host);

        Rent proxy = (Rent) proxyInvocationHandler.getProxy();//这里的proxy是动态生成的

        proxy.rent();

    }
}
