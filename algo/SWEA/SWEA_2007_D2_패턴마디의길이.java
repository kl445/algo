package swea_0211;

import java.util.Scanner;

public class SWEA_2007_D2_패턴마디의길이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			String str= sc.next();
			
			StringBuilder sb= new StringBuilder();
			
			int cnt=0;
			
			for (int j = 0; j < str.length(); j++) {
				sb.append(str.charAt(j));

				String str_test=str.substring(sb.length(),(sb.length()*2));
				
				StringBuilder sb2= new StringBuilder();
				sb2.append(str_test);
				
				if(sb.toString().equals(sb2.toString())) {
					cnt=sb.length();
					break;
				}
			}
			
			
			System.out.printf("#%d %d\n",i,cnt);
		}
	}

}
