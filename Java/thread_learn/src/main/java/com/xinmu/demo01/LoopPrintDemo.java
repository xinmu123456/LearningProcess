package com.xinmu;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 10:21
 */


public class LoopPrintDemo {
    public static void main(String[] args) {

        Flag flag = new Flag(0);

        ThreadA threadA = new ThreadA(flag);
        ThreadB threadB = new ThreadB(flag);

        threadA.start();
        threadB.start();
    }
}

class ThreadA extends Thread{
    private Flag flag;

    public ThreadA(Flag flag){
        this.flag = flag;
    }

    @Override
    public void run() {



        while (true){
            for (int i = 0; i < 26; i++) {
                System.out.print((char)( i +'a'));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                flag.change2PrintNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class ThreadB extends Thread{

    private Flag flag;

    public ThreadB(Flag flag){
        this.flag = flag;
    }

    @Override
    public void run() {


        while (true){
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                flag.change2PrintChar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

class Flag {
    public Integer flag;

    public Flag(Integer flag) {
        this.flag = flag;
    }

    public synchronized void change2PrintNum() throws InterruptedException {
        if (flag == 1){
            wait();
            System.out.println("打印字符线程 flag: " + flag);
            System.out.println("打印字符线程阻塞");
        }
        flag = 0;
        notify();
    }

    public synchronized void change2PrintChar() throws InterruptedException {
        if (flag == 0){
            wait();
            System.out.println("打印数字线程 flag: " + flag);
            System.out.println("打印数字线程阻塞");
        }
        flag = 1;
        notify();
    }

}