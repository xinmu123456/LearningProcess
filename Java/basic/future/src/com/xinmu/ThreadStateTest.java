package com.xinmu;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadStateTest {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        Thread thread = new Thread();
        System.out.println("1-" + thread.getState());
        thread.start();
        System.out.println("2-" + thread.getState());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("产生中断" + e.getMessage());
        }
        System.out.println("3-" + thread.getState());
    }
}
