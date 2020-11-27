package collection.map;

import java.util.EnumSet;

public class Demo04 {

	public static void main(String[] args) {
		
		//���ظ�����������Ԫ��ֵ��һ��ö�ټ�
		EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
		System.out.println(always);
		
		//���ظ������͵�һ���յ�ö�ټ�
		EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
		System.out.println(never);
		
		//���ظ�������Ԫ��˳��Χ��һ��ö�ټ�
		EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY,Weekday.FRIDAY);
		System.out.println(workday);
		
		//�оٸ���Ԫ��
		EnumSet<Weekday> mwf = EnumSet.of(Weekday.FRIDAY,Weekday.WEDNESDAY,Weekday.MONDAY);
		System.out.println(mwf);//��ӡ˳�����Ӧö������Ԫ���о�˳��һ��
		
		
	}
	
}
