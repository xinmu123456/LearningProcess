package com.xinmu.service;

import com.xinmu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 20:46
 */


public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
