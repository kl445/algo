package algo.hw0224;

import java.util.Scanner;

public class SWEA_5431_D3_민석이의과제체크하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			int n=sc.nextInt();
			int k=sc.nextInt();
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(i);
			boolean[] student=new boolean[n];
			
			for (int j = 0; j < k; j++) {
				student[sc.nextInt()-1]=true;
			}
			
			for (int j = 0; j < student.length; j++) {
				if(!student[j]) {
					sb.append(" ").append(j+1);
				}
			}
			
			System.out.println(sb.toString());
		}
	}

}
