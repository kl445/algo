package algo_day4;

import java.util.Scanner;

public class JA_1169_주사위던지기1 {

	private static int[] dice= {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

		int n= sc.nextInt();
		int m= sc.nextInt();
		
		
		switch (m){
		case 1:
			permut(n, 0, new int[n], new boolean[6]);

			break;
			
		case 2:
			permut2(n, 0, new int[n],0);
			break;
		case 3:
			permut3(n, 0, new int[n], new boolean[6]);
			break;
		}
		
		

	}
	
	public static void permut(int n, int current, int[] temp, boolean[] visited) {
		if(n==current) {
			for(int i=0;i<temp.length;i++) {
				System.out.print(temp[i]+" ");
			}
			System.out.println();
		}
		
		else {
			for(int i=0; i<dice.length;i++) {
				if(!visited[i]) {
					visited[i]=false;
					temp[current]=dice[i];
					permut(n, current+1, temp, visited);
					visited[i]=false;
				}
			}
			
		}
		
	}
	
//	public static void doubleTest2(int[] temp) {
//		int[] count=new int[dice.length+1];
//		
//		for(int i=0;i<temp.length;i++) {
//			count[temp[i]]++;
//		}
//		
//		for(int i=0;i<count.length;i++) {
//			if(count[i]>1) {
//				System.out.println("중복");
//				return; 
//			}
//		}
//		for(int i=0;i<temp.length;i++) {
//			System.out.print(temp[i]+" ");
//		}
//		System.out.println();
//		
//	}
	

	
	public static void permut2(int n, int current, int[] temp, int before) {
		if(n==current) {
			for(int i=0;i<temp.length;i++) {
				System.out.print(temp[i]+" ");
			}
			System.out.println();
		}
		
		else {
			for(int i=before; i<dice.length;i++) {
					temp[current]=dice[i];
					permut2(n, current+1, temp, i);
				
			}
			
		}
		
	}
	//중복된 숫자 제거
	public static void doubleTest3(int[] temp) {
		int[] count=new int[dice.length+1];
		
		for(int i=0;i<temp.length;i++) {
			count[temp[i]]++;
		}
		
		for(int i=0;i<count.length;i++) {
			if(count[i]>1) {
//				System.out.println("중복");
				return; 
			}
		}
		
		for(int i=0;i<temp.length;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		
	}
	
	public static void permut3(int n, int current, int[] temp, boolean[] visited) {
		if(n==current) {
			doubleTest3(temp);
		}
		
		else {
			for(int i=0; i<dice.length;i++) {
				if(!visited[i]) {
					visited[i]=false;
					temp[current]=dice[i];
					permut3(n, current+1, temp, visited);
					visited[i]=false;
				}
			}
			
		}
		
	}

}
