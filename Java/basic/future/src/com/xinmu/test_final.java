package com.xinmu;

import java.util.*;

class A {
    final int data;

    A(){
        this.data = 0;
    }
    A(int i) {
        this.data = i;
    }
}

public class test_final {
    public static void main(String[] args) {
        final int i = 10;

        final A a= new A(1);

        int j = 1;

        final List<A> list = new LinkedList<>();
        list.add(new A());

        StringBuilder sb = new StringBuilder("anc");

        String[] name = {"a", "b", "C"};

        StringJoiner sj = new StringJoiner(", ", "[", "]");

        for (String s : name) {
            sj.add(s);
        }
        System.out.println(sj);
        String ans = String.join(", ", name);
        System.out.println(ans);

        ArrayList<String> l = new ArrayList();
        l.add("abc");
        Iterator<String> iterator = l.iterator();
        l.add("klf");

        //iterator.next();


    }
}
