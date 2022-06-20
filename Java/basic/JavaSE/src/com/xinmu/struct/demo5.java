package com.xinmu.struct;

/**
 * @author xinmu
 * @date 2022/1/17 22:29
 * @description:
 */
public class demo5 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }


    public static int f(int n){
        if (n==1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }
}
