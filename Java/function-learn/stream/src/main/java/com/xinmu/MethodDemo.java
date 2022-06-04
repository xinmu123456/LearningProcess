package com.xinmu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/5/18
 * time: 12:25
 */


public class MethodDemo {

    interface UseString{
        String use(String str,int start,int length);
    }

    public static String subAuthorName(String str,UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }

    public static void main(String[] args) {
        String xinmu = subAuthorName("xinmu", String::substring);
        System.out.println(xinmu);
    }



    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "杨杰炜", "my introduction 1", 18, null);
        Author author2 = new Author(2L, "yj", "my introduction 2", 19, null);
        Author author3 = new Author(2L, "yj", "my introduction 2", 19, null);
        Author author4 = new Author(4L, "wdt", "my introduction 4", 29, null);
        Author author5 = new Author(5L, "wtf", "my introduction 5", 12, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81, "这是简介哦"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        author5.setBooks(books2);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5));
    }
}
