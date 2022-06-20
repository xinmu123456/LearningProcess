package com.xinmu.Demo4;

/**
 * @author xinmu
 * @date 2022/1/20 0:06
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        int a=0;
        int b=1;
        try{//try监控区域
            System.out.println(b/a);
        }catch (Error e){//catch(想要捕获的异常类型)捕获异常
            System.out.println("Error");
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Throwable e){
            System.out.println("Throwable");
        } finally {//处理善后工作
            System.out.println("finally");
        }
        //finally可以不要，但是IO流工作都需要被关闭
    }
}

