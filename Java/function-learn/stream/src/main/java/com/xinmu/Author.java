package com.xinmu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/5/17
 * time: 16:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author>{

    private Long id;

    private String name;


    private String intro;

    private Integer age;


    private List<Book> books;

    @Override
    public int compareTo(Author o) {
        return o.getAge()-this.getAge();
    }
}
