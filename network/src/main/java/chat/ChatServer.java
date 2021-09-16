package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
/*
 * 210916
 * 성창현
 * chatting sever impl
 * */


public class ChatServer {

		private static final int PORT = 8080;
		public static void main(String[] args) {
			List<Writer> pwList= new ArrayList<Writer>();
			
			ServerSocket serverSocket = null;
				//1. 서버소켓 생성
				try {
					serverSocket = new ServerSocket();

					// 2. 바인딩(binding)
					// Socket에 InetSocketAddress(IPAddress + port)
					// IPAddress : 0.0.0.0 특정 호스트 IP바인딩 하지 않는다.-> 모든 IP로 부터의 연결을 허용
					serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
					consoleLog("starts... [port:" + PORT + "]");

					while (true) {
						Socket socket = serverSocket.accept();// blocking
						
						new ChatServerThread(socket, pwList).start();
					}
				} catch (SocketException e) {
					consoleLog("error : "+e);	
				} catch (IOException e) {
					consoleLog("error : "+e);
				}finally {
					try {
						if(serverSocket != null && serverSocket.isClosed() == false) {
						      serverSocket.close();
						}
					} catch (IOException e) {
						consoleLog("error : "+e);
					}
				}	
				
		}
		
		public static void consoleLog(String log) {
			System.out.println("[Chat Server]" + log);
		}
	
}
