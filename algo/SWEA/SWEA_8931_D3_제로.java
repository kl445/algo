package algo_day4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_8931_D3_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int k=sc.nextInt();
			int sum=0;
			Stack<Integer> st= new Stack<>();
			
			for(int j=0;j<k;j++) {
				int num=sc.nextInt();
				
				if(num!=0) {
					st.push(num);
				}
				else {
					if(!st.isEmpty()) {
						st.pop();
					}
				}
			}
			
			if(st.isEmpty()) {
				
			}
			else {
				while(!st.isEmpty()) {
					sum+=st.pop();
				}
				
			}
			System.out.printf("#%d %d\n",i,sum);
		}
	}

}
