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
				System.out.println("你选择了菜单1");
				break;
			case 2:
				System.out.println("你选择了菜单2");
				break;
			case 3:
				System.out.println("你选择了菜单3");
				break;
			case 4:
				System.out.println("你选择了菜单4");
				break;
			default:
				System.out.println("选择有误，请重新选择");
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
