package collection.map;

import java.util.EnumMap;

public class Demo05 {

	public static void main(String[] args) {
		
		EnumMap<Weekday,Employee> map = new EnumMap<>(Weekday.class) 
		{{
			put(Weekday.MONDAY,new Employee("����",15));
			put(Weekday.THURSDAY,new Employee("����",18));
			put(Weekday.WEDNESDAY,new Employee("����",20));
			
		}};
		
		System.out.println(map);
	}
}
