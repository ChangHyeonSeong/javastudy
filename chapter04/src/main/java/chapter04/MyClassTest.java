package chapter04;

public class MyClassTest {
    public static void main(String[] args) {
    	//MyClass myClass0 = new MyClass();
    	//싱글톤 항상 객체가 하나 메모리에서 내려가지않는다
    	
		MyClass  myClass1 = MyClass.getInstance();
		MyClass  myClass2 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
	}
}
