package jiekou;

import java.util.Arrays;

public class ComparableDemo implements Comparable<ComparableDemo>{
	
	public static void main(String[] args) {
		ComparableDemo c1 = new ComparableDemo("张三",15);
		ComparableDemo c2 = new ComparableDemo("李四",17);
		ComparableDemo c3 = new ComparableDemo("王五",14);
		ComparableDemo c4 = new ComparableDemo("赵六",12);
		ComparableDemo c5 = new ComparableDemo("田七",19);
		String result = Max(c1,c2);
		System.out.println(result);
		ComparableDemo[] cs = {c1,c2,c3,c4,c5}; 
		Arrays.sort(cs);
		System.out.println(Arrays.toString(cs));
	}
	
	private int age;
	private String name;
	
	public ComparableDemo(){
		
	}
	public ComparableDemo(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String age) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "ComparableDemo [age=" + age + ", name=" + name + "]";
	}
	
	
	//比较年龄大小
	public static String Max(ComparableDemo c1,ComparableDemo c2) {
		int result = c1.compareTo(c2);
		return result>0?c1.name+"更大":(result<0?c2.name+"更大":"一样大");
	}
	@Override
	public int compareTo(ComparableDemo o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
}
