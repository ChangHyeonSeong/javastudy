package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList2 {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		try {
			File file = new File("phone.txt"); //File 정보를 알수있는 클래스
			
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("======= 파일 정보 ========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("======= 전화번호 ========");
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found:" + e);
		}finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}

}
