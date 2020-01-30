package algo_day4;

import java.util.Scanner;

public class SWEA_5215_D3_햄버거다이어트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		
		int tc=sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			
			int n=sc.nextInt();
			int l=sc.nextInt();
			int[] score_array=new int[n];
			int[] cal_array=new int[n];
			for(int j=0; j<n;j++) {
				score_array[j]=sc.nextInt();
				cal_array[j]=sc.nextInt();
			}
			
			int[] sum_score=new int[(1<<n)];
			int[] sum_cal=new int[(1<<n)];
			
			for(int j=0; j<sum_score.length;j++) {
				for(int k=0;k<n;k++) {
					if((j&(1<<k))>0) {
						sum_score[j]+=score_array[k];
						sum_cal[j]+=cal_array[k];
					}
					
				}
			}
			
			int max= 0;
			for(int j=0;j<sum_score.length;j++) {
				if(sum_cal[j]<=l) {
					max=Math.max(max, sum_score[j]);
				}
			}
			System.out.printf("#%d %d\n",i,max);
			
			
		}

	}

}
