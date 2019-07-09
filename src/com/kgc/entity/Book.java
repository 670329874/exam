package com.kgc.entity;

import java.util.Date;

/*      bookid   int(11) NOT NULL
        bookname varchar(100) NULL
        priced   ouble NULL
        pubtime  date NULL
        author   varchar(50) NULL
        typeid   int(11) NULL*/
public class Book {
    private Integer bookid;
    private String bookname;
    private Double price;
    private Date pubtime;
    private String author;
    private Integer typeid;
    private String typename;

    public Book() {
    }

    public Book(Integer bookid, String bookname, Double price, Date pubtime, String author, Integer typeid, String typename) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.pubtime = pubtime;
        this.author = author;
        this.typeid = typeid;
        this.typename = typename;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", pubtime=" + pubtime +
                ", author='" + author + '\'' +
                ", typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
