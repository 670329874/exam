package com.kgc.service.impl;

import com.kgc.dao.BookTypeDao;
import com.kgc.dao.impl.BookTypeDaoImpl;
import com.kgc.entity.BookType;
import com.kgc.service.BookTypeService;

import java.util.List;

public class BookTypeServiceImpl implements BookTypeService {
    private BookTypeDao dao=new BookTypeDaoImpl();
    @Override
    public List<BookType> getBookTypeList() {
        return dao.getBookTypeList();
    }
}
