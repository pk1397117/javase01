package collection.map;

import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo07 {

	public static void main(String[] args) {
		List<String> staff = List.of("����","����","����","����");
		List<String> group2 = staff.subList(1, 2);//����ҿ�
		System.out.println(group2);
		
		SortedSet<String> set = new TreeSet(staff);
		System.out.println(set);
		var set1 = set.subSet("����", "����");
		System.out.println(set1);
		
		var set2 = set.headSet("����");
		System.out.println(set2);
		
		var set3 = set.tailSet("����");
		System.out.println(set3);
	}
}
