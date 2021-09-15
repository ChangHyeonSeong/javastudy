package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final int PORT = 6000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(binding)
			//   Socket에 InetSocketAddress(IPAddress + port)
			//   IPAddress : 0.0.0.0 특정 호스트 IP바인딩 하지 않는다.-> 모든 IP로 부터의 연결을 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:"+PORT+"]");
			
			Socket socket = serverSocket.accept();//blocking
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" +remoteHostPort + "]");
			
			
			try {
				BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);// true로
																														// 하면
																														// 버퍼
																														// 자동flush

				while (true) {
					String data = bReader.readLine();
					if (data == null) {
						log("closed by Client");
						break;
					}
					log("received: " + data);

					pWriter.println(data);
				}
			} catch (IOException e) {
				log("error:" + e);
			} finally {
				try {
					if (socket != null && socket.isClosed() == false) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			log("error: " +e);
		}finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
				      serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[Echo Server]" + log);
	}
}
