package com.xinmu.ThreadLambda;

/**
 * @author xinmu
 * @date 2022/2/24 20:04
 * @description:
 */
public class TestLambda2 {
    public static void main(String[] args) {
        Ilove love=new Love();
        love.love(1);
        //匿名内部类
        love=new Ilove() {
            @Override
            public void love(int a) {
                System.out.println("I love " +a);
            }
        };
        love.love(2);

        //lambda表达式基础类型
         love=(int a)->{
             System.out.println("I love " +a);
        };
         love.love(3);

         //简化1：去掉参数类型
         love=(a) -> {
             System.out.println("I love " +a);
         };
         love.love(4);

         //简化2：去掉小括号
         love=a -> {
             System.out.println("I love "+a);
         };
         love.love(5);

         //简化3：去掉花括号
        love=a -> System.out.println("I love "+(char)a);
        love.love(97);


    }
}

interface Ilove{
    void love(int a);
}

class Love implements Ilove{
    @Override
    public void love(int a) {
        System.out.println("I love " +a);
    }
}
