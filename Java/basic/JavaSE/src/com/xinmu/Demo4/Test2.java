package com.xinmu.Demo4;

/**
 * @author xinmu
 * @date 2022/1/20 0:46
 * @description:
 */
public class Test2 {
    public static void main(String[] args) {
        int a=0;
        int b=1;
        //CTRL+ALT+T
        try {
            System.out.println(b/a);
        } catch (Exception e) {
            e.printStackTrace();//打印栈信息
        } finally {
        }
    }
}
