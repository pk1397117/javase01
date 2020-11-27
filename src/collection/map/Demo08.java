package collection.map;

import java.util.ArrayList;
import java.util.Collections;

public class Demo08 {

	public static void main(String[] args) {
		
		var cards = new ArrayList<Integer>() {{add(1);add(2);add(3);add(4);add(5);}};
		Collections.shuffle(cards);
		System.out.println(cards);
	}
	
}
