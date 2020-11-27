package oop;

import java.time.LocalDate;
import java.util.Date;

public class DateDemo {
	
	public static void main(String[] args) {
		//Date date;//������û�г�ʼ��
		Date date = null;
		System.out.println(date);
		date = new Date();//new���������ض�������ø��������
		System.out.println(date.toString());
		LocalDate localDate = LocalDate.now();
		//localDate = LocalDate.of(1998, 4, 8);//of(�꣬�£���)
		System.out.println(localDate);
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		System.out.println(year+"�� "+month+"�� "+day+"��");
		LocalDate aThousandDaysLater = localDate.plusDays(1000);
		System.out.println(aThousandDaysLater);
		LocalDate yesterday = localDate.minusDays(1);//��ȡ����LocalDate����
		System.out.println(yesterday.getDayOfWeek().getValue());//�õ��������ڵ�ֵ
		
		
	}

}
