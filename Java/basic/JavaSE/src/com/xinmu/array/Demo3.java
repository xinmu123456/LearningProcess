package com.xinmu.array;

import java.util.Arrays;

import static com.sun.xml.internal.fastinfoset.tools.PrintTable.printArray;


/**
 * @author xinmu
 * @date 2022/1/17 23:38
 * @description:
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6};
//        for (int i : array) {
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(array));
        array=reserve(array);
        System.out.println(Arrays.toString(array));

    }
    public static int[] reserve(int[]array){
          int[] ret=new int[array.length];

          for (int i=0,j=ret.length-1;i<array.length;i++,j--){
            ret[j]=array[i];
          }
        return ret;
    }
}
