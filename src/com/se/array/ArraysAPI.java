package com.se.array;

import java.util.Arrays;
import java.util.List;

public class ArraysAPI {
	
	public static void main(String[] args) {
		
		Integer[] a = {1,2,3,4,5,6,7,8,9};
		Integer[] b = Arrays.copyOf(a, 3);//copyOf(原数组， 新数组长度)
		System.out.println(Arrays.toString(b));
		Integer[] c = Arrays.copyOfRange(a,3,13);//copyOfRange(原数组，开始索引start，结束索引end)区间左闭右开[start,end),end大于原数组length时,数组填充元素类型默认初始值.
		System.out.println(Arrays.toString(c));
		List<Integer> list = Arrays.asList(a);
		System.out.println(list);
		int[] d = {1,2,3,4,5,6,7,8,9};
		List<int[]> list1 = Arrays.asList(d);
		System.out.println(list.size());
		System.out.println(list1.size());
		int index = Arrays.binarySearch(a, 8);//二分查找
		System.out.println(index);
		int index1 = Arrays.binarySearch(a,4,9,8);//按索引范围二分查找，左闭右开
		System.out.println(index1);
		Arrays.fill(a, 10);//数组所有元素替换为相同值
		System.out.println(Arrays.toString(a));
		boolean boo1 = Arrays.equals(a, b);//比较值，适用一层（一维数组）
		boolean boo2 = Arrays.deepEquals(a, b);//比较值，适用多层（多维数组）
		boolean boo3 = a.equals(b);//比较地址
		System.out.println(boo1);
	}

}
