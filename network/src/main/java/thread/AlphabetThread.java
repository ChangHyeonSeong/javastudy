package thread;
/*
 * 모든 스레그가 종료되고 메인이 종료되는지 확인
 * */
public class AlphabetThread extends Thread {

	@Override
	public void run() {
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
