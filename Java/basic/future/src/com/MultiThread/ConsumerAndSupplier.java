package com.MultiThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.function.Supplier;

public class ConsumerAndSupplier {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        new Thread(new MyConsumer(queue, "C-1")).start();
        new Thread(new MyConsumer(queue, "C-2")).start();
        new Thread(new MySupplier(queue, "S-1", 10)).start();
        new Thread(new MySupplier(queue, "S-2", 10)).start();
    }
}

class MyConsumer implements Runnable {

    private Queue<Integer> queue;
    private String name;

    public MyConsumer(Queue<Integer> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("queue is empty consumer thread [" + name + "] is waiting for supply");
                        queue.wait();
                    } catch (InterruptedException e) {

                    }
                }
                int x = queue.poll();
                System.out.println("[" + name + "] is consuming value: " + x);
                queue.notifyAll();
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}


class MySupplier implements Runnable {

    public MySupplier(Queue<Integer> queue, String name, int maxSize) {
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
    }

    private Queue<Integer> queue;
    private String name;
    private int maxSize;

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                try {
                    while (queue.size() >= maxSize) {
                        System.out.println("queue is full thread [" + name + "] is waiting for consume");
                        queue.wait();
                    }
                } catch (InterruptedException e) {

                }
                int produce = new Random().nextInt(100);
                System.out.println("[" + name + "] supply value " +  produce);
                queue.offer(produce);
                queue.notifyAll();
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
