package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
     while(true) {
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		
		System.out.printf("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		if(num % 2 == 0) {
			int sum = 0;
			for(int i=2; i <= num; i+=2) {
				sum += i;
			}
			System.out.println("결과값 : " + sum);
		}
		else {
			int sum = 0;
			for(int i=1; i <= num; i+=2) {
				sum += i;
			}
			System.out.println("결과값 : " + sum);
		}
		
		//scanner.close();
     }
     
	}
}
