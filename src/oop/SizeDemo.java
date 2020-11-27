package oop;

import java.util.Arrays;

public class SizeDemo {
	
	public static void main(String[] args) {
		Size s = Size.SMALL;
		System.out.println(s);
		s = Enum.valueOf(Size.class,"LARGE");
		System.out.println(s);
		Size [] values = Size.values();
		System.out.println(Arrays.toString(values));
		System.out.println(s.ordinal());
		
	}

}
