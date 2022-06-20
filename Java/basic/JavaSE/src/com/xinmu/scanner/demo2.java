package com.xinmu.scanner;

import java.util.Scanner;

/**
 * @author xinmu
 * @date 2022/1/16 23:36
 * @description:
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("用nextLine的方法接收");

        if (scanner.hasNextLine()){
            String str=scanner.nextLine();
            System.out.println("输入的内容为："+str);

        }
        scanner.close();

    }
}
