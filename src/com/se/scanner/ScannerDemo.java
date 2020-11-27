package com.se.scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerDemo {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = in.nextLine();
		System.out.print("What is your firstName? ");
		String firstName = in.next();
		System.out.print("How old are you? ");
		int age = in.nextInt();
		System.out.println(name);
		System.out.println(firstName);
		System.out.println(age);
		in.close();
	}

}
