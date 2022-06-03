package com.xinmu.rpc.core.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 23:08
 */

public class RpcServer {
    private final ExecutorService threadPool;

    private final HashMap<String, Object> registeredService;

    public RpcServer() {

        //服务线程池
        int corePoolSize = 5;
        int maximumPoolSize = 50;
        long keepAliveTime = 60;
        ArrayBlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        this.threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workingQueue, threadFactory);
        this.registeredService = new HashMap<String, Object>();
    }

    public void register(Object service){
        System.out.println("server class type:" + service.getClass().getInterfaces()[0].getName());
        registeredService.put(service.getClass().getInterfaces()[0].getName(), service);
    }

    public void serve(int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server starting...");
            Socket handleSocket;
            while ((handleSocket = serverSocket.accept())!=null){
                System.out.println("client connected, ip:" + handleSocket.getInetAddress());
                threadPool.execute(new RpcServerWorker(handleSocket, registeredService));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
