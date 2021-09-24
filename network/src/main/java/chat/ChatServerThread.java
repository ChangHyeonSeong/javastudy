package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;


/*
 * 210916
 * 성창현
 * chatting server thread impl
 * */
public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> pwList;
	public ChatServerThread(Socket socket, List<Writer> pwList) {
		this.socket = socket;
		this.pwList = pwList;
	}
	
	@Override
	public void run() {
		BufferedReader bReader = null;
		PrintWriter pWriter = null;
		try {
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while (true) {
				
				String request = bReader.readLine();
				if (request == null) {
					consoleLog( nickname+" 으로 부터 연결 끊김" );
				    doQuit(pWriter);
					break;
				}
				String[] tokens = request.split(":");
	
				switch (tokens[0]) {
				    case "JOIN":
				    	doJoin( tokens[1], pWriter );
					    break;
				    case "MESSAGE":
				    	if(tokens.length >= 2) {
				    	    doMessage( tokens[1]);
				    	}
					    break;
                    case "quit":
                    	doQuit(pWriter);
                    	return;
				    default:
				    	consoleLog("에러:알수 없는 요청(" + tokens[0] + ")" );
					    break;
				}	
			}
		} catch (IOException e) {
			consoleLog("error : " + e);
		}finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					if(pWriter != null) {
					    pWriter.println("");
					}
					socket.close();
					//consoleLog("정상 종료");
				}
			} catch (IOException e) {
				consoleLog("error : " + e);
			}
		}
		
	}
	
	public void doJoin(String nickname, PrintWriter pWriter) {
		this.nickname = nickname;
		synchronized (pwList) {
			String data = "MESSAGE:"+nickname +":님이 참여하였습니다.";
			broadcast( data );
			pWriter.println("JOIN:OK");
			addWriter( pWriter );
		}
		consoleLog(nickname + " 접속 완료");
		
	}

	public void doMessage(String message) {
		broadcast( "MESSAGE:"+nickname +":" + message );
	}

	public void doQuit(Writer pWriter) {
		broadcast( "MESSAGE:"+nickname+":님이 퇴장 하였습니다.");
		removeWriter(pWriter);
		consoleLog(nickname + " 접속 종료");
	}
	
	
	
	public void removeWriter(Writer pWriter) {
		synchronized(pwList) {
			pwList.remove(pWriter);
		}
	}

	public void broadcast(String data) {
		synchronized (pwList) {
			for (Writer writer : pwList) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}
		}
	}
	
	public void addWriter(PrintWriter pWriter) {
		synchronized (pwList) {
			pwList.add(pWriter);
		}
	}

	public void consoleLog( String message ) {
		System.out.println( "[SeverThread#" + getId() + "-" +nickname + "] " + message );
	}
	

}
