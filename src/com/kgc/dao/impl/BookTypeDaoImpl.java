package com.kgc.dao.impl;

import com.kgc.dao.BookTypeDao;
import com.kgc.entity.BookType;
import com.kgc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class BookTypeDaoImpl implements BookTypeDao {
    @Override
    public List<BookType> getBookTypeList() {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        try {
            String sql =("select * from booktype");
            return queryRunner.query(sql,new BeanListHandler<BookType>(BookType.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
