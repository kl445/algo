package algo.hw0227;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_2115_모의_벌꿀채취 {

	
	static class Honey{
		int c_start,c_end, r, sum;

		@Override
		public String toString() {
			return "c_start=" + c_start + ", c_end=" + c_end + ", r=" + r + ", sum=" + sum + "]";
		}

		public Honey(int r, int c_start,int c_end,  int sum) {
			this.c_start = c_start;
			this.c_end = c_end;
			this.r = r;
			this.sum = sum;
		}
		
	}
	public static int subMax=0;
	public static void sumSet(int r,int current,int[] array, boolean[] check, boolean[] visited,int c) {
		
		if(r==current) {
			int num=0;
			int sum=0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					num+=array[i];
					if(num>c) {
						break;
					}else {
						sum+=array[i]*array[i];
					}
				}
			}
			subMax=Math.max(subMax, sum);
			
		}
		else {
			for (int i = 0; i < check.length; i++) {
				visited[current]=check[i];
				sumSet(r, 1+current, array, check, visited,c);
			}
			
		}
	}
	public static void sumFun(int[][] map,int row,int col,int m,int c) {
		int array[]=new int[m];
		
		for (int i = 0; i < array.length; i++) {
			array[i]=map[row][i+col];
		}
		
		boolean[] check= {true,false};
		subMax=0;
		sumSet(m, 0, array, check, new boolean[m],c);
		
	}
	private static int totalMax=0;
	public static void combi(int start,int now,int current,int[] temp,LinkedList<Honey> list) {
		if(now==current) {
			Honey honey1=list.get(temp[0]);
			Honey honey2=list.get(temp[1]);
			if(honey1.r==honey2.r) {
				if(honey1.c_start<=honey2.c_start && honey1.c_end>=honey2.c_start) {
					return;
				}
			}
			int total=honey1.sum+honey2.sum;
//				Math.max(totalMax, total);
				if(totalMax<total) {
					totalMax=total;
				}
				
		}else {
			for (int i = start; i < list.size(); i++) {
				temp[current]=i;
				combi(i+1, now, 1+current, temp, list);
			}
		}
		
	}
	
	public static boolean isIn(int n,int r) {
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int c=sc.nextInt();
			
			int map[][]=new int[n][n];
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
			LinkedList<Honey> list=new LinkedList<>();
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					
					if(k+m<=n) {
						sumFun(map, j, k, m,c);
						list.add(new Honey(j, k, k+m-1, subMax));
					}
				}
			}
			
			//조합
			totalMax=0;
			combi(0, 2, 0, new int[2], list);
			
			
			System.out.printf("#%d %d\n",i,totalMax);
		}
	}

}
