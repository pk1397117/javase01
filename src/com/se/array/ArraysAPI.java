package com.se.array;

import java.util.Arrays;
import java.util.List;

public class ArraysAPI {
	
	public static void main(String[] args) {
		
		Integer[] a = {1,2,3,4,5,6,7,8,9};
		Integer[] b = Arrays.copyOf(a, 3);//copyOf(ԭ���飬 �����鳤��)
		System.out.println(Arrays.toString(b));
		Integer[] c = Arrays.copyOfRange(a,3,13);//copyOfRange(ԭ���飬��ʼ����start����������end)��������ҿ�[start,end),end����ԭ����lengthʱ,�������Ԫ������Ĭ�ϳ�ʼֵ.
		System.out.println(Arrays.toString(c));
		List<Integer> list = Arrays.asList(a);
		System.out.println(list);
		int[] d = {1,2,3,4,5,6,7,8,9};
		List<int[]> list1 = Arrays.asList(d);
		System.out.println(list.size());
		System.out.println(list1.size());
		int index = Arrays.binarySearch(a, 8);//���ֲ���
		System.out.println(index);
		int index1 = Arrays.binarySearch(a,4,9,8);//��������Χ���ֲ��ң�����ҿ�
		System.out.println(index1);
		Arrays.fill(a, 10);//��������Ԫ���滻Ϊ��ֵͬ
		System.out.println(Arrays.toString(a));
		boolean boo1 = Arrays.equals(a, b);//�Ƚ�ֵ������һ�㣨һά���飩
		boolean boo2 = Arrays.deepEquals(a, b);//�Ƚ�ֵ�����ö�㣨��ά���飩
		boolean boo3 = a.equals(b);//�Ƚϵ�ַ
		System.out.println(boo1);
	}

}
