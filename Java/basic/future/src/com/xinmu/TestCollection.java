package com.xinmu;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();)  {
            System.out.println(iterator.next());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();


        while (iterator.hasNext())
            System.out.println(iterator.next());

        Co.C c = () -> System.out.println("hello");

        c.say();

        Co.X x = new Co.X();

        Co co = new Co();
        Co.Y y = co.new Y();

    }
}

class Co{

    interface C {
        void say();
    }

    static class X {

    }

    class Y {

    }
}