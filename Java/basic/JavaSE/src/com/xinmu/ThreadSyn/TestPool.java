package com.xinmu.ThreadSyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xinmu
 * @date 2022/2/25 20:45
 * @description:测试线程池
 */


public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池,参数是线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2.关闭链接
        service.shutdownNow();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {

            System.out.println(Thread.currentThread().getName() );

    }
}