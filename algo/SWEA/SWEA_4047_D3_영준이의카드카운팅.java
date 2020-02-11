package swea_0211;

import java.util.Scanner;

public class SWEA_4047_D3_영준이의카드카운팅 {

	public static boolean istwo(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>1)
				return true;
		}
		return false;
	}
	
	public static int empty(int[] arr) {
		int emp=13;
		
		for (int i = 1; i < arr.length; i++) {
			emp-=arr[i];
		}
		return emp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			String str= sc.next();
			
//			if(str.length()>156) {
//				System.out.printf("#");
//			}
			
			int n=str.length()/3;
			
			
			int[] sCard=new int[14];
			int[] dCard=new int[14];
			int[] hCard=new int[14];
			int[] cCard=new int[14];
			
			
			for (int j = 0; j < str.length(); j+=3) {
				char type=str.charAt(j);
				int ten=(str.charAt(j+1)-'0')*10;
				int one=(str.charAt(j+2)-'0');
				int num=ten+one;
				
				
				switch(type) {
				
				case 'S':
					sCard[num]++;
					break;
				case 'D':
					dCard[num]++;
					break;
				case 'H':
					hCard[num]++;
					break;
				case 'C':
					cCard[num]++;
					break;
				}
					
				
			}
			
			boolean flag=false;
			int[] ans=new int[4];
			
			if(istwo(sCard) || istwo(dCard) || istwo(hCard) || istwo(cCard)) {
				System.out.println("#"+i+" ERROR");
			}
			else {
				ans[0]=empty(sCard);				
				ans[1]=empty(dCard);				
				ans[2]=empty(hCard);				
				ans[3]=empty(cCard);	
				
				System.out.printf("#%d %d %d %d %d\n",i,ans[0],ans[1],ans[2],ans[3]);
			}
			
			
			
			
		}
	}

}
