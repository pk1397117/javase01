package collection.map;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo03 {
	
	public static void main(String[] args) {
		
		Map<String,Integer> map = new LinkedHashMap<>(100,0.75f,true) {{put("����",18);put("����",20);}};
		map.put("����", 15);
		map.get("����");
		System.out.println(map);

	}

	
}
