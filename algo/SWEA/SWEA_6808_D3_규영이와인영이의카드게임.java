package swea_0206;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_D3_규영이와인영이의카드게임 {

	private static int[] array= new int[18];
	private static int win=0, lose=0;
	private static boolean[] visited=new boolean[18];
	
	public static void game(int[] p1, int[] p2) {
		int p1_score=0;
		int p2_score=0;
//		System.out.println("in game"+num);
		for(int i=0;i<p1.length;i++) {
			
			if(p1[i]>p2[i]) {
				p1_score+=p1[i]+p2[i];
			}
			else if(p1[i]<p2[i]) {
				p2_score+=p1[i]+p2[i];
			}
		}
		
		if(p1_score>p2_score) {
			win++;
		}
		else if(p1_score<p2_score) {
			lose++;
		}
//		System.out.println("end game"+(num++));
	}
	
	public static boolean use(int[] tem,int n) {
		for (int i = 0; i < tem.length; i++) {
			if((n+1)==tem[i]) {
				return true;
			}
		}
		return false;
	}
	public static void perm(int r, int c, int[] temp, int[]gyou,int iny[]) {
		
		if(r==c) {
			
			game(gyou,temp);
			return;
		}else {
			for(int i=0;i<iny.length;i++) {
				
				if(!visited[i] ) {
					visited[i]=true;
					temp[c]=iny[i];
					perm(r,c+1,temp,gyou,iny);
					visited[i]=false;
					}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		
		
		for(int i=1; i<=tc;i++) {
			int[] gyou=new int[9];
			
			int[] tmepcard= new int[18+1];
			for (int j = 0; j < tmepcard.length; j++) {
				tmepcard[j]=j;
			}
			
			for (int j = 0; j < gyou.length; j++) {
				gyou[j]=sc.nextInt();
				tmepcard[gyou[j]]=0;
			}
			
			int[] iny=new int[9];
			
			
			
			int ind=0;
			for (int j = 0; j < tmepcard.length; j++) {
				if(tmepcard[j]>0) {
					iny[ind++]=tmepcard[j];
				}
			}
//			System.out.println(Arrays.toString(iny));
			
			
			win=0;
			lose=0;
			
			perm(9,0,new int[9],gyou,iny);
			
			
			System.out.printf("#%d %d %d\n",i,win,lose);
		}
		
		
	}

}
