package com.se.scanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerFile {
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(Path.of("E:\\aaa\\poetry.txt"),StandardCharsets.UTF_8);
				PrintWriter out = new PrintWriter("E:\\aaa\\poetry2.txt",StandardCharsets.UTF_8);
				){
			while(in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			String dir = System.getProperty("user.dir");//获得IDE启动目录
			System.out.println(dir);
			//System.out.println(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
