package com.xinmu.deom04;

import com.xinmu.demo03.Host;
import com.xinmu.demo03.Rent;

/**
 * author: xinmu
 * date: 2022/4/18
 * time: 19:52
 */


public class Client2 {
    public static void main(String[] args) {
        //真实的角色
        Host host = new Host();

        //代理
        ProxyInvocationHandler2 proxyInvocationHandler2 = new ProxyInvocationHandler2();

        proxyInvocationHandler2.setTarget(host);

        Rent proxy = (Rent) proxyInvocationHandler2.getProxy();

        proxy.rent();

    }
}
