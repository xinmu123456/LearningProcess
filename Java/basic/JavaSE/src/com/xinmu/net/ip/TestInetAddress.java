package com.xinmu.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xinmu
 * @date 2022/2/26 10:25
 * @description:
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);

            inetAddress=InetAddress.getByName("localhost");
            System.out.println(inetAddress);

            inetAddress=InetAddress.getLocalHost();
            System.out.println(inetAddress);

            //查询网站地址
            inetAddress=InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);

            //常用方法
            System.out.println(inetAddress.getAddress());
            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println(inetAddress.getHostAddress());//ip
            System.out.println(inetAddress.getHostName());//域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
