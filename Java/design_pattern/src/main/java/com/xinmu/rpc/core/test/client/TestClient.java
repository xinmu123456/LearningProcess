package com.xinmu.rpc.core.test.client;

import com.xinmu.rpc.IDL.Hello.HelloRequest;
import com.xinmu.rpc.IDL.Hello.HelloResponse;
import com.xinmu.rpc.IDL.Hello.HelloService;
import com.xinmu.rpc.core.client.RpcClientProxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 23:50
 */


public class TestClient {
    public static void main(String[] args) {
        //获取RpcService
        RpcClientProxy proxy = new RpcClientProxy();
        HelloService helloService = proxy.getService(HelloService.class);

        //构造出请求对象
        HelloRequest helloRequest = new HelloRequest("xinmu");

        //通过rpc调用
        HelloResponse helloResponse = helloService.hello(helloRequest);
        //获取msg
        String helloMsg = helloResponse.getMsg();
        //打印
        System.out.println(helloMsg);

        //调用hi方法
        HelloResponse hiResponse = helloService.hi(helloRequest);
        String hiMsg = hiResponse.getMsg();
        System.out.println(hiMsg);

    }
}
