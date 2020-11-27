package oop;

import java.time.LocalDate;
import java.util.Date;

public class DateDemo {
	
	public static void main(String[] args) {
		//Date date;//声明但没有初始化
		Date date = null;
		System.out.println(date);
		date = new Date();//new操作符返回对象的引用给对象变量
		System.out.println(date.toString());
		LocalDate localDate = LocalDate.now();
		//localDate = LocalDate.of(1998, 4, 8);//of(年，月，日)
		System.out.println(localDate);
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		System.out.println(year+"年 "+month+"月 "+day+"日");
		LocalDate aThousandDaysLater = localDate.plusDays(1000);
		System.out.println(aThousandDaysLater);
		LocalDate yesterday = localDate.minusDays(1);//获取昨天LocalDate对象
		System.out.println(yesterday.getDayOfWeek().getValue());//得到昨天星期的值
		
		
	}

}
