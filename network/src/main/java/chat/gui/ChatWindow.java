package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

import com.sun.glass.events.WindowEvent;


public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;

	public ChatWindow(Socket socket, String name) {
		this.socket = socket;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		/*
		 * 1.UI 초기화
		 * */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		
		//옵저버패턴
		//어나니머스 클래스 이용하여 인터페이스 객체 생성
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		
		//람다식 이름없는 함수 추론하여 완성
//		buttonSend.addActionListener( (e)-> {
//				System.out.println("click");
//				sendMessage();
//			});
		//함수 안에 한 줄일 때
//		buttonSend.addActionListener( (e)-> System.out.println("click") );
	 
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		try {
			/*
			 * 2.IOStream 가져오기
			 */
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			/*
			 * 3. Chat Client Thread 생성
			 */
			new ChatClientThread(bReader);
			
			
		} catch (IOException e) {
			ChatClientApp.consoleLog("error : "+ e);
		} 
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현:" + message);
		textField.setText("");
		textField.requestFocus();
		
		
		//Receive Thread에서 서버로 부터 메세지가 있다고 치고~(가짜 데이터)
		updateTextArea("마이콜:" + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
	    System.out.println("소켓 닫기 or 방나가기 프로토콜 구현");
	    try {
			socket.close();
		} catch (IOException e) {
			ChatClientApp.consoleLog("Thread error : "+ e);
		}
	    System.exit(0);
	}
	private class ChatClientThread extends Thread{
		Reader Reader;
		public ChatClientThread(Reader Reader) {
			this.Reader = Reader;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String response = ((BufferedReader) Reader).readLine();
					if (response.isEmpty() == true) {
						break;
					}
					String[] tokens = response.split(":");

					if (tokens[0].equals("MESSAGE")) {
						updateTextArea(tokens[1] + ":" + tokens[2]);
					}
				}
			} catch (IOException e) {
				ChatClientApp.consoleLog("Thread error : "+ e);
			}
		}
	}
}
