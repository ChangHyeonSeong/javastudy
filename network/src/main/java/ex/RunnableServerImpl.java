package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RunnableServerImpl implements Runnable {
	private ServerSocket Ssocket;
	private Socket socket;
	private BufferedReader bReader;
	private PrintWriter pWriter;
	public RunnableServerImpl(ServerSocket Ssocket){
		this.Ssocket = Ssocket;
		
	}
	public void IOpipeConnect(String encode) {
		try {
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), encode));
			pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), encode), true);
		} catch (IOException e) {
			System.out.println("스트림오류:" +e);
		}

	}
	@Override
	public void run() {
		try {
			socket = Ssocket.accept();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IOpipeConnect("UTF-8");
		try {
			while (true) {
				String data = bReader.readLine();
				if (data == null) {
					MutiThreadServer.log("closed by Client");
					break;
				}
				MutiThreadServer.log("received: " + data);

				pWriter.println(data);
			}
		} catch (IOException e) {
			MutiThreadServer.log("error:" + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
