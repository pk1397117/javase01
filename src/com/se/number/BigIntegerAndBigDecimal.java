package com.se.number;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigIntegerAndBigDecimal {
	
	public static void main(String[] args) {
		//����(����) �Ӽ��˳���add��subtract��multiply��divide
		BigInteger a = BigInteger.valueOf(999999999);//valueOf(long val)
		System.out.println(a);
		BigInteger b = new BigInteger("99999999999999999999999999999999999");//BigInteger(String val)
		System.out.println(b.subtract(new BigInteger("999999999999999999999999999999999999999")));
		//����(������)
		//divide(BigDecimal other) �������һ������ѭ��С�����׳��쳣
		//divide(BigDecimal other, RoundingMode mode) RoundingMode.HALF_UP:��������
		BigDecimal c = new BigDecimal("12.0000");
		BigDecimal d = new BigDecimal("7");
		//System.out.println(c.divide(d));//ArithmeticException(�����쳣)
		System.out.println(c.divide(d, RoundingMode.HALF_UP));//��������
		System.out.println(BigDecimal.valueOf(53, 3));
		System.out.printf("%d��",53);
		
	}

}
