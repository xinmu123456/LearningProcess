package com.xinmu.rpc.core.test.server;

import com.xinmu.rpc.IDL.Hello.HelloRequest;
import com.xinmu.rpc.IDL.Hello.HelloResponse;
import com.xinmu.rpc.IDL.Hello.HelloService;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 23:45
 */


public class HelloServiceImpl implements HelloService {

    @Override
    public HelloResponse hello(HelloRequest request) {
        String name = request.getName();
        String retMsg = "hello: " + name;
        return new HelloResponse(retMsg);
    }

    @Override
    public HelloResponse hi(HelloRequest request) {
        String name = request.getName();
        String retMsg = "hi: " + name;
        return new HelloResponse(retMsg);
    }
}
