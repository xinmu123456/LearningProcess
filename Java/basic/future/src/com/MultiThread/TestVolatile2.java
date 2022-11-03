package com.MultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestVolatile2 {

    static int data = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Map<Integer, Integer> collect = integers.stream()
                .collect(Collectors.toMap(i -> i, i -> i + 1, (k1, k2) -> k1));

        System.out.println(collect);


        //ArrayList<Integer> list = new ArrayList<>(){{
        //    add(1);
        //    add(2);
        //    add(3);
        //}};
        //
        //
        //IntStream.range(0, 10)
        //        .mapToObj(data -> {
        //            ArrayList<Integer> integers = new ArrayList<>();
        //            for (int i = 0; i < data; i++) {
        //                integers.add(i);
        //            }
        //            return integers;
        //        })
        //        .flatMap(l -> l.stream())
        //        .forEach(System.out::println);
        //
        //String[] words = {"Hello", "World"};
        //
        //Arrays.stream(words)
        //        .map(word -> word.split(""))
        //        .flatMap(word -> Arrays.stream(word))
        //        .forEach(System.out::println);



        FutureTask<Integer> task = new FutureTask<>(() -> {
            Thread.sleep(100);
            System.out.println(TestVolatile2.data);
            data += 1;
            return data;
        });

        new Thread(task).start();


        while (data == 0) {

            Thread.sleep(100);

        }


        Integer integer = task.get();

        System.out.println(integer);

        System.out.println("main over");

    }
}
