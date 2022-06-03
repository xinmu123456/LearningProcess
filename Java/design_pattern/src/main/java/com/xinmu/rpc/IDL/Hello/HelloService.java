package com.xinmu.rpc.IDL.Hello;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:20
 */


public interface HelloService {
    HelloResponse hello(HelloRequest request);
    HelloResponse hi(HelloRequest request);
}
