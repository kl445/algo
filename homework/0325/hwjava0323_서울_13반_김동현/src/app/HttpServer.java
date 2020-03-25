package app;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try(ServerSocket ss= new ServerSocket(8080)) {
			System.out.println("server ready");
			
			while(true) {
				try(Socket socket =ss.accept()) {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					
					String html="<html><body><h1><Hello SSAFY!! 와우! </h1></body></html>";
					bw.write("HTTP/1.1 200 ok \r\n");
					
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
					
					
				} catch (Exception e) {
					
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
