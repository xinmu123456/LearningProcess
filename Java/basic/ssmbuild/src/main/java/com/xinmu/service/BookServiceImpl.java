package com.xinmu.service;

import com.xinmu.dao.BookMapper;
import com.xinmu.pojo.Books;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/6
 * time: 20:47
 */


public class BookServiceImpl implements BookService{

    //service调dao层,这里组合daomapper

    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        System.out.println("BookServiceImpl updateBook=>"+books);
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
