package com.xinmu.array;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @author xinmu
 * @date 2022/1/18 21:39
 * @description:
 */
public class Demo5 {
    public static void main(String[] args) {
        int[] array = {1, 8, 9, 7, 5, 2, 44, 568};

        System.out.println(Arrays.toString(array));

        sort(array);

        System.out.println(Arrays.toString(array));
        Arrays.fill(array, 2,4,0);

        System.out.println(Arrays.toString(array));


    }
}
