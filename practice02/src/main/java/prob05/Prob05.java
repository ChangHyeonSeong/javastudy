package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			// 정답 램덤하게 만들기
			long seed = System.currentTimeMillis();
			Random random = new Random(seed);
			
			int correctNumber = random.nextInt( 100 ) + 1;
			//System.out.println(correctNumber);
			
			/* 게임 작성 */
            System.out.println("수를 결정하였습니다. 맞추어보세요"); 
            System.out.println("1-100");
            
            int inputNum = 0;
      
			for(int i = 0; inputNum != correctNumber ;i++) {
				System.out.print(i+1 + ">>");
				inputNum = scanner.nextInt();
				if(inputNum > correctNumber) {
					System.out.println("더 낮게");
				}
				else {
					System.out.println("더 높게");
				}
				
			}
			System.out.println("맞았습니다.");
			

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}