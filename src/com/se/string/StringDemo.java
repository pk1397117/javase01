package com.se.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StringDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String greeting = "hello2@♣你好$侃";
		int len = greeting.length();
		System.out.println(len);
		System.out.println(greeting.codePointCount(0, len));
		IntStream intStream = greeting.codePoints();
		int [] codePoints = intStream.toArray();
		System.out.println(Arrays.toString(codePoints));//码点数组
		String str = new String(codePoints,0,codePoints.length);//码点数组转字符串
		System.out.println(str);
		intStream.close();
		System.out.println(Integer.toHexString(20320));
		System.out.println('\u4f60');
		byte[] b = greeting.getBytes("GB2312");
		String str1 = new String(b,0,b.length,"GB2312");
		System.out.println(str1);
		System.out.println(Arrays.toString(b));

		
	}

}
