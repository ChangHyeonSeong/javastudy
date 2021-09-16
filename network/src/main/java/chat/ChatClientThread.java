package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/*
 * 210916
 * 성창현
 * chatting client thread impl
 * */
public class ChatClientThread extends Thread {
	private Reader reader;
	private boolean exitState;
    public ChatClientThread(Reader reader) {
    	this.reader = reader;
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
		BufferedReader bReader =(BufferedReader)reader;
		while(exitState) {
			
			try {
				String response = bReader.readLine();
				String[] tokens = response.split(":");
				
				if(tokens[0].equals("MESSAGE")) {
					//System.out.println();
					System.out.println(tokens[1] +":" +tokens[2]);
				}
				
			} catch (IOException e) {
				ChatClient.consoleLog("Thred error : " + e);
			}
		}
	}

}
