package com.xinmu;

import lombok.var;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: xinmu
 * date: 2022/5/17
 * time: 16:49
 */


public class StreamDemo {


    public static void main(String[] args) {
        List<Author> authors = getAuthors();


        test28();

        //authors.stream()
        //        .map(Author::getAge)
        //        .map(age->age+10)
        //        .filter(age->age>18)
        //        .map(age->age+2)
        //        .forEach(System.out::println);
        //
        //authors.stream()
        //        .mapToInt(Author::getAge)
        //        .map(operand -> operand+10)
        //        .filter(value -> value>18)
        //        .map(age->age+2)
        //        .forEach(System.out::println);

        //authors.stream()
        //        .map(Author::getName)
        //        .map(StringBuilder::new)
        //        .map(sb -> sb.append("xinmu").toString())
        //        .forEach(System.out::println);

        //authors.stream()
        //        .map(author -> author.getAge())
        //        .map(age -> 10 + age)
        //        .forEach(System.out::println);


        //printNum(value -> value % 2 == 0, value -> value>4);

        //testOr();

        //testNegate();

        //test27();

        //testAnd();
        //Stream<Author> stream = authors.stream();

        //extracted();

        //test(authors);

        //test03();

        //test04();

        //test05();

        //test06();

        //test07();

        //test09();

        //test10();

        //test11();
   
        //test12();

        //test13();

        //test14();

        //test16();

        //test17();

        //test18();

        //test19();

        //test20();

        //test21();

        //test22();

        //test23();

        //test24();

        //test25();

        //test26();
    }

    private static void test28() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream.parallel()
                .peek(integer -> {
                    System.out.println(integer + Thread.currentThread().getName());
                })
                .filter(num -> num > 5)
                .reduce(Integer::sum)
                .get();

        System.out.println(sum);


    }

    private static void test27() {

        List<Author> authors = getAuthors();
        StringBuilder sb = new StringBuilder();
        authors.stream().map(Author::getName)
                .forEach(sb::append);


    }

    private static void testNegate() {
        //打印年龄中不大于17的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 17;
                    }
                }.negate()).forEach(author -> author.getAge());
    }

    private static void testOr() {

        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()<17;
                    }
                }.or(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()<2;
                    }
                })).forEach(System.out::println);

    }


    public static void printNum(IntPredicate predicate,IntPredicate predicate2) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.and(predicate2).test(i)) {
                System.out.println(i);//输出2.4.6.8.10
            }
        }
    }
    private static void testAnd() {

        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 11;
                    }
                }.and(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()>1;
                    }
                })).forEach(author -> System.out.println(author.getName()+"::::"+author.getAge()));

    }

    private static void test26() {

        List<Author> authors = getAuthors();
        Optional<Integer> reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(((integer, integer2) -> integer < integer2 ? integer : integer2));

        reduce.ifPresent(System.out::println);
    }

    private static void test25() {
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, ((result, element) -> result < element ? result : element));
        System.out.println(reduce);
    }

    private static void test24() {
        //reduce 求所有作者中年龄的最大值
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(reduce);

    }

    private static void test23() {

        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result,element)-> result+element);
        System.out.println(sum);

    }

    private static void test22() {
        //获取年龄最小的作家,并输出他的姓名
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getAge()));
    }

    private static void test21() {

        List<Author> authors = getAuthors();

        Optional<Author> any = authors.stream()
                .filter(author -> author.getAge()>18)
                .findAny();

        any.ifPresent(System.out::println);

    }


    private static void test20() {

        List<Author> authors = getAuthors();

        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() >= 100);

        System.out.println(b);

    }

    private static void test19() {

        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() > 10);

        System.out.println(b);

    }


    private static void test18() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge()>29);
        System.out.println(b);
    }


    private static void test17() {

        List<Author> authors = getAuthors();

        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        System.out.println(collect);
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        Set<Book> collect = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }

    private static void test15() {

        //获取一个存放所有作者名字的list集合
        List<Author> authors = getAuthors();

        List<String> nameList = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());

        System.out.println(nameList);


    }

    private static void test14() {
        //获取作家的最高分和最低分进行打印
        List<Author> authors = getAuthors();

        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max(((o1, o2) -> o1 - o2));

        System.out.println(max.get());

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min(((o1, o2) -> o1 - o2));
        System.out.println(min.get());


    }


    private static void test13() {

        List<Author> authors = getAuthors();

        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);


    }


    private static void test12() {
        //输出所有作家的名字

        List<Author> authors = getAuthors();

        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(System.out::println);
    }


    private static void test11() {

        //打印现有数据分所有分类

        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);

    }


    private static void test10() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09() {
    //打印除了年龄最大的作家之外的其他作家要求不能有重的元素,标签年龄降序排序

        List<Author> authors = getAuthors();

        authors.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge()-o1.getAge()))
                .skip(1)
                .forEach(System.out::println);
    }


    private static void test07() {

        //对流中的元素按照年龄进行降序排序,且不能有重复的元素,然后打印其中年龄最大的两个作家的姓名
        getAuthors().stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
                .limit(2)
                .forEach(System.out::println);


    }

    private static void test06() {
        //打印所有的作家名称 且不能有重复的

        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge()-o1.getAge()))
                .forEach(author -> System.out.println(author));

    }

    private static void test05() {
        List<Author> authors = getAuthors();

        //authors.stream()
        //        .map(author -> author.getName()).forEach(s -> System.out.println(s));
    
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .forEach(age -> System.out.println(age));
    }
    

    private static void test04() {

        List<Author> authors = getAuthors();

        //打印所有姓名长度大于1的作家的姓名

        authors.stream()
                .filter(author -> author.getName().length()>2)
                .forEach(author -> System.out.println(author.getName()));




    }

    private static void test03(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("蜡笔小新",19);
        map.put("蜡笔",17);
        map.put("小新",16);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entries.stream();

        stream.filter(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> entry) {
                return entry.getValue()>16;
            }
        }).forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> entry) {
                System.out.println(entry.getKey()+"===="+entry.getValue());
            }
        });

    }



    private static void extracted() {
        Integer[] arr={1,2,3,4,5};

        Stream<Integer> stream = Arrays.stream(arr);

        stream.distinct()
                .filter(integer -> integer>2)
                .forEach(integer -> System.out.println(integer+2));
    }

    private static void test(List<Author> authors) {
        //打印作家中年龄小于十八的
        authors.stream() //把集合装欢成流
                .distinct() //去重
                .filter(author -> author.getAge()<18) //筛选年龄小于18的
                .forEach(author -> System.out.println(author.getName())); //遍历打印
    }


    // 初始化一些数据
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
