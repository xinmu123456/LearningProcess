package com.xinmu.demo02;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 11:33
 */


public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();


        UserServiceProxy proxy=new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.add();
    }
}
