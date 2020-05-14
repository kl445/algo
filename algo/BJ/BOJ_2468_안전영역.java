package algo.hw0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int N,max;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visited;

	static class Pos {
		int r;
		int c;
		int tall;

		public Pos(int r, int c, int tall) {
			super();
			this.r = r;
			this.c = c;
			this.tall = tall;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", tall=" + tall + "]";
		}

	}

	static int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		max=0;
		
		StringTokenizer tk = null;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(input.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}

//			System.out.println(Arrays.toString(map[i]));
		}

		
		for (int rain = 0; rain < 100; rain++) {
			visited=new boolean[N][N];
			cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && rain < map[i][j]) {

						dfs(i, j, rain, 0);

					}
				}
			}
			if(cnt==0) {
				break;
			}
		
		max=Math.max(max, cnt);
		}
		System.out.println(max);
		
	}

	static boolean isIn(int r, int c) {
		return (r < N && c < N && -1 < r && -1 < c);
	}

	public static void dfs(int r, int c, int rain, int dept) {

		for (int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];

			if (isIn(nr, nc) && !visited[nr][nc] && rain < map[nr][nc]) {
//				map[nr][nc] = 0;
				visited[nr][nc] = true;
				dfs(nr, nc, rain, dept + 1);
			}
		}

		if (dept == 0) {
			cnt++;
		}
	}

}
