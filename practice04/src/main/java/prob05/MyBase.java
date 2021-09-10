package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		
		if( state.equals( "낮" ) ) {
			day();
		} 
		if( state.equals( "밤" ) ) {
			night();
		}
		if(state.equals("오후")) {
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
		}
	}

	@Override
	public void day() {
		System.out.println("낮에는 열심히 일하자");
	}

	

}
