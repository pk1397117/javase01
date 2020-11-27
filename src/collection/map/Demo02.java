package collection.map;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo02 {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>() {{put("张三",18);put("李四",15);put("王五",20);}};
		
		//键集
		Set<String> keys = map.keySet();
		System.out.println("keys: "+keys);
		//keys.removeIf(k -> k.equals("张三"));
		
		//值集
		Collection<Integer> values = map.values();
		System.out.println("values: "+values);
		//values.remove(20);
		
		//键值对集
		Set<Map.Entry<String, Integer>> entrys = map.entrySet();
		System.out.println("entrys: "+entrys);
		
		/**
		 * 以上三个集合都能remove map中的键值对元素,但不能添加任何元素
		 */
		
		for(var entry : entrys) {
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k+": "+v);
			if(k.equals("张三")) {
				entry.setValue(100);
			}
		}
		System.out.println("-------------------------");
		map.forEach((k,v) -> {
			System.out.println(k+": "+v);
		});
		
	}
}
