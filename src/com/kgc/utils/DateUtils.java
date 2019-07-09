package com.kgc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 功能：将字符串按照pattern格式转换java.util.Date
     * @param dataStr
     * @param pattern
     * @return
     */
    public static Date String2Date(String dataStr,String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dataStr);
        }catch (Exception e){
            return  null;
        }
    }
    public static String Date2String(Date date,String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}