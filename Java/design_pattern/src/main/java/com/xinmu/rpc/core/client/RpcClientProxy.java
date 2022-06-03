package com.xinmu.rpc.core.client;

import com.xinmu.rpc.core.codec.RpcRequestBody;
import com.xinmu.rpc.core.codec.RpcResponseBody;
import com.xinmu.rpc.core.rpc_protocol.RpcRequest;
import com.xinmu.rpc.core.rpc_protocol.RpcResponse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:36
 */

//客户端的代理对象
public class RpcClientProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //1.将调用所需的信息编码成byte[]字节, 调用编码
        RpcRequestBody rpcRequestBody = RpcRequestBody.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .paramTypes(method.getParameterTypes())
                .parameters(args)
                .build();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(rpcRequestBody);
        byte[] bytes = baos.toByteArray();

        //2.创建Rpc协议,设置好header,body
        RpcRequest rpcRequest = RpcRequest.builder()
                .header("version=1")
                .body(bytes)
                .build();

        //3.发送RpcRequest, 获得RpcResponse
        RpcClientTransfer rpcClient = new RpcClientTransfer();
        RpcResponse rpcResponse = rpcClient.sendRequest(rpcRequest);


        //4.解析返回的RpcResponse,即解析rpc协议
        String header = rpcResponse.getHeader();
        byte[] body = rpcResponse.getBody();
        if (header.equals("version=1")){
            //反编码body
            ByteArrayInputStream bais = new ByteArrayInputStream(body);
            ObjectInputStream ois = new ObjectInputStream(bais);
            RpcResponseBody rpcResponseBody = (RpcResponseBody) ois.readObject();
            Object retObject = rpcResponseBody.getRetObject();
            return retObject;
        }


        return null;
    }
}
