package algo.hw0310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_5656_모의_벽돌깨기 {

	static int N, R, C, all;
	static int[][] map;
	static int min;

	public static boolean isIn(int r, int c) {

		return (r > -1 && r < R && c > -1 && c < C);
	}

	public static void bomb(int r, int c, int[][] sample_map) {
		if (isIn(r, c)) {
			if (sample_map[r][c] == 0) {
				return;
			} else {
				int range = sample_map[r][c] - 1;
				sample_map[r][c] = 0;
				for (int i = r - range; i <r; i++) {
					bomb(i, c, sample_map);
				}
				for (int i = r + range; i > r ; i--) {
					bomb(i, c, sample_map);
				}
				for (int i = c - range; i < c; i++) {
					bomb(r, i, sample_map);
				}
				for (int i = c + range; i >c ; i--) {
					bomb(r, i, sample_map);
				}
			}
		}

	}
	public static int sort(int[][] sample_map) {
		int cnt=0;
		for (int j = 0; j < sample_map[0].length; j++) {
			Stack<Integer> st= new Stack();
			for (int i = 0; i < sample_map.length; i++) {
				if(sample_map[i][j]!=0) {
					cnt++;
					st.push(sample_map[i][j]);
				}
			}
			
			for (int i = sample_map.length-1; i>=0 ; i--) {
				if(!st.isEmpty()) {
				sample_map[i][j]=st.pop();
				}
				else {
					sample_map[i][j]=0;
				}
				
			}
		}
		return cnt;
	}
	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[][] copyMap(){
		int[][] copy=new int[R][C];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				copy[i][j]=map[i][j];
			}
		}
		return copy;
	}
	public static void game(int[] temp) {
		int[][] sample_map=copyMap();
//		int[][] sample_map=map.clone();
		int cnt=-1;
		for (int i = 0; i < temp.length; i++) {
			if(sample_map[map.length-1][temp[i]]==0) {
				return;
			}else {
				int idx=0;
				while(sample_map[idx][temp[i]]==0) {
					idx++;
				}
				bomb(idx, temp[i], sample_map);
				cnt=sort(sample_map);
				if(cnt==0) {
					break;
					
				}
			}
		}
//		printMap(sample_map);
		min=Math.min(min,cnt);
	}

	public static void perm(int c, int[] temp,boolean[] visited) {
		
		
		if(N==c) {
			all++;
			game(temp);
			
		}else {
			for (int i = 0; i < C; i++) {
				if(!visited[i]) {
					temp[c]=i;
					perm(c+1, temp, visited);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			N = sc.nextInt();
			C = sc.nextInt();
			R = sc.nextInt();
			min=Integer.MAX_VALUE;
			
			map = new int[R][C];
			                 
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();

				}
			}
//			printMap(map);

//			bomb(2, 2, map);
//			System.out.println(sort(map));
//			bomb(8, 6, map);
//			System.out.println(sort(map));
//			
			perm(0, new int[N], new boolean[C]);
//			printMap(map);
			
//			System.out.println(all);
			System.out.printf("#%d %d\n",t,min);
		}
	}

}
