package algo_ad.day2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9663_NQueen {

	static class Pos{
		public Pos(int r, int y) {
			this.r = r;
			this.y = y;
		}
		int r;
		int y;
	}
	private static int cnt=0;
	
	public static boolean okQueen(int[] map,int r,int c) {
		
		if(r==0) {
			return true;
		}
		
		for (int i = 0; i < r; i++) {
			if(c==map[i]) {
				return false;
			}
			if(Math.abs(r-i)==Math.abs(c-map[i])) {
				return false;
			}
		}
		return true;
		
	}
	public static void nQueen(int[] map,int r,int c,int n) {
		
		if(r==n-1) {
			cnt++;
			return;
		}
		for (int i = 0; i < map.length; i++) {
			
			if(okQueen(map, r+1, i)) {
				map[r+1]=i;
				nQueen(map, r+1, i,n);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int map[]=new int[n];
		
		
		nQueen(map, -1, 0,n);
		
		System.out.println(cnt);
		

	}

}
