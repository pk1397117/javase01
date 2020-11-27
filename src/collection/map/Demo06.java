package collection.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Demo06 {

	public static void main(String[] args) {
		List<String> names = List.of("����","����","����","����");
		System.out.println(names.getClass());
		List<String> aList = new ArrayList<>(names);
		System.out.println(aList.getClass());
		
		Set<Integer> ages = Set.of(15,20,13,14);
		System.out.println(ages.getClass());
		
		Map<String,Integer> person = Map.of("����",15,"����",20,"����",13,"����",14);
		System.out.println(person.getClass());
		Set<String> keys = person.keySet();
		System.out.println(keys);
		Set<Entry<String, Integer>> entrys = person.entrySet();
		//
		Entry<String,Integer>[] obj = new Entry[entrys.size()];
		int i = 0;
		for(var entry : entrys) {
			obj[i] = entry;
			i++;
		}
		
		
		Map<String,Integer> scores = Map.ofEntries(obj);
		//Map<String,Integer> scores = Map.ofEntries(Map.entry("����", 14));
	
		System.out.println(scores);
		//�洢������С������ֻ�洢һ��
		List<String> settings = Collections.nCopies(10, "default");
		System.out.println(settings);
		
		

	}

}
