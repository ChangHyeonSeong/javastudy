package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/*
 * 210916
 * 성창현
 * chatting client impl
 * */
public class ChatClient {
	private static final String SERVER_IP = "115.22.10.134";
    private static final int SERVER_PORT = 8080;
    
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		ChatClientThread cThread = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("닉네임을 입력하세요.");
			System.out.print(">>");
			String name = scanner.nextLine();
			
			// 소켓 생성
			socket = new Socket();

			// 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
		
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            
			//채팅 프로토콜 연결
			pWriter.println("JOIN:" + name);
			//채팅 프로토콜 확인 후 클라이언트쓰레드실행
			String response = bReader.readLine();

			String[] tokens = response.split(":");
			

		    if(tokens[0].equals("JOIN")) {
		    	if(tokens[1].equals("OK")) {
		    		cThread = new ChatClientThread(bReader);
		    		cThread.start();
		    	}
		    }else {
		    	consoleLog("서버연결실패");
		    	return;
		    }
			
			//입력받은 메세지 전송
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals( input ) == true ) {
					  pWriter.println(input +":");
					  cThread.setFlag(false);
			          break;
			    } 
				
				pWriter.println("MESSAGE:" + input);
			}
			
		} catch (SocketException e) {
			consoleLog("suddenly closed by server");
		} catch (IOException e) {
			consoleLog("error:" +e);
		}finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
			           socket.close();
				}
		
			}catch(IOException e){
				consoleLog("error:" +e);
			}
		}
			
	}
	public static void consoleLog(String log) {
		System.out.println("[Chat Client] " + log);
	}
    
}
