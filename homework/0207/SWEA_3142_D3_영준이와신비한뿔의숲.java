package swea_0207;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3142_D3_영준이와신비한뿔의숲 {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int horn=sc.nextInt();
			int num=sc.nextInt();
			
			
			int one=0;
			int two=0;
			
			for(one=0;one<=num;one++) {
				two=num-one;
				if((one*1)+(two*2)==horn) {
					break;
				}
				
			}
			

			System.out.printf("#%d %d %d\n",i,one,two);
			
		}

	}

}
