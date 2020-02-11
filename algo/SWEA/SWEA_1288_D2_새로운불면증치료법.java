package swea_0211;

import java.util.Scanner;

public class SWEA_1288_D2_새로운불면증치료법 {

	
	public static boolean isT(boolean[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			if(!arr[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			boolean isgoing[]=new boolean[10];
			int j=1;
			Integer num = 1;
			while(!isT(isgoing)) {
				
				num=n*j;
				
				String str=num.toString();
				
				for (int k = 0; k < str.length(); k++) {
					isgoing[(str.charAt(k)-'0')]=true;
				}
				
				j++;
			}
			
			System.out.printf("#%d %d\n",i,num);
			
			
		}
	}
	


}
