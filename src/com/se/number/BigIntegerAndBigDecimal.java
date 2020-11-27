package com.se.number;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigIntegerAndBigDecimal {
	
	public static void main(String[] args) {
		//大数(整数) 加减乘除：add、subtract、multiply、divide
		BigInteger a = BigInteger.valueOf(999999999);//valueOf(long val)
		System.out.println(a);
		BigInteger b = new BigInteger("99999999999999999999999999999999999");//BigInteger(String val)
		System.out.println(b.subtract(new BigInteger("999999999999999999999999999999999999999")));
		//大数(浮点数)
		//divide(BigDecimal other) 如果商是一个无限循环小数则抛出异常
		//divide(BigDecimal other, RoundingMode mode) RoundingMode.HALF_UP:四舍五入
		BigDecimal c = new BigDecimal("12.0000");
		BigDecimal d = new BigDecimal("7");
		//System.out.println(c.divide(d));//ArithmeticException(算数异常)
		System.out.println(c.divide(d, RoundingMode.HALF_UP));//四舍五入
		System.out.println(BigDecimal.valueOf(53, 3));
		System.out.printf("%d‰",53);
		
	}

}
