package com.chuan.myfinanceweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOffSet {
	public static void main(String[] args) throws ParseException  {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date d1 = sdf.parse("2018-12-01");
	    Date d2 = sdf.parse("2018-12-31");

	    int js = js(d1, d2);
	    System.out.println("天数差是：" + js);
	}

	/**
	 * 计算两个日期的天数差
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int js(Date d1, Date d2){
	    Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    //long类型的日期也支持
//	    cal1.setTimeInMillis(long);
//	    cal2.setTimeInMillis(long);
	    cal1.setTime(d1);
	    cal2.setTime(d2);
	   
	    //获取日期在一年(月、星期)中的第多少天
	    int day1 = cal1.get(Calendar.DAY_OF_YEAR);//第335天
	    int day2 = cal2.get(Calendar.DAY_OF_YEAR);//第365天
	   
	    //获取当前日期所在的年份
	    int year1 = cal1.get(Calendar.YEAR);
	    int year2 = cal2.get(Calendar.YEAR);

	    //如果两个日期的是在同一年，则只需要计算两个日期在一年的天数差；
	    //不在同一年，还要加上相差年数对应的天数，闰年有366天
	    
	    if(year1 != year2) //不同年
	    {
	        int timeDistance = 0 ;
	        for(int i = year1 ; i < year2 ; i ++)
	        {
	            if(i%4==0 && i%100!=0 || i%400==0) //闰年
	            {
	                timeDistance += 366;
	            }
	            else //不是闰年
	            {
	                timeDistance += 365;
	            }
	        }
//	        System.out.println(timeDistance + (day2-day1));
	        return timeDistance + (day2-day1);
	    }
	    else //同年
	    {
//	        System.out.println("判断day2 - day1 : " + (day2-day1));
	        return day2-day1;
	    }
	}
}
