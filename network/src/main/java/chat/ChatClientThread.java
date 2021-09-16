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
	private boolean flag;
    public ChatClientThread(Reader reader) {
    	this.reader = reader;
    	flag = true;
    }
    
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		BufferedReader bReader =(BufferedReader)reader;
		while(flag) {
			
			try {
				String response = bReader.readLine();
				String[] tokens = response.split(":");
				
				if(tokens[0].equals("MESSAGE")) {
					//System.out.print(">>");
					System.out.println(tokens[1]);
				}
				
			} catch (IOException e) {
				ChatClient.consoleLog("Thred error : " + e);
			}
		}
	}

}
