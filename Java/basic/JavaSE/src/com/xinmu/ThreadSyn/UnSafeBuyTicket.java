package com.xinmu.ThreadSyn;

/**
 * @author xinmu
 * @date 2022/2/25 10:58
 * @description:
 */
public class UnSafeBuyTicket {

}

class BuyTicket implements Runnable {
    private int ticketNums =50;
    boolean flag = true;//外部停止方式

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"I ").start();
        new Thread(station,"YOU ").start();
        new Thread(station,"He ").start();
    }
    @Override
    public void run() {
        while(flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if(ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }


}
