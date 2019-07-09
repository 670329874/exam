package com.kgc.dao;

import com.kgc.entity.Book;
import com.kgc.utils.BookParam;
import com.kgc.utils.PageUtil;

import java.security.PublicKey;
import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deteleBook(Integer bookid);
    public int updateBook(Book book);
    public Book getById(Integer bookid);
    public List<Book> getBookByPage(Integer pageNo,Integer pageSize,BookParam bookParam);
    public int getTotalCount(BookParam bookParam);
}
