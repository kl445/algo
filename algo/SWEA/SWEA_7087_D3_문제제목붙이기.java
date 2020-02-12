package swea_0212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_7087_D3_문제제목붙이기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			String name[]= new String[n];
			
			for (int j = 0; j < n; j++) {
				name[j]=sc.next();
			}
			
			Arrays.sort(name, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Character res1=o1.charAt(0);
					Character res2=o2.charAt(0);
					return res1.compareTo(res2);
				}
			});
			
			char start='A'-1;
			int cnt=0;
			
			for (int j = 0; j < name.length; j++) {
				
				if((start+1)==name[j].charAt(0)) {
					cnt++;
					start++;
				}
			}
			
			System.out.printf("#%d %d\n",i,cnt);
			
			
			
		}
	}

}
