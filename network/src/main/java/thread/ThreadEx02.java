package thread;
/*
 * 모든 스레그가 종료되고 메인이 종료되는지 확인
 * */
public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		
        thread1.start();
        thread2.start();
	}

}
