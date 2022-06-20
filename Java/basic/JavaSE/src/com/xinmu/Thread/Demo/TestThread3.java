package com.xinmu.Thread.Demo;

/**
 * @author xinmu
 * @date 2022/2/24 10:20
 * @description:
 */

//创建线程方式2：实现runnable接口，重写run方法，执行线程需要runnable接口的实现类，再调用start方法
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<100;i++)
        {
            System.out.println("我在看代码"+i);
        }

    }

    public static void main(String[] args) {
        //创建一个runnable接口的实现类对象
        TestThread3 testThread3=new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }

}
