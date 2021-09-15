package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress =InetAddress.getLocalHost();
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				//1byte가 4byte로 promotion 되면서 앞 3byte가 1로 채워진다
				//msb(최상위비트)가 1이어서 음수를 나타내므로 3byte는 0으로 and연산 데이터는 1로 and연산
				//16진수 4byte      0x 00 00 00 ff 로 and연산하면 뒤에 1byte만 그대로 나온다
				//System.out.print(address & 0xff);
				System.out.print((int)address & 0x000000ff);  
				System.out.print(".");
			}
			
			
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}

	}

}
