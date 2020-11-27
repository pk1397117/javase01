package collection.map;

import java.util.EnumSet;

public class Demo04 {

	public static void main(String[] args) {
		
		//返回给定类型所有元素值的一个枚举集
		EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
		System.out.println(always);
		
		//返回给定类型的一个空的枚举集
		EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
		System.out.println(never);
		
		//返回给定类型元素顺序范围的一个枚举集
		EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY,Weekday.FRIDAY);
		System.out.println(workday);
		
		//列举给定元素
		EnumSet<Weekday> mwf = EnumSet.of(Weekday.FRIDAY,Weekday.WEDNESDAY,Weekday.MONDAY);
		System.out.println(mwf);//打印顺序与对应枚举类型元素列举顺序一致
		
		
	}
	
}
