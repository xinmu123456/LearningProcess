package com.xinmu;

import java.util.Optional;

/**
 * author: xinmu
 * date: 2022/5/18
 * time: 0:20
 */


public class OptionalDemo {
    public static void main(String[] args) throws Throwable {

        //Author author = getAuthor();
        //
        //Optional<Author> author1 = Optional.ofNullable(author);
        //author1.ifPresent(System.out::println);
        //Optional<Author> authorOptional = getAuthorOptional();
        //authorOptional.ifPresent(author -> System.out.println(author.getName()));
        //Optional<Object> o = Optional.of(null);
        //o.ifPresent(System.out::println);

        //Optional<Author> authorOptional = getAuthorOptional();
        //Author author = authorOptional.orElseGet(Author::new);
        //System.out.println(author);

        //Optional<Author> authorOptional = getAuthorOptional();
        //Author author = authorOptional.orElseThrow(() -> new RuntimeException("数据为null"));
        //System.out.println(author);

        Optional<Author> authorOptional = getAuthorOptional();
        Optional<Author> author1 = authorOptional.filter(author -> author.getAge() > 18);
        System.out.println(1);
    }


    public static Optional<Author> getAuthorOptional(){
        Author author = new Author(1L, "梦多", "earaw", 16, null);
        return Optional.ofNullable(author);
    }

    public static Author getAuthor(){
        Author author = new Author(1L, "梦多", "earaw", 33, null);
        return null;
    }
}
