package com.kgc.dao.impl;

import com.kgc.dao.BookDao;
import com.kgc.entity.Book;
import com.kgc.utils.BookParam;
import com.kgc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public int addBook(Book book) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        try{
            String sql="insert into book(bookid,bookname,price,author,pubtime,typeid) values(null,?,?,?,?,?)";
            return queryRunner.update(sql,book.getBookname(),
                    book.getPrice(),
                    book.getAuthor(),
                    book.getPubtime(),
                    book.getTypeid());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deteleBook(Integer bookid) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        try{
            String sql="delete from book where bookid=?";
            return queryRunner.update(sql,bookid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateBook(Book book) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        try {
            String sql =("update book set bookname=?,price=?,pubtime=?,author=?,typeid=? where bookid=?");
            return queryRunner.update(sql,book.getBookname(),
                    book.getPrice(),
                    book.getPubtime(),
                    book.getAuthor(),
                    book.getTypeid(),
                    book.getBookid());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getById(Integer bookid) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        StringBuffer sb=new StringBuffer();
        try {
            sb.append("select b.*,t.typename from book b,booktype t where b.typeid=t.typeid and bookid=?");
            String sql = sb.toString();
            return queryRunner.query(sql,new BeanHandler<Book>(Book.class),bookid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getBookByPage(Integer pageNo, Integer pageSize, BookParam bookParam) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        StringBuilder sb=new StringBuilder();
        try{
            sb.append("select b.*,t.typename from book b,booktype t where b.typeid=t.typeid ");
            if(null!=bookParam){
                if(bookParam.getTypeid()!=null&&!bookParam.getTypeid().equals("-1")){
                    sb.append(" and b.typeid="+bookParam.getTypeid());
                }
                if(bookParam.getAuthor()!=null&&!bookParam.getAuthor().equals("")){
                    sb.append(" and b.author like '%"+bookParam.getAuthor()+"%'");
                }
                if(bookParam.getMin_price()!=null&&!bookParam.getMin_price().equals("")){
                    sb.append(" and b.price>="+bookParam.getMin_price());
                }if(bookParam.getMax_price()!=null&&!bookParam.getMax_price().equals("")){
                    sb.append(" and b.price<="+bookParam.getMax_price());
                }
            }
            sb.append(" limit ?,?");
            String sql=sb.toString();
            return queryRunner.query(sql,new BeanListHandler<Book>(Book.class),(pageNo-1)*pageSize,pageSize);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount(BookParam bookParam) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        StringBuilder sb=new StringBuilder();
        try{
            sb.append("select count(*) rows from book where 1=1 ");
            if(null!=bookParam){
                if(bookParam.getTypeid()!=null&&!bookParam.getTypeid().equals("-1")){
                    sb.append(" and typeid="+bookParam.getTypeid());
                }
                if(bookParam.getAuthor()!=null&&!bookParam.getAuthor().equals("")){
                    sb.append(" and author like '%"+bookParam.getAuthor()+"%'");
                }
                if(bookParam.getMin_price()!=null&&!bookParam.getMin_price().equals("")){
                    sb.append(" and price>="+bookParam.getMin_price());
                }if(bookParam.getMax_price()!=null&&!bookParam.getMax_price().equals("")){
                    sb.append(" and price<="+bookParam.getMax_price());
                }
            }
            String sql=sb.toString();
            Long l = (Long) queryRunner.query(sql, new ScalarHandler("rows"));
            return l.intValue();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
