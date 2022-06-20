package com.xinmu.Thread.Demo;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * @author xinmu
 * @date 2022/2/24 10:46
 * @description:
 */

//多个线程操作同个对象

//多个线程操作同个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements Runnable {
    private int ticketNumber=10;


    @Override
    public void run() {
        while(true){
            if(ticketNumber<=0)
            {
                break;
            }
            try {
                Thread.sleep(200);
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
