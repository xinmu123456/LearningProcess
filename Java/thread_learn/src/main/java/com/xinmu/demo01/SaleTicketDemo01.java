package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 13:29
 */


public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

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

class Ticket{
    private int number = 30;

    //sync本质: 队列 锁
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+ "卖出了" + (number--) + "剩余:" + number);
        }
    }
}
