package com.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreadLocalTest {

    private List<String> msg = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String msg) {
        holder.get().msg.add(msg);
    }

    public static List<String> clear() {
        List<String> list = holder.get().msg;

        holder.remove();

        System.out.println("size: "+ holder.get().msg.size());

        return list;

    }

    public static void main(String[] args) {


        ThreadLocalTest.add("111");
        System.out.println(holder.get().msg);
        ThreadLocalTest.clear();
    }
}
