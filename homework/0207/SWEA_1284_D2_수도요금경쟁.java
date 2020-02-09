package swea_0207;

import java.util.Scanner;

public class SWEA_1284_D2_수도요금경쟁 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int p=sc.nextInt();
			int q= sc.nextInt();
			int r= sc.nextInt();
			int s= sc.nextInt();
			int w= sc.nextInt();
			
			int type1=p*w;
			int type2=0;
			
			if(w<=r) {
				type2=q;
				}
			else {
				type2=q+(w-r)*s;
			}
			
			int min=Math.min(type1, type2);
			
			System.out.printf("#%d %d\n",i,min);
		}
	}

}
