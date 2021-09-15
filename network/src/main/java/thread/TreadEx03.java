package thread;
/*
 * 모든 스레드 써보기
 * Runnable 구현하여 스레드활용
 * */
public class TreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl());
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
