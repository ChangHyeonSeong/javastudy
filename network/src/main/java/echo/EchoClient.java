package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "115.22.10.134";
    private static final int SERVER_PORT = 6000;
    
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			// 1.소켓 생성
			socket = new Socket();

			// 2.서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
            log("connected");
//            System.out.println(socket.getLocalPort());
//            System.out.println(socket.getPort());
//            System.out.println(socket.getInetAddress());
//            System.out.println(socket.getLocalAddress());
//            System.out.println(socket.getLocalSocketAddress());
            
            
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            
			while (true) {
				System.out.print(">");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}
				
				pWriter.println(line);
				
				String data =bReader.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				
				System.out.println("<" + data);
			}
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			log("error:" +e);
		}finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
			           socket.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[Echo Client]" + log);
	}

}
