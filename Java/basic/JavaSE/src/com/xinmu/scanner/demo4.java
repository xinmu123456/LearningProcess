package com.xinmu.scanner;

import java.util.Scanner;

/**
 * @author xinmu
 * @date 2022/1/16 23:59
 * @description:
 */
public class demo4 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double sum=0;
        int i=0;
        while (scanner.hasNextInt()){
            sum+=scanner.nextInt();
            i++;
        }
        System.out.println(i+"个数的和为："+sum);
        System.out.println(i+"个数的平均数为"+(sum/i));

        scanner.close();


    }
}
