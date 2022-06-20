package com.xinmu.struct;

/**
 * @author xinmu
 * @date 2022/1/17 0:26
 * @description:
 */
public class demo2 {
    public  static int max(int num1,int num2){
        int ret=0;
        if (num1>=num2){
            ret=num1;
        }else {
            ret=num2;
        }
        return ret;
    }
    public static void main(String[] args) {
        int a=max(3,5);
        System.out.println(a);
    }
}
