package com.se.choice;

import java.util.Scanner;

public class SwitchDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Select an option (1, 2, 3, 4)");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("��ѡ���˲˵�1");
				break;
			case 2:
				System.out.println("��ѡ���˲˵�2");
				break;
			case 3:
				System.out.println("��ѡ���˲˵�3");
				break;
			case 4:
				System.out.println("��ѡ���˲˵�4");
				break;
			default:
				System.out.println("ѡ������������ѡ��");
				break;
			}
			if(choice<=4 && choice>=1) {
				flag = false;
			}
		}

		in.close();
		System.out.println(Math.PI);
	}

}
