package com.se.scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintfDemo {
	
	public static void main(String[] args) {
		double x = 10000.0/3.0;
		System.out.println(x);
		System.out.printf("%8.2f\n",x);
		int i = 100;
		int j = 50;
		double k = -100.0;
		String s = String.format("i=%d,j=%d\n",i,j);//格式化字符串
		System.out.println(s);
		System.out.printf("%d %d\n",i,j);//十进制
		System.out.printf("i=%d,j=%d\n",i,j);//十进制
		System.out.printf("%o %x\n",i,j);//八进制   十六进制
		System.out.printf("%+.2f\n",k);
		System.out.printf("%(.2f\n",k);
		System.out.printf("%#x\n",i);//添加进制前缀
		System.out.printf("%#o\n",i);//添加进制前缀
		String date = new SimpleDateFormat("yy-mm-dd HH:MM:ss").format(new Date());
		System.out.println(date);
		System.out.printf("%tF\n",new Date());
		String date1 = String.format("%1$tF %1$tT", new Date());
		System.out.println(date1);
		String date2 = String.format("%tF %<tT", new Date());
		System.out.println(date2);
		
		
		
	}

}
