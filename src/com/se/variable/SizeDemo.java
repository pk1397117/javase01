package com.se.variable;

public class SizeDemo {
	public static void main(String[] args) {
		Size s = Size.MEDIUM;
		System.out.println(s);
		String ss = "MEDIUM";
		System.out.println(ss);
		System.out.println(s.toString().equals(ss));
	}
}
