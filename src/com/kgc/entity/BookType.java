package com.kgc.entity;

public class BookType {
    private Integer typeid;
    private String typename;

    public BookType() {
    }

    public BookType(Integer typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
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
        return "BookType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
