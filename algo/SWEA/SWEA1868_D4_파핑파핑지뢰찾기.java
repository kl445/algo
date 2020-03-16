package algo.hw0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1868_D4_파핑파핑지뢰찾기 {

	static class Pos{
		int r;
		int c;
		char boomb;
		public Pos(int r, int c,char boomb) {
			this.r = r;
			this.c = c;
			this.boomb = boomb;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", boomb=" + boomb + "]";
		}
		
	}
	static int N, max,min;
	static char map[][];
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	static PriorityQueue<Pos> q;
//	static Queue<Pos> q;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
//			printMap(map);
			q=new PriorityQueue<>(new Comparator<Pos>() {

				@Override
				public int compare(Pos o1, Pos o2) {
					// TODO Auto-generated method stub
					Character res1=o1.boomb;
					Character res2=o2.boomb;
					return res1.compareTo(res2);
				}
			});
//			q=new LinkedList<>() ;

			
			char[][] temp_map=temp_map();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						select(i, j, temp_map);
					}
				}
			}
			
//			System.out.println("22");
//			printMap(temp_map);
//			System.out.println("33");
			
			max=Integer.MAX_VALUE;
			min=0;

			
			while(!q.isEmpty()) {
//				int[] now=getCount(temp_map);
				
//				System.out.println(now[0]+" "+now[1]+ " "+min);
//				if(now[0]==0) {
//					min+=now[1];
//					break;
//				}

				Pos temp=q.poll();
				makeBomb(temp.r, temp.c, temp_map, 0);
				
//				printMap(temp_map);
				
			}
			sb.append(min);
			System.out.println(sb.toString());
				
			

		}
	}
	
	static int[] getCount(char[][] temp_map) {
		int[] cnt=new int[2];
		for (int i = 0; i < temp_map.length; i++) {
			for (int j = 0; j < temp_map.length; j++) {
				if(temp_map[i][j]=='*') {
					
				}else {
					if(temp_map[i][j]=='0') {
						cnt[0]++;
					}else {
						cnt[1]++;
					}
				}
			}
		}
		return cnt;
	}
	static void makeBomb(int r, int c, char[][] temp_map,int num) {
		if(temp_map[r][c]=='*') {
			return;
		}
		if (temp_map[r][c] == '0') {
			temp_map[r][c]='*';
			
			for (int d = 0; d < dirs.length; d++) {
				int nr = r+dirs[d][0];
				int nc = c+dirs[d][1];
				if (isIn(nr, nc)) {
					makeBomb(nr, nc, temp_map,num+1);
				}
			}

			
		}else {
			temp_map[r][c]='*';
		}
		if(num==0) {
			min++;
		}

	}
	static int nearBomb(int r, int c, char[][] temp_map) {
		int cnt = 0;

		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];

			if (isIn(nr, nc)) {
				if (temp_map[nr][nc] == '*') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void select(int r, int c, char[][] temp_map) {

		if (temp_map[r][c] == '.') {
			int current = nearBomb(r, c, temp_map);

			temp_map[r][c] = (char) (current + '0');
				q.add(new Pos(r,c,temp_map[r][c]));
			if (current == 0) {
				
				for (int d = 0; d < dirs.length; d++) {
					int nr = dirs[d][0];
					int nc = dirs[d][1];

					if (isIn(nr, nc)) {
						select(nr, nc, temp_map);
					}
				}

			}
		}

	}

	static void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean isIn(int r, int c) {
		return (r > -1 && c > -1 && r < N && c < N);
	}

	static char[][] temp_map() {
		char[][] temp_map = new char[N][N];

		for (int i = 0; i < temp_map.length; i++) {
			temp_map[i] = map[i].clone();
		}
		return temp_map;
	}

}
