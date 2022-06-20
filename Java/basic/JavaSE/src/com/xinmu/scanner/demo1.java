package com.xinmu.scanner;

import java.util.Scanner;

/**
 * @author xinmu
 * @date 2022/1/16 23:31
 * @description:输入的一个案例
 */
public class demo1 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("使用next方法接收");
        //判断用户还是否有输入
        if (scanner.hasNext()){
            String str=scanner.next();
            System.out.println("输出的内容为："+str);
        }

        scanner.close();
    }
}
