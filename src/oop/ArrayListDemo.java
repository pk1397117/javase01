package oop;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList(100);
		System.out.println(list.size());
		list.ensureCapacity(12);
		
		String sss=new String("789");
		String s = "789";
		String ss ="789";
		System.out.println(s==ss);
		System.out.println(s==sss);
		
	}


}
