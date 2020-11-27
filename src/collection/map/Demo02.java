package collection.map;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo02 {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>() {{put("����",18);put("����",15);put("����",20);}};
		
		//����
		Set<String> keys = map.keySet();
		System.out.println("keys: "+keys);
		//keys.removeIf(k -> k.equals("����"));
		
		//ֵ��
		Collection<Integer> values = map.values();
		System.out.println("values: "+values);
		//values.remove(20);
		
		//��ֵ�Լ�
		Set<Map.Entry<String, Integer>> entrys = map.entrySet();
		System.out.println("entrys: "+entrys);
		
		/**
		 * �����������϶���remove map�еļ�ֵ��Ԫ��,����������κ�Ԫ��
		 */
		
		for(var entry : entrys) {
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k+": "+v);
			if(k.equals("����")) {
				entry.setValue(100);
			}
		}
		System.out.println("-------------------------");
		map.forEach((k,v) -> {
			System.out.println(k+": "+v);
		});
		
	}
}
