package com.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class C3p0Utils {
    private static DataSource ds=new ComboPooledDataSource();

    public static Connection getConnection(){
        Connection connection=null;
        try{
            connection=ds.getConnection();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
