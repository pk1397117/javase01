package com.se.scanner;

import java.io.Console;

public class ConsoleDemo {
	
	public static void main(String[] args) {
		Console cons = System.console();//Java.io.Console ֻ�����ڱ�׼���롢�����δ���ض����ԭʼ����̨��ʹ�ã��� Eclipse �������� IDE �Ŀ���̨���ò��˵�
		String username = cons.readLine("User name: ","����");
		char[] passwd = cons.readPassword("Password: ","123456");
		System.out.println("User name: " + username);
        System.out.println("PassWord: " + String.valueOf(passwd));
       
	}

}
