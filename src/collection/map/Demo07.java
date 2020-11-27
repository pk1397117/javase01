package collection.map;

import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo07 {

	public static void main(String[] args) {
		List<String> staff = List.of("张三","李四","王五","赵六");
		List<String> group2 = staff.subList(1, 2);//左闭右开
		System.out.println(group2);
		
		SortedSet<String> set = new TreeSet(staff);
		System.out.println(set);
		var set1 = set.subSet("李四", "赵六");
		System.out.println(set1);
		
		var set2 = set.headSet("王五");
		System.out.println(set2);
		
		var set3 = set.tailSet("王五");
		System.out.println(set3);
	}
}
