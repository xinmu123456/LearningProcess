package com.xinmu.rpc.core.test.server;

import com.xinmu.rpc.IDL.Hello.HelloService;
import com.xinmu.rpc.core.server.RpcServer;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 23:48
 */


public class TestServer {
    public static void main(String[] args) {
        //rpc的服务接口
        RpcServer rpcServer = new RpcServer();

        //服务实现
        HelloService helloService = new HelloServiceImpl();

        //登记服务
        rpcServer.register(helloService);

        //在9000服务开启在9000端口
        rpcServer.serve(9000);

    }
}
