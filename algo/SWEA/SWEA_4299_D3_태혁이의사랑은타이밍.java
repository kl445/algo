package swea_0213;

import java.util.Scanner;

public class SWEA_4299_D3_태혁이의사랑은타이밍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			int d=sc.nextInt();
			int h=sc.nextInt();
			int m=sc.nextInt();
			
			int n_day=0;
			n_day+=d*60*24;
			n_day+=h*60;
			n_day+=m;
			
			int p_day=0;
			d=11;
			h=11;
			m=11;
			p_day+=d*60*24;
			p_day+=h*60;
			p_day+=m;
			
			int range=n_day-p_day;
			
			System.out.printf("#%d %d\n",i,range>=0?range:-1);
			
			
			
		}
	}

}
