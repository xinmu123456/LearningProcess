package com.xinmu.demo01;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 10:21
 */


public class LoopPrintDemo {
    public static void main(String[] args) {

        Flag flag = new Flag(0);
        System.out.println(flag.hashCode());

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
        System.out.println(this.flag.hashCode());
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
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
        System.out.println(this.flag.hashCode());
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
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
        while (this.flag != 0){
            this.wait();
            System.out.println("打印字符线程 flag: " + flag);
            System.out.println("打印字符线程阻塞");
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            if (i == 9){
                System.out.println();
            }
        }
        flag = 1;
        this.notify();
    }

    public synchronized void change2PrintChar() throws InterruptedException {
        while (this.flag != 1){
            this.wait();
            System.out.println("打印数字线程 flag: " + flag);
            System.out.println("打印数字线程阻塞");
        }
        for (int i = 0; i < 26; i++) {
            System.out.print((char)( i +'a'));
            if (i == 25){
                System.out.println();
            }
        }
        flag = 0;
        this.notify();
    }

}