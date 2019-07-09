package com.kgc.service;

import com.kgc.entity.Book;
import com.kgc.utils.BookParam;
import com.kgc.utils.PageUtil;

import java.util.List;

public interface BookService {
    public boolean addBook(Book book);
    public boolean deteleBook(Integer bookid);
    public boolean updateBook(Book book);
    public Book getById(Integer bookid);
    public PageUtil getBookByPage(Integer pageNo, Integer pageSize, BookParam bookParam);
}
