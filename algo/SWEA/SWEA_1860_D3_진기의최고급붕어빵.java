package algo.hw0224;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_D3_진기의최고급붕어빵 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			int[] customer=new int[n];
			int m=sc.nextInt();
			int k=sc.nextInt();
			for (int j = 0; j < customer.length; j++) {
				customer[j]=sc.nextInt();
			}
			Arrays.sort(customer);
		
			boolean flag=true;
			int sel=0;
			
			for (int j = 0; j < customer.length; j++) {
				
				if(customer[j]/m==0) {
					flag=false;
					break;
				}
				else{
					int time=customer[j]/m;
					int les=customer[j]/m*k;
					
					if((les-sel)<=0) {
						flag=false;
						break;
					}
					sel++;
				}
			}
			if(flag) {
				System.out.printf("#%d Possible\n",i);
			}else {
				System.out.printf("#%d Impossible\n",i);
			}
		}
		
	}

}
