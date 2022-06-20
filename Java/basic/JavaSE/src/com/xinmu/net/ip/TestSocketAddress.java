package com.xinmu.net.ip;

import java.net.InetSocketAddress;

/**
 * @author xinmu
 * @date 2022/2/26 10:59
 * @description:
 */
public class TestSocketAddress {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketAddress);
        socketAddress = new InetSocketAddress("localhost",8080);
        System.out.println(socketAddress);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());//地址
        System.out.println(socketAddress.getPort());//端口



    }
}
