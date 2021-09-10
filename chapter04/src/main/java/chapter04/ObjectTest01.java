package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		//Class c = p.getClass();
		
		System.out.println(p.getClass()); //reflection
		                                        //클래스 정보를 담고 있는 Class타입객체 반환
		System.out.println(p.hashCode());//address 기반의 해싱값
		                                          //address 기반이므로 값이 유일할수있다 
		                                          //암호화를 위한 해싱이 아닌 특정값에서 정수를 얻기위함
		                                          //address x
		                                          //reference x
		System.out.println(p.toString());//객체안에 내용을 String으로 변환
		                                       //getClass() + "@" + hashCode()
		System.out.println(p);
		
		

	}

}
