package thread;
/*
 * Runnable 구현하여 스레드활용
 * */
public class UpperCaseAlphabet {
     public void print() {
    	 for(char c = 'A'; c <='Z'; c++) {
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
