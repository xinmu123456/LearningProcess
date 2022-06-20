package com.xinmu.deom04;

import com.xinmu.demo02.UserService;
import com.xinmu.demo02.UserServiceImpl;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 14:37
 */


public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService=new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        proxyInvocationHandler.setTarget(userService);//设置要代理的对象

        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.delete();

    }
}
