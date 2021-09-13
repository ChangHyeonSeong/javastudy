package collection;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	public static void main(String[] args) {
		//interface로 참조하면 사용할 자료구조를 쉽게 바꿀수있다
		List<String> list =new LinkedList<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//삭제
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String  s =it.next();
			System.out.println(s);
		}
		//for each문
		for(String s : list)
             System.out.println(s);
	}
}
