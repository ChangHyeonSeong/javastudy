package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
/*
 * echoserver mutithread impl
 * */
public class EchoServer {
    private static final int PORT = 8000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		
			//1. 서버소켓 생성
			try {
				serverSocket = new ServerSocket();

				// 2. 바인딩(binding)
				// Socket에 InetSocketAddress(IPAddress + port)
				// IPAddress : 0.0.0.0 특정 호스트 IP바인딩 하지 않는다.-> 모든 IP로 부터의 연결을 허용
				serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
				log("starts... [port:" + PORT + "]");

				while (true) {
					Socket socket = serverSocket.accept();// blocking
					
					InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
					String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
					int remoteHostPort = inetRemoteSocketAddress.getPort();
					System.out.println("[server] connected by client[" + remoteHostAddress + ":" +remoteHostPort + "]");
			
					
					new EchoServerReceiveThread(socket).start();
				}
			} catch (SocketException e) {
				System.out.println("[sever error]" + e);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
