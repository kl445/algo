package algo.hw0429;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4050_D4_재관이의대량할인 {

	static int N;
	static int[] product;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int t = 0; t < tc; t++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t+1).append(" ");
			
			
			N=sc.nextInt();
			product=new int[N];
			
			for (int i = 0; i < N; i++) {
				product[i]=sc.nextInt();
			}	
			Arrays.sort(product);
			int p=N%3;
			int res=0;
			int idx=0;
			
			for (int i = 0; i <p; i++) {
				res+=product[idx++];
			}
			
			while (  idx < product.length-p) {
				idx++;
				res+=product[idx++];
				res+=product[idx++];
			}
			
			
//			for (int j=product.length-1; idx<j; j--) {
//				res+=product[idx++];
//				res+=product[idx++];
//			}
//			if(N%3!=0) {
//			res+=product[idx];
//			}
			sb.append(res);
			System.out.println(sb.toString());
			
			
			
			
			
			
			
		}
		
	}
	


}
