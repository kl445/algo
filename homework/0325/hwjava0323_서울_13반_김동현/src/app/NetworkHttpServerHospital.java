package app;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import medical.Hospital;

public class NetworkHttpServerHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Hospital univHospital =new Hospital("대학병원",15,"001",50,10);
		Hospital localHospital =new Hospital("동네병원",3,"901",10,2);
		
		
		List<Hospital> hospitalList=new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		
		StringBuilder sb= new StringBuilder();
		sb.append("<html><body><h2>병원정보</h2><table style = 'border: 1px solid green;'>");
		
		for (Hospital h : hospitalList) {
			sb.append("<tr style ='border: 1px solid green;'><td>").
			append(h.getName()).append("</td><td>").
			append(String.valueOf(h.getRoomEmptyCount())).append("</td></tr>");
		}
		sb.append("</table></body></html>");
		String html=sb.toString();
		
		try (ServerSocket ss= new ServerSocket(8090)){
			System.out.println("ready");
			
			while(true) {
				try(Socket socket =ss.accept()) {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					
					bw.write("HTTP/1.1 200 ok \r\n");
					bw.write("Content-Type: text/html;charset=");
					bw.write("Content-Length "+html.length());
					
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
