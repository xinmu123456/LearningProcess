package com.xinmu.Demo4;

/**
 * @author xinmu
 * @date 2022/1/20 13:29
 * @description:
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            test(11);
        } catch (MyException e) {
            System.out.println("MyException=>"+e);
        }
    }
    static void test(int a) throws MyException {
        System.out.println("传递的参数为："+a);
        if(a>10){
            throw new MyException(a);
        }
    }
}
