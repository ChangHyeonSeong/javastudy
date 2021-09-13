package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s =new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);
		s.add(s2);
		System.out.println(s.size());
		
		//데이터가 있는지확인
		System.out.println(s.contains("둘리"));
		System.out.println(s.contains(s2)); //객체의 동질성 즉 내용을 확인
		
		//순회1
		for(String str: s) {
			System.out.println(str);
		}
		

	}

}
