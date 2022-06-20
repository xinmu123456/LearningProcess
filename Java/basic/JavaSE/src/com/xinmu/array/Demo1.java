package com.xinmu.array;

import java.util.Arrays;

/**
 * @author xinmu
 * @date 2022/1/17 22:42
 * @description:
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] arr;
        arr=new int[10];
        for (int i=0;i<10;i++){
            arr[i]=i+1;
        }

        System.out.println(Arrays.toString(arr));
    }

}
