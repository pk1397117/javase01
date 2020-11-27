package com.se.array;

import java.util.Arrays;

public class ArrayDemo {
	
	public static void main(String[] args) {
		int x = 20;
		int[] a = new int[100];
		int[] b = new int[x];//定义数组长度可以是变量,不过一旦初始化，长度不可变
		int[] d = new int[] {4,5,6,7,8,};
		int[] c = {1,2,3,4,5,6};//简写
		Test(new int[] {1,2,3,4,5});//匿名数组
		int[] e;//声明一个数组(未初始化)
		e = new int[] {1,2,3};//初始化声明的数组
		//长度为0的数组，与null不同
		int[] f = new int[0];
		int[] g = new int[] {};
		int[] h = {};
		for(var i:d) {
			System.out.println(i);
		}
		int[] i = c;
		System.out.println(i==c);//true
		int[] j = Arrays.copyOf(c, c.length+1);//第二个参数可以增加长度实现扩容
		System.out.println(j==c);//false
		System.out.println(Arrays.toString(j));
		System.out.println(args.length);//args接收命令行参数
		System.out.println(Arrays.toString(args));
	}
	
	public static void Test(int[] arr) {
		
	}

}
