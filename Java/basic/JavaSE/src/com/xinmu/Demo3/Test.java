package com.xinmu.Demo3;

/**
 * @author xinmu
 * @date 2022/1/19 23:53
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Outer outer=new Outer();
        outer.out();
        outer.new Inner().in();
    }
}
