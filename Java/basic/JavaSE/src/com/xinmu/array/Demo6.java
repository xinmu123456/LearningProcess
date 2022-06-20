package com.xinmu.array;

import java.util.Arrays;

/**
 * @author xinmu
 * @date 2022/1/18 21:50
 * @description:
 */
public class Demo6 {
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[1][1]=1;
        array[2][2]=5;
        array[3][3]=6;
        array[4][4]=7;
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        int sum = 0;

        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        int[][] array2 = new int[sum+1][3];
        array2[0][0]=11;
        array2[0][1]=11;
        array2[0][2]=sum;

        int count=0;

        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                if (array[i][j]!=0) {
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array[i][j];
                }
            }
        }
        System.out.println("稀疏数组为：");
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        System.out.println("还原数组");
        int[][]array3=new int[array2[0][0]][array2[0][1]];
        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]]=array2[i][2];
        }
        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }


    }
}
