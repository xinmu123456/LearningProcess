package com.xinmu;

import java.lang.ref.SoftReference;

public class Test_ {

        public static void main(String[] args){
            System.out.println("开始");
            A_ a = new A_();
            SoftReference<A_> sr = new SoftReference<A_>(a);
            a = null;
            if(sr!=null){
                a = sr.get();
            }
            else{
                a = new A_();
                sr = new SoftReference<A_>(a);
            }
            System.out.println("结束");
        }


}

class A_{
    int[] a ;
    public A_(){
        a = new int[100000000];
    }
}
