package com.MultiThread;

public class SingleTest {
    private static volatile SingleTest INSTANCE = null;

    public static SingleTest getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTest.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTest();
                }
            }
        }
        return INSTANCE;
    }


    private SingleTest() {

    }


    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SingleTest instance = getInstance();
                System.out.println(instance);
            }
        }).start();

    }
}
