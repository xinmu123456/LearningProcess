package com.xinmu.ThreadState;

/**
 * @author xinmu
 * @date 2022/2/25 9:46
 * @description:
 */

//测试join方法
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("THREAD VIP IS COMING "+i);
        }
    }

    public static void main(String[] args) {
        //启动我们的线程
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 500; i++) {
            if (i==200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MAIN "+i);
        }
    }
}


