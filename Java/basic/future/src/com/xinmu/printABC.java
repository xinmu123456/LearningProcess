package com.xinmu;

public class printABC {

    public static Integer state = 0;

    public static Object lock = new Object();

    public static Integer count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if (count + 1 <= 100 && state == 0){
                        System.out.println("A");
                        //lock.notifyAll();
                        count ++;
                        state = 1;
                        //try {
                        //    lock.wait();
                        //} catch (InterruptedException e) {
                        //    throw new RuntimeException(e);
                        //}
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if (count + 1 <= 100 && state == 1){
                        System.out.println("B");
                        //lock.notifyAll();
                        count ++;
                        state = 2;
                        //try {
                        //    lock.wait();
                        //} catch (InterruptedException e) {
                        //    throw new RuntimeException(e);
                        //}
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if (count + 1 <= 100 && state == 2){
                        System.out.println("C");
                        //lock.notifyAll();
                        count ++;
                        state = 0;
                        //try {
                        //    lock.wait();
                        //} catch (InterruptedException e) {
                        //    throw new RuntimeException(e);
                        //}

                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();


    }

}
