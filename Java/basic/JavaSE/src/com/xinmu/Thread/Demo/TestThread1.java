package com.xinmu.Thread.Demo;

/**
 * @author xinmu
 * @date 2022/2/23 22:49
 * @description:
 */


//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
//线程开启不一定立即执行，由cpu调度执行
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体

        for (int i = 0;i<20;i++)
        {
            System.out.println("我在看代码");
        }

    }

    public static void main(String[] args) {
        //main主线程


        //创建一个线程对象
        TestThread1 testThread1=new TestThread1();
        //调用start方法开启线程
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程");
        }
    }
}
