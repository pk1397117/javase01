package com.se.variable;

import java.lang.Math.*;
import static java.lang.Math.*;//��̬����

public class Operator {
	
	public static void main(String[] args) {
		//System.out.println(15/0);//ArithmeticException(�����쳣,��������Ϊ0)
		//System.out.println(15.0/0);	//ArithmeticException(�����쳣,��������Ϊ0)
		Double a = 15.0/0;
		System.out.println(a);//Infinity(�������)
		Double b = -15.0/0;
		System.out.println(b);//-Infinity(�������)
		Double c = 0.0/0;
		System.out.println(c);//NaN(not a number)
		System.out.println(Math.sqrt(-1));//NaN(not a number)
		System.out.println(Math.floorMod(120, 60));
		System.out.println(Math.exp(10));
		System.out.println(Math.PI);
		System.out.println(PI);
		char ch = 65;
		int i = ch;
		System.out.println(i);
		char ch1 = (char) i;
		System.out.println(ch1);
		System.out.println((byte)300);
		System.out.println((short)-32770);
		System.out.println(~7);
		String ss = Integer.toBinaryString(-2);
		System.out.println(ss);
		int ss1 = Integer.parseInt("-1001",2);
		System.out.println(ss1);


	}

}
