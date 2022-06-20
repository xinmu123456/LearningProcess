package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/4/3
 * time: 11:13
 */


public class Client {
    public static void main(String[] args) {
        Host host=new Host();

        //代理,中介帮房东租房子,但是,代理角色一般都会有一些附属操作
        Proxy proxy =new Proxy(host);

        //你不用面对房东,直接找中介租房即可
        proxy.rent();
    }
}
