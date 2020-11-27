package jiekou;

import java.util.function.Predicate;

public class LambdaDemo02 {
	
	public static void main(String[] args) {
		//Predicate<String> p = x -> x=="7788";
		//Predicate<String> p = LambdaDemo02::tests;
		LambdaDemo02 ll = new LambdaDemo02();
		Predicate<String> p = ll::testss;
		System.out.println(p.test("7788"));
		System.out.println(p.getClass().getName());
		
		Getter<String> getter = Integer::valueOf;
		//Getter<String> getter = (String x) -> Integer.valueOf(x);
		System.out.println(getter.get("7788"));
		Newer<Integer> newer = Integer::new;
		Integer i = newer.newer("123");
		System.out.println(i);
		
	}

	static boolean tests(String s) {
		return s == "7788";
	}
	boolean testss(String s) {
		return s.equals("7788");
	}
	
	public interface Getter<T>{
		Integer get(T t);
	}
	
	public interface Newer<T>{
		T newer(String s);
	}
}
