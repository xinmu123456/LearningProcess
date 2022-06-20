package com.xinmu.reflection;

import java.lang.annotation.ElementType;

/**
 * @author xinmu
 * @date 2022/3/4 20:07
 * @description:
 */
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2=Comparable.class;//接口
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5=Override.class;
        Class c6= ElementType.class;//枚举
        Class c7=Integer.class;
        Class c8=void.class;
        Class c9=Class.class;


        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);


        //只要元素类型与卫队一样,就是同一个class
        int[] a=new int[10];
        int[] b=new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());


    }
}
