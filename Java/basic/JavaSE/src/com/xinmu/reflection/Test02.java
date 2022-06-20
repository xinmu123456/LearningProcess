package com.xinmu.reflection;

import java.util.Arrays;

import static oracle.jrockit.jfr.events.Bits.swap;

/**
 * @author xinmu
 * @date 2022/3/4 20:23
 * @description:
 */
public class Test02 {
    public static void main(String[] args) {

        T t = new T();
        t.a=10;
        t.b=20;


        change(t.a,t.b);
        t.change1();
        System.out.println("a="+t.a);
        System.out.println("b="+t.b);



    }

    public static void change(int a, int b){
        int temp= a;
        a=b;
        b=temp;
    }
}
class T {
    public int a;
    public int b;
  public void change1(){
    int temp= this.a;
    this.a=this.b;
    this.b=temp;
  }

}
