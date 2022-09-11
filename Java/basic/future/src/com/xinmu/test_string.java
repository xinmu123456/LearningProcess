package com.xinmu;

public class test_string {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";

        {
            String s3 = new String("hello");
        }

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
