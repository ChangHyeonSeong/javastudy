package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print(">> ");
			String expression = scanner.nextLine();

			if ("quit".equals(expression)) {
				break;
			}

			String[] tokens = expression.split(" ");

			if (tokens.length != 3) {
				System.out.println(">> 알 수 없는 식입니다.");
				continue;
			}

			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);

			Arithmetic arithmetic = null;

			/* 코드 작성 */
			switch (tokens[1]) {
				case "+": {
					arithmetic = new Add();
					int result = arithmetic.calculate(lValue, rValue);
					System.out.println(">> " + result);

					break;
				}
				case "-": {
					arithmetic = new Sub();
					int result = arithmetic.calculate(lValue, rValue);
					System.out.println(">> " + result);

					break;
				}
				case "*": {
					arithmetic = new Mul();
					int result = arithmetic.calculate(lValue, rValue);
					System.out.println(">> " + result);

					break;
				}
				case "/": {
					arithmetic = new Div();
					int result = arithmetic.calculate(lValue, rValue);
					System.out.println(">> " + result);

					break;
				}
				default: {
					System.out.println(">> 알 수 없는 연산입니다.");
				}
			}

		}

		scanner.close();
	}
}