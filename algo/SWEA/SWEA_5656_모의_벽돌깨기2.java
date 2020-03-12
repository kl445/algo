package algo.hw0310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_5656_모의_벽돌깨기2 {

	static int N, R, C, all;
	static int[][] map;
	static int min;
	static int bricCnt;

	static int[][] dirs= {{-1,0},{1,0},{0,-1},{0,1}};
	static class Brick{
		int row, col, pow;

		public Brick(int row, int col, int pow) {
			this.row = row;
			this.col = col;
			this.pow = pow;
		}

		@Override
		public String toString() {
			return "Brick [row=" + row + ", col=" + col + ", pow=" + pow + "]";
		}
		
	}
	public static boolean isIn(int r, int c) {

		return (r > -1 && r < R && c > -1 && c < C);
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
	
	public static int[][] copyMap(int[][] map){
		int[][] copy=new int[R][C];
		for (int i = 0; i < map.length; i++) {
			copy[i]=map[i].clone();
		}
		return copy;
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
			bricCnt=0;
			map = new int[R][C];
			                 
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]!=0) {
						bricCnt++;
					}

				}
			}
			min=bricCnt;
					
			dropMarble(N,bricCnt, map,new int[N]);
			
			
			
//			perm(0, new int[N], new boolean[C]);
			System.out.printf("#%d %d\n",t,min);
		}
	}

	private static void dropMarble(int r, int bricCnt, int[][] map, int temp[]) {
		// TODO Auto-generated method stub
		if(r==0) {
			min=Math.min(min, bricCnt);
			return;
		}
		for (int c = 0; c <C; c++) {
			//1. map 복제
			int[][] cloned= copyMap(map);
			
			//2. 해당 컬럼의 맨 처음 벽돌 가져오기
			Brick first= getFirstBrick(c,cloned);
			//2-1 nill --> continue
			if(first==null) {
				continue;
			}
			
			//3. 구슬을 떨어뜨려 벽돌깨기 --> 깨진 벽돌 개수?
			int broken=crash(first,cloned);
			//3-1. 이미 벽돌이 다 깨졌다면? -> 종료 , 정답 0
			if(broken>=bricCnt) {
				min=0;
				return;
				
			}
			
			//4. 화면정리
			cleanMap(cloned);
			
			//5. 다음 샷
			dropMarble(r-1, bricCnt-broken, cloned, temp);
			
		}
	}

	private static void cleanMap(int[][] map) {
		// TODO Auto-generated method stub
		for(int c=0; c<C;c++) {
			for (int r = R-1,nr=R-1; r>0; r--) {
				if(map[r][c]!=0) {
					int temp=map[r][c];
					map[r][c]=0;
					map[nr--][c]=temp;
				}
			}
		}
		
	}

	private static int crash(Brick first, int[][] map) {
		
		int broken=0;
		//맞은 벽돌 삭제
		map[first.row][first.col]=0;
		broken++;
		
		//주변벽돌 영향
		for (int p = 1; p < first.pow; p++) {
			//사방탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr= first.row+dirs[d][0]*p;
				int nc= first.col+dirs[d][1]*p;
				
				if(isIn(nr, nc) && map[nr][nc]!=0) {
					broken += crash(new Brick(nr, nc, map[nr][nc]), map);
				}
			}
		}
		return broken;
	}

	private static Brick getFirstBrick(int c, int[][] map) {
		for (int r = 0; r < R; r++) {
			if(map[r][c]!=0) {
				return new Brick(r,c,map[r][c]);
			}
			
		}
		// TODO Auto-generated method stub
		return null;
	}

}
