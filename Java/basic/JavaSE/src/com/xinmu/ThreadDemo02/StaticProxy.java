package com.xinmu.ThreadDemo02;

/**
 * @author xinmu
 * @date 2022/2/24 20:33
 * @description:
 */

//静态代理模式：
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实对象
//好处：1>代理对象可以做很多真实对象做不了的事情 2>真实对象只需要专注于自己的事情

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}

//真实对象
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println(" happy marry ");
    }
}

//代理对象
class WeddingCompany implements Marry{
    //要代理的目标对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();

        this.target.HappyMarry();

        after();
    }

    private void after() {
        System.out.println("收尾款");
    }

    private void before() {
        System.out.println("布置现场");
    }
}