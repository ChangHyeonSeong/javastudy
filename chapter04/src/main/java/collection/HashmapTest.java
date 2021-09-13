package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashmapTest {
       public static void main(String[] args) {
    	   Map<String, Integer> m = new HashMap<>();
           
    	   String ks1 = "one";
           m.put(ks1,1); //auto boxing
           m.put("two", 2);
           m.put("three", 3);
           
           int i = m.get("one");//auto unboxing
           int j = m.get(new String("one"));
           System.out.println(i + ":" + j); //키값은 객체동질성을 본다
           
           m.put("three", 3333333);//같은 키로 데이터를 넣으면 바뀐다
           System.out.println(m.get("three"));
           
           //순회
           Set<String> s = m.keySet();
           for(String key : s) {
        	   System.out.println(key +":"+m.get(key));
        	   
           }
       }
}
