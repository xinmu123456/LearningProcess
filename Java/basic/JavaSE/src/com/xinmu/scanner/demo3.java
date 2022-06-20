package com.xinmu.scanner;

import java.util.Scanner;

/**
 * @author xinmu
 * @date 2022/1/16 23:44
 * @description:
 */
public class demo3 {
    public static void main(String[] args) {
        int i=0;
        float f=0.0f;
        Scanner scanner=new Scanner(System.in);
        if (scanner.hasNextInt()){
            i=scanner.nextInt();
            System.out.println("输入的整数为："+i);

        }else {
            System.out.println("您输入的不是整数");
        }
        if (scanner.hasNextFloat()){
            f= scanner.nextFloat();;
            System.out.println("输入的小数为:"+f);
        }else {
            System.out.println("您输入的不是小数");
        }
    }
}
