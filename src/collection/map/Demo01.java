package collection.map;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

	public static void main(String[] args) {
		Map<String,Integer> counts = new HashMap();
		counts.put("word", 0);
		counts.putIfAbsent("word", 2);//不存在键或者映射到null时放入值
		counts.put("word", counts.get("word")+1);
		System.out.println(counts.get("word"));
		
		counts.put("word1", 1);
		counts.merge("word1", 1, Integer::sum);
		System.out.println(counts.get("word1"));
		
	}
}
