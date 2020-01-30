package algo_day4;

import java.util.Scanner;

public class JA_1175_주사위던지기2 {

	private static int[] dice= {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

		int n= sc.nextInt();
		int m= sc.nextInt();
		
		permut(n, 0, new int[n],m);
	}

	//합계 테스트
	public static void sumTest(int[] temp,int m) {
		int[] count=new int[dice.length+1];
		int sum=0;
		
		for(int i=0;i<temp.length;i++) {
			count[temp[i]]++;
			sum+=temp[i];
		}

		
		if(sum==10) {
		for(int i=0;i<temp.length;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		}
		
	}

	public static void permut(int n, int current, int[] temp,int m) {
		if(n==current) {
			sumTest(temp,m);
		}
		else {
			for(int i=0; i<dice.length;i++) {
					temp[current]=dice[i];
					permut(n, current+1, temp, m);
			}
		}
	}
}
