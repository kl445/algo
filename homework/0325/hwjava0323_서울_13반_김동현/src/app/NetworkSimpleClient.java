package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkSimpleClient {

	public static void main(String[] args) {

		String host= "localhost";
		int port=8080;
		
		try(Socket socket=new Socket(host,port)){
		
			InputStream input= socket.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			String msg= reader.readLine();
			System.out.println(msg);
		
		
		}catch(IOException e){
			System.out.println("error");
		}
	}

}
