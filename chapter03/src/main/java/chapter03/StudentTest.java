package chapter03;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGarde(1);
		s1.setMajor("cs");
		s1.setName("둘라"); //부모멤버를접근할때 ((Person)s1) 암시적으로 업캐스팅 된다
		
		Person p1 = s1;    //upcasting(암시적, Implicity)
		p1.setName("둘리");
		
		Student s2 = (Student)p1; // downcasting(명시적, explicity)
		s2.setMajor("cs");
	}
}
