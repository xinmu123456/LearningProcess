package com.xinmu.array;

import java.util.Arrays;

/**
 * @author xinmu
 * @date 2022/1/17 23:32
 * @description:
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("++++++++++++++++++++");
        System.out.println(Arrays.stream(arr).max());


    }

}
