package app;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			InetAddress[] naver= InetAddress.getAllByName("naver.com");
			
			for (InetAddress inetAddress : naver) {
				System.out.println(inetAddress.getHostAddress());
			}
			InetAddress localhost=InetAddress.getLocalHost();
			System.out.println(localhost);
		} catch (UnknownHostException e) {
			// TODO: handle exception
		}
	}

}
