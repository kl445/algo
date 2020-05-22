package algo.hw0522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_모의_보호필름 {

	static int R,C,K;
	static int[][] map;
	static int min;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(input.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
		
			StringTokenizer tk=new StringTokenizer(input.readLine());
			
			R=Integer.parseInt(tk.nextToken());
			C=Integer.parseInt(tk.nextToken());
			K=Integer.parseInt(tk.nextToken());
			map=new int[R][C];
			
			for (int i = 0; i < R; i++) {
				tk=new StringTokenizer(input.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j]=Integer.parseInt(tk.nextToken());
				}
			}

			
			min=Integer.MAX_VALUE;
			perm(0,new int[R],0);
			
			min=min==Integer.MAX_VALUE?K:min;

			System.out.println("#"+tc+" "+min);
			
			
		}
	}

	private static void perm(int cur,int[] temp,int chemical_try) {
	
//		if(chemical_try==K) {
//			return;
//		}
		if(cur==R ||chemical_try==K) {
			
			chemical(temp,chemical_try);
			return;
		}
		
		
		for (int i = 0; i < 3; i++) {
			temp[cur]=i;
			if(i!=0) {				
				perm(cur+1, temp,chemical_try+1);
			}else {
			perm(cur+1, temp,chemical_try);
			}
		}
		
	}
	

	private static void chemical(int[] temp,int chemical_try) {
	
		for (int i = 0; i < map[0].length; i++) {
			boolean flag=false;
			int chain=1;
			int[] array=new int[C];
			int prev=-1;
			int now=0;
			for (int j = 0; j < map.length; j++) {
				if(temp[j]==0) {
					now=map[j][i];
				}
				else if(temp[j]==1) {
					now=0;
				}
				else if(temp[j]==2) {
					now=1;
				}
				
				if(now==prev) {
					chain++;
					
				}
				else {
					chain=1;
				}
				prev=now;
				
				if(chain==K) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return ;
			}
		}
		min=Math.min(min, chemical_try);
		
		
	}

}
