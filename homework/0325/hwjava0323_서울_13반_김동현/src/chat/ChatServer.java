
package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;

	public void service() {
		
		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {

				// 코드를 함께 작성해 봅시다.
				Socket s =ss.accept();
				System.out.println( "ChatClient가 접속함");
				
				ChatThread t= new ChatThread(s);
				chatThreadList.add(t);
				t.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast( String message ) {
		// 코드를 함께 작성해 봅시다.
		for (ChatThread t : chatThreadList) {
			try {
				t.sendMessage(message);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) 	{
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;
		
		public ChatThread(Socket socket) throws Exception {
			this.socket = socket;
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				while ( ! isExit ) {
					
					// 코드를 함께 작성해 봅시다.
					String msg= (String)ois.readObject();
					
					if("^".equals(msg)){
						chatThreadList.remove(this);
						isExit =true;
					}else {
						broadcast(msg);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				chatThreadList.remove(this);
			}
		}

		public void sendMessage(String message) throws Exception {
			// 코드를 함께 작성해 봅시다.
			oos.writeObject(message);
		}
	}
}
