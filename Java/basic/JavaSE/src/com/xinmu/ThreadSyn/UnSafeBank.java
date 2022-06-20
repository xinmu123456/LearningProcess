package com.xinmu.ThreadSyn;

/**
 * @author xinmu
 * @date 2022/2/25 11:13
 * @description:
 */

public class UnSafeBank {

}

//账户
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行，模拟取款
class Drawing extends Thread{
    //账户
    Account account;

    //取了多少钱
    int drawingMoney;

    //现在有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized(account){
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"余额不足，无法取钱");
                return;
            }
            try {
                //sleep可以放大问题的发生性
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money=account.money-drawingMoney;

            nowMoney=nowMoney+drawingMoney;

            System.out.println(account.name+"余额为："+account.money);

            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }

    }

    public static void main(String[] args) {
        Account account=new Account(100,"xinmu");
        Drawing you=new Drawing(account,50,"你");

        Drawing girlFriend=new Drawing(account,100,"girlFriend");
        new Thread(you).start();
        new Thread(girlFriend).start();
    }
}
