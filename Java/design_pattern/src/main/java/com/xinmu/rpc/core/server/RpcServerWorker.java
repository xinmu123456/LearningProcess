package com.xinmu.rpc.core.server;

import com.xinmu.rpc.core.codec.RpcRequestBody;
import com.xinmu.rpc.core.codec.RpcResponseBody;
import com.xinmu.rpc.core.rpc_protocol.RpcRequest;
import com.xinmu.rpc.core.rpc_protocol.RpcResponse;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 23:21
 */


public class RpcServerWorker implements Runnable {
    private final Socket socket;
    private final HashMap<String, Object> registeredService;

    public RpcServerWorker(Socket socket, HashMap<String, Object> registeredService){
        this.socket = socket;
        this.registeredService = registeredService;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //1.transfer层传输
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();

            //2.解析版本号
            if (rpcRequest.getHeader().equals("version=1")){

                //3.解码body
                byte[] body = rpcRequest.getBody();
                ByteArrayInputStream bais = new ByteArrayInputStream(body);
                ObjectInputStream ois = new ObjectInputStream(bais);
                RpcRequestBody rpcRequestBody = (RpcRequestBody)ois.readObject();

                //4. 反射  调用服务
                Object service = registeredService.get(rpcRequestBody.getInterfaceName());
                Method method = service.getClass().getMethod(rpcRequestBody.getMethodName(), rpcRequestBody.getParamTypes());
                //方法执行后的结果
                Object returnObject = method.invoke(service, rpcRequestBody.getParameters());

                //5.将方法返回的结果编码成bytes[]字节流 (codec层)
                RpcResponseBody rpcResponseBody = RpcResponseBody.builder()
                        .retObject(returnObject)
                        .build();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(rpcResponseBody);
                byte[] bytes = baos.toByteArray();

                //6. 将返回的编码作为body,再加上header 生成rpc协议
                RpcResponse rpcResponse = RpcResponse.builder()
                        .header("version=1")
                        .body(bytes)
                        .build();

                //7. 发送
                objectOutputStream.writeObject(rpcResponse);
                objectOutputStream.flush();
            }

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
