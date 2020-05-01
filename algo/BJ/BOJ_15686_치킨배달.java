package algo.hw0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int min;
	static ArrayList<Pos> home;
	static ArrayList<Pos> chicken;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk=new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(tk.nextToken());
		M=Integer.parseInt(tk.nextToken());
		map=new int[N][N];
		
		home=new ArrayList<>();
		chicken=new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			
			tk=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int token=Integer.parseInt(tk.nextToken());
				map[i][j]=token;
				if(token==1) {
					home.add(new Pos(i,j));
				}else if(token==2) {
					chicken.add(new Pos(i, j));
				}
				
			}
		}
		
		min=Integer.MAX_VALUE;
		combi(M, 0, new int[M], 0);
		
		System.out.println(min);
		
		
		
		
		
	}
	static void combi(int r,int c,int[] temp,int start) {
		
		if(r==c) {
			
			getRange(temp);
		}
		
		else {
			
			for (int i = start; i < chicken.size(); i++) {
				temp[c]=i;
				combi(r, c+1, temp, i+1);
			}
		}
	}
	
	static void getRange(int[] temp) {
		int[] tempRange=new int[home.size()];
		Arrays.fill(tempRange, Integer.MAX_VALUE);
		int totalRange=0;
		for (int i = 0; i < home.size(); i++) {
			for (int j = 0; j < temp.length; j++) {
				int now_r=Math.abs((home.get(i).r-chicken.get(temp[j]).r));
				int now_c=Math.abs((home.get(i).c-chicken.get(temp[j]).c));
				tempRange[i]=Math.min(tempRange[i],now_r+now_c);
			}
			totalRange+=tempRange[i];
			if(min<=totalRange) {
				return;
			}
		}
		min=Math.min(min, totalRange);
		
		
	}

}
