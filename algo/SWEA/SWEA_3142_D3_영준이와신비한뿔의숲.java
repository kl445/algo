package swea_0207;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3142_D3_영준이와신비한뿔의숲 {

	
	public static void perm(int r, int c, int total_horn,int[] total_num) {
		if(r==c) {

			return;
		}
			else {
				for (int i = 1; i <= 2; i++) {
					total_horn+=i;
					total_num[i]++;
					perm(r,c+1,total_horn,total_num);
				}
			}
	}
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; 	i <=tc; i++) {
			
			int horn=sc.nextInt();
			int num=sc.nextInt();
			
			int one=0;
			int two=0;
			
			int total_num[] =new int[3];
			perm(num,0,0,total_num);
			
			System.out.println(Arrays.toString(total_num));
			
			
			
			
		}

	}

}
