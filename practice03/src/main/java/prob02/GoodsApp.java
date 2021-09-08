package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		//for( String s : token)
		for (int i = 0; i < goods.length; i++) {
			String inputStr = scanner.nextLine();
			String[] splitStr = inputStr.split(" ");
			goods[i] = new Goods();
			goods[i].setName(splitStr[0]);
			goods[i].setPrice(Integer.parseInt(splitStr[1]) );
			goods[i].setCountStock(Integer.parseInt(splitStr[2]) );
		} 
       
       
		// 상품 출력
		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i].getName( ) + "(가격 : " + goods[i].getPrice() + "원 )이" + goods[i].getCountStock() + "개 입고 되었습니다.");
		}
		// 자원정리
		scanner.close();
	}
}
