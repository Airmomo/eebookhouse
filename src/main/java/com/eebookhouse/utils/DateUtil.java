package com.eebookhouse.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String HTML_DATE = "yyyy/MM/dd";
    public static final String MYSQL_DATE = "yyyy-MM-dd";
    public static final String MYSQL_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat dateFormat;

    static{
        dateFormat = new SimpleDateFormat(MYSQL_DATE);
    }

    public static void setFormatString(String format){
        dateFormat = new SimpleDateFormat(format);
    }

    public static String dateToString(Date date){
        String res = "";
        res = dateFormat.format(date);
        return res;
    }

    public static String dateToString(Date date,String format){
        String res = "";
        SimpleDateFormat dateFormat_temp = new SimpleDateFormat(format);
        res = dateFormat_temp.format(date);
        return res;
    }

    public static Date stringToDate(String str) throws ParseException {
        Date date = dateFormat.parse(str);
        return date;
    }

    public static Date stringToDate(String str,String format) throws ParseException {
        SimpleDateFormat dateFormat_temp = new SimpleDateFormat(format);
        Date date = dateFormat_temp.parse(str);
        return date;
    }

    public static String changeStringByFormat(String str,String format_source) throws ParseException {
        Date date = null;
        String res = "";
        try {
            date = DateUtil.stringToDate(str,format_source);
            res = DateUtil.dateToString(date);
        } catch (ParseException e) {
            res = str;
        }
        return res;
    }

    public static String changeStringByFormat(String str,String format_source,String format_res)  {
        Date date = null;
        String res = "";
        try {
            date = DateUtil.stringToDate(str,format_source);
            res = DateUtil.dateToString(date,format_res);
        } catch (ParseException e) {
            res = str;
        }
        return res;
    }

}
