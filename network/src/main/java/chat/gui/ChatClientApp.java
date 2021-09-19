package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import chat.ChatClientThread;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8080;
	
	public static void main(String[] args) {
		Socket socket = null;
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		
		try {
			//1. create socket
			socket = new Socket();
			
			//2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//3. get iostream
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//4. join
			pWriter.println("JOIN:" + name);
			
			String response = bReader.readLine();

			if("JOIN:OK".equals(response)) {
				System.out.println("채팅방에 입장하였습니다.");
				new ChatWindow(socket,name).show();
			} else {
				consoleLog("채팅서버연결실패");
				return;
			}
		} catch (SocketException e) {
			consoleLog("suddenly closed by server : "+e);	
		} catch (IOException e) {
			consoleLog("error:" + e);
		}

	}
	public static void consoleLog(String log) {
		System.out.println("[Chat Client] " + log);
	}

}
