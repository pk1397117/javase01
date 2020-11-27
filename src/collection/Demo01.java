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
		//������
		Iterator<String> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("--------------");
		//for eachѭ��(�������ͱ���ʵ��Iterable�ӿ�)
		for(String e : c) {
			System.out.println(e);
		}
		System.out.println("--------------");
		//���������������ÿ��Ԫ��
		c.iterator().forEachRemaining(e -> System.out.println(e));
		System.out.println("--------------");
		//remove()ɾ��ǰһ��next()��������Ӧ��Ԫ��
		Iterator<String> iter1 = c.iterator();
		iter1.next();
		iter1.remove();
		iter1.forEachRemaining(e -> System.out.println(e));
		c.stream().forEach(e -> System.out.println(e));
		c.forEach(e -> System.out.println(e));
		System.out.println("--------------");
		//�ж��Ƿ����ָ��Ԫ��(ͨ��Ԫ�ص�equals()�������ѱȽ�)
		System.out.println(c.contains("123"));
		System.out.println(c.contains("456"));
		System.out.println("--------------");
		//���˵�����������Ԫ��
		c.removeIf(e -> e.equals("456"));
		System.out.println(c);
		System.out.println("--------------");
		c = new ArrayList<String>() {{add("123");add("456");add("789");}};
		//�ж�һ�������Ƿ�֧�ָ�Ч���������(��ǽӿ�RandomAccess)
		System.out.println(c instanceof RandomAccess);
		System.out.println("--------------");
		//����(������ظ���˫������)
		LinkedList<String> list = new LinkedList() {{add("123");add("456");add("789");}};
		ListIterator<String> iter2 = list.listIterator();
		//�������
		iter2.add("sss");
		while(iter2.hasNext()) {
			String s = iter2.next();
			if(s.equals("123")) {
				iter2.add("777");
			}
			System.out.println(s);
		}
		//�������  
		while(iter2.hasPrevious()) {
			System.out.println(iter2.previous());
		}
		System.out.println("--------------");
		System.out.println(list);
		
		
	}

}
