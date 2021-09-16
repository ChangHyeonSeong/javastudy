package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * echoserver receive thread impl
 * */

public class EchoServerReceiveThread extends Thread {
	private Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);// true로
																													// 하면
																													// 버퍼
																													// 자동flush

			while (true) {
				String data = bReader.readLine();
				if (data == null) {
					EchoServer.log("closed by Client");
					break;
				}
				EchoServer.log("received: " + data);

				pWriter.println(data);
			}
		} catch (IOException e) {
			EchoServer.log("error:" + e);
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
