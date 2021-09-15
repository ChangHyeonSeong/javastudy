package thread;
/*
 * for문 스레드로 두개돌리기
 * */
public class TreadEx01 {

	public static void main(String[] args) {
//		for(int i = 0; i <10; i++) {
//			System.out.print(i);
//		}
		
		new DigitThread().start();
		
		for(char c = 'a'; c <='z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
