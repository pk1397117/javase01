package oop;



public class ConstructorDemo {
	
	public static void main(String[] args) {
		dosome(1);
		new ConstructorDemo();
		
	}
	
	Integer integer;
 
	//构造方法
	ConstructorDemo(){
		this("123");
		int a = 0;
		String s;
		System.out.println(integer);	
	}
	ConstructorDemo(String s){

		
	}
	static {
		
	}
	
	
	
	static void dosome(Integer ...a) {
		System.out.println(222);
		for(int i : a) {
			System.out.println(i);
		}
	}
	
	static void dosome(Integer b,int a) {
		
		System.out.println(111);
		
	}
	
	static void dosome(Integer b,Integer a) {
		System.out.println(333);
	}
	

}
