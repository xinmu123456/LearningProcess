package com.xinmu;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream_ {

    public static void main(String[] args) throws InterruptedException {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        //Arrays.stream(array)
        //        .forEach(s -> System.out.println(s + " : " + Thread.currentThread().getId()));

        //Arrays.stream(array).
        //        parallel().forEach(s -> {
        //            try {
        //                Thread.sleep(100 - s * 10);
        //            } catch (InterruptedException e) {
        //                throw new RuntimeException(e);
        //            }
        //            System.out.println(s + " : " + Thread.currentThread().getId());
        //        });

        ArrayList<Integer> ints = new ArrayList<>();

        for (int i = 0; i < 100; i ++) {
            ints.add(i);
        }

        long start = System.currentTimeMillis();
        List<Long> longs = ints.stream().parallel().map(i -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getId();
        }).distinct().toList();

        longs.forEach(e -> {
            System.out.println(e);
        });

        //Thread.sleep(2000);
        System.out.println("take time:" + (System.currentTimeMillis() - start));


        ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        forkJoinPool.submit(() -> {
            IntStream.range(0, 100).boxed().toList()
                    .parallelStream().forEach( s -> {
                            System.out.println(Thread.currentThread().getName() + " : " + s);
                        }
                    );
        });

        System.out.println("size:" + longs.size());
        Thread.sleep(1000);
        System.out.println("main");

    }

}

