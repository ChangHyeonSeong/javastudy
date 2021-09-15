package thread;
/*
 * Runnable 구현하여 스레드활용
 * */
public class UpperCaseAlphabetRunnableImpl extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		super.print();

	}

}
