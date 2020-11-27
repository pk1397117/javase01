package com.se.scanner;

import java.io.Console;

public class ConsoleDemo {
	
	public static void main(String[] args) {
		Console cons = System.console();//Java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，在 Eclipse 或者其他 IDE 的控制台是用不了的
		String username = cons.readLine("User name: ","张三");
		char[] passwd = cons.readPassword("Password: ","123456");
		System.out.println("User name: " + username);
        System.out.println("PassWord: " + String.valueOf(passwd));
       
	}

}
