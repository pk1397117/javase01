package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Demo01 {
	
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>() {{add("123");add("456");add("789");}};
		//迭代器
		Iterator<String> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("--------------");
		//for each循环(变量类型必须实现Iterable接口)
		for(String e : c) {
			System.out.println(e);
		}
		System.out.println("--------------");
		//操作迭代器对象的每个元素
		c.iterator().forEachRemaining(e -> System.out.println(e));
		System.out.println("--------------");
		//remove()删除前一个next()方法所对应的元素
		Iterator<String> iter1 = c.iterator();
		iter1.next();
		iter1.remove();
		iter1.forEachRemaining(e -> System.out.println(e));
		c.stream().forEach(e -> System.out.println(e));
		c.forEach(e -> System.out.println(e));
		System.out.println("--------------");
		//判断是否包含指定元素(通过元素的equals()方法惊醒比较)
		System.out.println(c.contains("123"));
		System.out.println(c.contains("456"));
		System.out.println("--------------");
		//过滤掉满足条件的元素
		c.removeIf(e -> e.equals("456"));
		System.out.println(c);
		System.out.println("--------------");
		c = new ArrayList<String>() {{add("123");add("456");add("789");}};
		//判定一个集合是否支持高效的随机访问(标记接口RandomAccess)
		System.out.println(c instanceof RandomAccess);
		System.out.println("--------------");
		//链表(有序可重复，双向链表)
		LinkedList<String> list = new LinkedList() {{add("123");add("456");add("789");}};
		ListIterator<String> iter2 = list.listIterator();
		//正向迭代
		iter2.add("sss");
		while(iter2.hasNext()) {
			String s = iter2.next();
			if(s.equals("123")) {
				iter2.add("777");
			}
			System.out.println(s);
		}
		//反向迭代  
		while(iter2.hasPrevious()) {
			System.out.println(iter2.previous());
		}
		System.out.println("--------------");
		System.out.println(list);
		
		
	}

}
