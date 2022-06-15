package com.xinmu.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 13:37
 */


public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket02 ticket = new Ticket02();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}
class Ticket02{
    private int number = 30;

    Lock lock = new ReentrantLock();

    //lock三步
    //1.new ReentrantLock()
    //2. lock.lock() 加锁
    //3. finally 解锁
    public void sale(){

        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+ "卖出了" + (number--) + "剩余:" + number);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}