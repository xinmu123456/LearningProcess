package com.xinmu.rpc.core.client;

import com.xinmu.rpc.core.rpc_protocol.RpcRequest;
import com.xinmu.rpc.core.rpc_protocol.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:50
 */


public class RpcClientTransfer {

    public RpcResponse sendRequest(RpcRequest rpcRequest){
        try(Socket socket = new Socket("localhost", 9000);) {
            //发送 transfer层
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            RpcResponse rpcResponse = (RpcResponse)objectInputStream.readObject();

            return rpcResponse;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
