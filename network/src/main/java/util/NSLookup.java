package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("IP주소를 입력하세요");
			System.out.print(">>");
			String line = scanner.nextLine();
			System.out.println();
			try {
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);// 도메인네임에연결된 모든 주소 반환
                for(InetAddress ia : inetAddresses) {
                	System.out.println(ia);
                }
                System.out.println();
			} catch (UnknownHostException e) {
				System.out.println("존재하지 않는 IP주소입니다");
			}
		}

	}

}
