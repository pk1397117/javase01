package com.se.string;

public class StringAPI1 {

	public static void main(String[] args) {
		String s = "hello2@♣你好$侃你𝕆";
		System.out.println(s.trim());
		System.out.println(s.strip());
		String[] ss =  {"abc","123","DEF"};
		StringBuilder[] sss = {new StringBuilder("44"),new StringBuilder("44"),new StringBuilder("44")};
		System.out.println(String.join("-", sss));
		System.out.println(s.repeat(2));
		StringBuilder builder = new StringBuilder("hello2@♣你好$侃你𝕆");
		System.out.println(builder.length());
		int cpCount = builder.codePointCount(0, builder.length());
		System.out.println(cpCount);
		builder.setCharAt(0, 'H');
		System.out.println(builder);
		
	}
}
