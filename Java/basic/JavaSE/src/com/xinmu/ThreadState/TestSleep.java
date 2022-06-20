package com.xinmu.ThreadState;

import com.xinmu.Thread.Demo.TestThread4;

/**
 * @author xinmu
 * @date 2022/2/24 21:24
 * @description:
 */

//模拟网络延时
public class TestSleep implements Runnable{
    private int ticketNumber=10;


    @Override
    public void run() {
        while(true){
            if(ticketNumber<=0)
            {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNumber--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();

        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();

    }
}
