package com.xinmu.ThreadSyn;

/**
 * @author xinmu
 * @date 2022/2/25 17:01
 * @description:
 */

//死锁：多个线程相互抱着对方需要的资源，然后形成了僵持
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 =new MakeUp(0,"a");
        MakeUp girl2=new MakeUp(1,"b");

        girl1.start();
        girl2.start();
    }
}

//口红
class Lipstick {

}
//镜子
class Mirror{

}


class MakeUp extends Thread{
    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;//选择
    String grilName;//使用的人

    MakeUp(int choice,String grilName){
        this.choice=choice;
        this.grilName=grilName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized(lipstick){//获得口红的锁
                System.out.println(this.grilName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.grilName+"获得镜子的锁");
            }
        }else{
            synchronized(mirror){//获得口红的锁
                System.out.println(this.grilName+"获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.grilName+"获得口红的锁");
            }
        }
    }
}