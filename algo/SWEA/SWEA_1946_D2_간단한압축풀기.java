package swea_0212;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1946_D2_간단한압축풀기 {


	public static void main(String[] args) {


		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			
			int num[]=new int[n];
			char c[]=new char[n];
			
			int sum=0;
			for (int j = 0; j < c.length; j++) {
				
			
			c[j]=sc.next().charAt(0);
			num[j]=sc.nextInt();
			sum+=num[j];
			}
			
			boolean flag=false;
			
			char[] arr= new char[sum];
			
			ArrayList<Character> list = new ArrayList<>();
			
			for (int j = 0; j < num.length; j++) {
				
				for (int k = 0; k < num[j]; k++) {
					list.add(c[j]);
				}
			}
			
			int cnt=0;
			System.out.println("#"+i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
				cnt++;
				if(cnt==10) {
					System.out.println();
					cnt=0;
				}
			}
			System.out.println();
			
			
		}

	}

}
