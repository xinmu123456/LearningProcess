package com.xinmu;

public class TestEx {
    public static void main(String[] args){
        int i = 11;
        try {

            for (int j = 0; j < 10; j ++) {
                i = 1 / 0;
                System.out.println("err");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(i);
        for (int j = 0; j < 10; j ++) {
            try {
                i = 1 / 0;
            }catch (ArithmeticException e){
                e.printStackTrace();
            }
        }
    }
}
