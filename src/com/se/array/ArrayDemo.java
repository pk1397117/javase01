package com.se.array;

import java.util.Arrays;

public class ArrayDemo {
	
	public static void main(String[] args) {
		int x = 20;
		int[] a = new int[100];
		int[] b = new int[x];//�������鳤�ȿ����Ǳ���,����һ����ʼ�������Ȳ��ɱ�
		int[] d = new int[] {4,5,6,7,8,};
		int[] c = {1,2,3,4,5,6};//��д
		Test(new int[] {1,2,3,4,5});//��������
		int[] e;//����һ������(δ��ʼ��)
		e = new int[] {1,2,3};//��ʼ������������
		//����Ϊ0�����飬��null��ͬ
		int[] f = new int[0];
		int[] g = new int[] {};
		int[] h = {};
		for(var i:d) {
			System.out.println(i);
		}
		int[] i = c;
		System.out.println(i==c);//true
		int[] j = Arrays.copyOf(c, c.length+1);//�ڶ��������������ӳ���ʵ������
		System.out.println(j==c);//false
		System.out.println(Arrays.toString(j));
		System.out.println(args.length);//args���������в���
		System.out.println(Arrays.toString(args));
	}
	
	public static void Test(int[] arr) {
		
	}

}
