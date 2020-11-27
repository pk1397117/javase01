package com.se.array;

import java.util.Arrays;

public class ArrayDemo1 {
	
	public static void main(String[] args) {
		int n = 50;
		int k = 6;
		int[] number = new int[n];
		for(int i=0;i<number.length;i++) {
			number[i]=i+1;
		}
		int[] result = new int [k];
		for(int i=0;i<result.length;i++) {
			int r = (int)(Math.random()*n);//[0~n-1]
			result[i] = number[r];
			number[r] = number[n-1];
			n--;
		}
		Arrays.sort(result);//优化的快速排序
		System.out.println(Arrays.toString(result));
		
		
	}

}
