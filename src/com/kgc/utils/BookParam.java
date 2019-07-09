package com.kgc.utils;

public class BookParam {
    private String typeid;
    private String author;
    private String min_price;
    private String max_price;

    public BookParam() {
    }

    public BookParam(String typeid, String author, String min_price, String max_price) {
        this.typeid = typeid;
        this.author = author;
        this.min_price = min_price;
        this.max_price = max_price;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeName(String typeId) {
        this.typeid = typeid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }
}
