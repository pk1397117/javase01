package jiekou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo1 {
	
	public static void main(String[] args) {
//		List<String> list = Arrays.asList("123","44",null,"7788");
//		List<String> arrayList = new ArrayList<>(list);
//		System.out.println(arrayList);
//		//arrayList.removeIf((String e) -> {return e=="7788";});
//		arrayList.removeIf(e -> e=="7788");
//		System.out.println(arrayList);
		List<Integer> list = Arrays.asList(123,44,null,7788);
		List<Integer> arrayList = new ArrayList<>(list);
		System.out.println(arrayList);
		arrayList.removeIf(e -> e==null?false:(e==7788?true:false));
		System.out.println(arrayList);
	
	}

}
