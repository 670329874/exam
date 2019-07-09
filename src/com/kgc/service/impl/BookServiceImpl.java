package com.kgc.service.impl;

import com.kgc.dao.BookDao;
import com.kgc.dao.impl.BookDaoImpl;
import com.kgc.entity.Book;
import com.kgc.service.BookService;
import com.kgc.utils.BookParam;
import com.kgc.utils.PageUtil;

public class BookServiceImpl implements BookService {
    private BookDao dao=new BookDaoImpl();
    @Override
    public boolean addBook(Book book) {
        try {
            return dao.addBook(book)>0?true:false;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deteleBook(Integer bookid) {
        try {
            return dao.deteleBook(bookid)>0?true:false;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            return dao.updateBook(book)>0?true:false;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getById(Integer bookid) {
        return dao.getById(bookid);
    }

    @Override
    public PageUtil getBookByPage(Integer pageNo, Integer pageSize, BookParam bookParam) {
        Integer totalCount=dao.getTotalCount(bookParam);
        PageUtil pageUtil=new PageUtil(pageNo,totalCount,pageSize);
        pageUtil.setList(dao.getBookByPage(pageUtil.getPageNo(),pageSize,bookParam));
        return pageUtil;
    }
}
