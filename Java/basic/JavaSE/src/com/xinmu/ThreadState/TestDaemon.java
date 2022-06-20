package com.xinmu.ThreadState;

/**
 * @author xinmu
 * @date 2022/2/25 10:37
 * @description:
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread=new Thread(god);
        thread.setDaemon(true);//false是表示是用户线程

        thread.start();

        new Thread(you).start();

    }
}

//上帝
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}

//你
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着");
        }
        System.out.println("goodbye world");
    }
}