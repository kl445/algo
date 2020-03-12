package algo.hw0224;

import java.util.Arrays;
import java.util.Scanner;


public class SWEA_1952_모의_수영장 {
	
	private static int check[]= {1,2,3};
	private static int day, month, threemonth, year,min;
	
	public static void dayOrMonth(int[] month_type,int[] swim) {
		
		int money=0;
		
		
		
		for (int i = 0; i < month_type.length; i++) {
			if(month_type[i]==1) {
				money+=swim[i]*day;
			}
			else if(month_type[i]==2) {
				money+=month;
			}
			else if(month_type[i]==3) {
				i=i+2;
				money+=threemonth;
			}
		}
		
		
		min=Math.min(min, money);
		
		
	}
	public static void dfs(int r,int c,int[] month_type,int[] swim) {
		
		if(r==c) {
			for (int i = 0; i < month_type.length; i++) {
				if(month_type[i]!=0 ) {
//					System.out.print(i+" ");
				}
				
			}
//			System.out.println();
			dayOrMonth(month_type, swim);
			
			return;
		}
		else {
			for (int i = 0; i < check.length; i++) {
				if(swim[c]!=0) {
				month_type[c]=check[i];
				}
				dfs(r, c+1, month_type,swim);
				
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
		day=sc.nextInt();
		month=sc.nextInt();
		threemonth=sc.nextInt();
		year=sc.nextInt();
		
		int swim[]=new int[12];
		
		for (int j = 0; j < 12; j++) {
			swim[j]=sc.nextInt();
		}
		
		min=year;
		
		
		int month_type[]=new int[12];
		
		dfs(12, 0, month_type,swim);
		
		
		
		System.out.printf("#%d %d\n",i,min);
		
		
		
		
		}
	}

}
