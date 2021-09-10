package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() + ":" + s2.hashCode());
        System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
        
        System.out.println("=======================================");
        
        String s3 = "hello";
        String s4 = "hello".concat("a");
        
        
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3.hashCode() + ":" + s4.hashCode());
        System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));		
        
        System.out.println("=======================================");
        
        String s5 = "hello";
        String s6 = new String("hello");
        
        
        System.out.println(s5 == s6);
        System.out.println(s5.equals(s6));
        System.out.println(s5.hashCode() + ":" + s6.hashCode());
        System.out.println(System.identityHashCode(s5) + ":" + System.identityHashCode(s6));	
        
        System.out.println("=======================================");
        String s7 = "helloa";
        
        System.out.println(s4 == s7);
        System.out.println(s4.equals(s7));
        System.out.println(s4.hashCode() + ":" + s7.hashCode());
        System.out.println(System.identityHashCode(s4) + ":" + System.identityHashCode(s7));	
	}

}
