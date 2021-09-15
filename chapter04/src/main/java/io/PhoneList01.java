package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
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
			
			//1. 기반 스트림(표준입력, stdin, System.in)
			FileInputStream fis = new FileInputStream(file);
			
			//2. 보조 스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			
			//3. 보조 스트림2(char|char|char|char|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			//처리
			String line = null;
			while((line = br.readLine()) != null) {      //끝이면 null return
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0) { //이름
						System.out.print(token + ":");
					}else if(index == 1 ) { //전번1
						System.out.print(token + "-");
					}else if(index == 2 ) { //전번2
						System.out.print(token + "-");
					}else { //전번3
						System.out.print(token);
					}
					index++;
				}
				System.out.println("");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("error:" + e);
		} catch (IOException e) {
            System.out.println("error:" + e);
		}finally {
			try {
				if(br != null) {
				   br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
