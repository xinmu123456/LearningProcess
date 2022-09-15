package com.xinmu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        String[] words =  new String[]{"hello", "world"};
        List<String> list = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().toList();

        list.forEach(System.out::print);

        List<String> strings = Stream.of("hello", "world", "123")
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .toList();

        System.out.println(strings);


    }
}
