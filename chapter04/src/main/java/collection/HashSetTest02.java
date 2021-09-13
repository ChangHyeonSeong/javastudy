package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {
    public static void main(String[] args) {
	     Set<Gugudan> s = new HashSet<>();
	     
	     Gugudan g1 = new Gugudan(2, 3);
	     Gugudan g2 = new Gugudan(3, 2);
	     Gugudan g3 = new Gugudan(6, 1);
	     
	     System.out.println(g1.hashCode());
	     System.out.println(g2.hashCode());
	     System.out.println(g3.hashCode());
	     System.out.println(g1.equals(g2));
	     
	     
	     
	     s.add(new Gugudan(2, 3));
	     s.add(new Gugudan(9, 9));
	     boolean b1 =  s.add(new Gugudan(3, 2));
	     System.out.println(b1);
	     s.add(new Gugudan(9, 9));
	     boolean b2 =  s.add(g3);
	     System.out.println(b2);
	     
	     
	     for(Gugudan d : s) {
	    	 System.out.println(d);
	     }
	}
}
