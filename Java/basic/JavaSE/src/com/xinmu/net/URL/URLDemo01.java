package com.xinmu.net.URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xinmu
 * @date 2022/3/3 22:27
 * @description:
 */
public class URLDemo01 {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=123&passworld=123");
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//ip
        System.out.println(url.getPort());//端口
        System.out.println(url.getPath());//路径
        System.out.println(url.getFile());//文件
        System.out.println(url.getQuery());//参数

    }

}
