package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 12:41
 */


public class Wait_Notify_Odd_Even {

    private Object monitor = new Object();
    private volatile int count;

    Wait_Notify_Odd_Even(int initCount){
        this.count = initCount;
    }

    public void printOddEven(){
        synchronized (monitor){
            while (count < 10){
                try{
                    System.out.println(Thread.currentThread().getName() + ":" + (++count));
                    monitor.notifyAll();
                    monitor.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Wait_Notify_Odd_Even waitNotifyOddEven = new Wait_Notify_Odd_Even(0);
        new Thread(waitNotifyOddEven::printOddEven, "odd").start();
        Thread.sleep(10); //为了保证线程odd先拿到锁
        new Thread(waitNotifyOddEven::printOddEven, "even").start();
    }
}
