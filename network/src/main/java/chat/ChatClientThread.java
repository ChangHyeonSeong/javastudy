package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.SocketException;

/*
 * 210916
 * 성창현
 * chatting client thread impl
 * */
public class ChatClientThread extends Thread {
	private Socket socket;
	private boolean exitState;
	private Reader Reader;
    public ChatClientThread(Socket socket) {
    	this.socket = socket;
    	exitState = true;
    }
    
	public boolean isExitState() {
		return exitState;
	}

	public void stopThread() {
		exitState = false;
	}

	@Override
	public void run() {
		
		try {
			Reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while (exitState) {
				if (socket.isClosed() == false) {
					String response = ((BufferedReader) Reader).readLine();
					String[] tokens = response.split(":");

					if (tokens[0].equals("MESSAGE")) {
						// System.out.println();
						System.out.println(tokens[1] + ":" + tokens[2]);
					}
				}
			}
			
		} catch (SocketException e) {
			ChatClient.consoleLog("Thread socket error : " + e);
		} catch (IOException e) {
			ChatClient.consoleLog("Thread io error : " + e);
		}finally {
			try {
				
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
				ChatClient.consoleLog("Thread finally 정상 종료");
				

			} catch (IOException e) {
				ChatClient.consoleLog("Thread error:" + e);
			}
		}

	}

}
