package com.xinmu.reflection;

/**
 * @author xinmu
 * @date 2022/3/4 20:45
 * @description:类加载机制
 */
public class Test05 {
    public static void main(String[] args) {
        A a=new A();
        System.out.println(A.m);
        /*
        1.加载到内存,会产生一个类对于的class对象;
        2.链接,链接结束后m=0;
        3.初始化
           <clinit>(){
                   m=100;
                   System.out.println("A类的静态代码块初始化");
                   m =300;
           }
         */
    }
}

class  A{
    static  int m = 100;

    static{
        System.out.println("A类的静态代码块初始化");
        m =300;
    }
    public A(){
        System.out.println("A类的无参构造初始化");
    }

}
