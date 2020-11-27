package jiekou;

import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String>,Comparable<String>{
	
	public static void main(String[] args) {
		String[] s = {"1","456","123","45645","12","1234"};
		var comp = new LengthComparator();
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		Arrays.sort(s, comp);
		System.out.println(Arrays.toString(s));
		
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 1;
	}
	


}
