package com.xinmu.Thread.Demo;

/**
 * @author xinmu
 * @date 2022/2/24 11:06
 * @description:
 */

//用线程模拟龟兔赛跑
public class Race implements Runnable {
   //胜利者
    private static String winner ;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            if (Thread.currentThread().getName().equals("兔子")&&i==20){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            //比赛结束停止程序
            if (flag) {
                break;
            }


            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }

    private boolean gameOver(int steps) {
        if(winner != null){
            return true;
        }
        {
            if(steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();


        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
