package com.xinmu;


import java.util.LinkedList;
import java.util.Queue;

/**
 * author: xinmu
 * date: 2022/6/15
 * time: 9:56
 */


public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);
        consumer.start();
        producer.start();
    }



}


class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.add(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int val = 0;
            try {
                val = buffer.pull();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(val);
        }
    }
}

class Buffer{

    private Queue<Integer> queue = new LinkedList<>();
    private  int size = 5;

    public synchronized void add(int val) throws InterruptedException {
        if (queue.size() >= size){
            System.out.println("剩余数据过多生产者已被阻塞");
            wait(); //阻塞生产者
        }
        queue.add(val);
        System.out.println("生产者生产了数据:" + val + " 目前剩余数据量:" + queue.size());
        notify(); // 通知消费者去消费
    }

    public synchronized int pull() throws InterruptedException {
        if (queue.size() == 0){
            System.out.println("剩余数据不足消费者已被阻塞");
            wait();
        }
        int val = queue.poll();
        System.out.println("消费者消费了数据:" + val + " 目前剩余数据量:" + queue.size());
        notify();
        return val;
    }


}