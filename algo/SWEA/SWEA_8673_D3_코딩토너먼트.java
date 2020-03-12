package algo.hw0224;

import java.util.Scanner;

public class SWEA_8673_D3_코딩토너먼트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			int n= sc.nextInt();
			
			int player[]= new int[(int)Math.pow(2, n)];
			
			for (int j = 0; j < player.length; j++) {
				player[j]=sc.nextInt();
				
			}
			
			
//			for (int j = 0; j < player.length-1; j+=2) {
//				int n1=player[j];
//				int n2=player[j+1];
//				
//				bor+=Math.abs(n1-n2);
//				player[j]=Math.max(n1,n2);
//				player[j+1]=-1;
//			
//			}
			bor=0;
			go(player);
			
			System.out.printf("#%d %d\n",i,bor);
			
			
		}
		
	}
	private static int bor=0;
	
	public static void go(int[] array) {
		
		int[] temp=new int[array.length/2];
		int idx=0;
		
		if(array.length==1) {
			return;
		}
		for (int j = 0; j < array.length-1; j+=2) {
			int n1=array[j];
			int n2=array[j+1];
			
			bor+=Math.abs(n1-n2);
			temp[idx++]=Math.max(n1,n2);
		}
		go(temp);
		
	}

}
