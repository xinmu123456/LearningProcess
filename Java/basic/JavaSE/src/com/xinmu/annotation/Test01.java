package com.xinmu.annotation;

import java.util.ArrayList;

/**
 * @author xinmu
 * @date 2022/3/4 10:42
 * @description:内置注解
 */
public class Test01 extends Object {
    //@Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated 不推荐程序员使用,但是可以使用,或者存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    //@SupperessWarnings镇压警告
    @SuppressWarnings("all")
    public void test02(){
        ArrayList List = new ArrayList();
    }




    public static void main(String[] args) {
        test();
    }


}
