package app;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.ws.handler.MessageContext.Scope;

public class NetworkSimpleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port=8080;
		
		try (ServerSocket serverSocket= new ServerSocket(port)){
			System.out.println("start");
			while(true) {
				Socket socket= serverSocket.accept();
				OutputStream output=socket.getOutputStream();
				PrintWriter writer= new PrintWriter(output,true);
				writer.println("hello");
			}
			
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}
		System.out.println("end");
	}

}
