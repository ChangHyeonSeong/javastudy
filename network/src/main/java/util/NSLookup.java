package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.dozone.com";
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);//도메인네임에연결된 모든 주소 반환
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
