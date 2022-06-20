package com.xinmu.dao;

import com.xinmu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 20:26
 */


public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);


}
