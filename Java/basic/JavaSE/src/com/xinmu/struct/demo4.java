package com.xinmu.struct;

import java.util.Arrays;

/**
 * @author xinmu
 * @date 2022/1/17 22:19
 * @description:
 */
public class demo4 {


public static void  test(int... i){
    System.out.println(Arrays.toString(i));
}

    public static void main(String[] args) {
        demo4 demo=new demo4();
        demo.test(1,2,3);

    }
}
