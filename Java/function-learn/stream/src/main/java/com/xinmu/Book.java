package com.xinmu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * author: xinmu
 * date: 2022/5/17
 * time: 16:47
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    private Long id;

    private String name;

    private  String category;

    private Integer score;

    private String intro;

}
