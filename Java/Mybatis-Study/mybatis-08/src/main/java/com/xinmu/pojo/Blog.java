package com.xinmu.pojo;

import lombok.Data;

import java.util.Date;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 21:36
 */

@Data
public class Blog {



    private String  id;
    private String title;
    private String author;
    private Date createTime;  //数据名和字段名不一致
    private int views;


}
