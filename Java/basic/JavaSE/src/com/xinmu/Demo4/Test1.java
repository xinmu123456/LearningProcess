package com.xinmu.Demo4;

/**
 * @author xinmu
 * @date 2022/1/20 1:04
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {
        try{
            new Test1().test(1,0);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }

    //假设这个方法不能处理这个异常，则在方法上抛出这个异常
    public void test(int a,int b)throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();//主动的抛出异常，一般在方法中使用
        }
    }
}
