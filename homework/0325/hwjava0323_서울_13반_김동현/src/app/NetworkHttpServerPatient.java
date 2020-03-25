package app;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import medical.Hospital;
import person.Patient;

public class NetworkHttpServerPatient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Patient p1= new Patient("김상상", 42, "010-1111-111", "호흡곤란", "001", true);
		Patient p2= new Patient("박상상", 30, "010-222-2222", "과음", "901",false);
		
		
		List<Patient> patientlList=new ArrayList<Patient>();
		patientlList.add(p1);
		patientlList.add(p2);
		
		StringBuilder sb= new StringBuilder();
		sb.append("<html><body><h2>환자 정보</h2><table style = 'border: 1px solid green;'>");
		
		
		
		for (Patient p : patientlList) {
			String name=p.getName().charAt(0)+"XX";
			String phone=p.getPhone().substring(0, 9)+"XXXX";
			
			sb.append("<tr style ='border: 1px solid green;'><td>").
			append("<b>이름:</b> "+name).append("</td><td>")
			.append("<b>나이:</b> "+p.getAge()).append("</td><td>")
			.append("<b>전화번호:</b> "+phone).append("</td><td>")
			.append("<b>병명:</b> "+p.getDiseaseName()).append("</td><td>")
			.append("</td></tr>");
		}
		sb.append("</table></body></html>");
		String html=sb.toString();
		
		try (ServerSocket ss= new ServerSocket(8090)){
			System.out.println("ready");
			
			while(true) {
				try(Socket socket =ss.accept()) {
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					
					bw.write("HTTP/1.1 200 ok \r\n");
					bw.write("Content-Type: text/html;charset=utf-8\r\n");
					bw.write("Content-Length "+html.length()+"\r\n");
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
