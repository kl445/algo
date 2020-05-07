package algo.hw0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {

	static boolean visited[][];
	static int memo[][];
	static int N, island, min;
	static int map[][];
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static class Pos {
		int r, c, range;

		public Pos(int r, int c, int range) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", range=" + range + "]";
		}

	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());

		map = new int[N][N];
//		memo = new int[N][N];
		visited=new boolean[N][N];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
//			Arrays.fill(memo[i], 201);
			for (int j = 0; j < N; j++) {

				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		island = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					setIsland(i, j,island++);
				}
			}
		}

		min = Integer.MAX_VALUE;
		for (int j = 2; j < island; j++) {
			go(j);
		}

		System.out.println(min);
	}

	private static void go(int num) {

		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (map[i][j] == num) {
					que.offer(new Pos(i, j, 0));
					visited2[i][j] = true;
				}
			}
		}
		int res = 0;

		while (!que.isEmpty()) {

			int nowsize = que.size();
			for (int i = 0; i < nowsize; i++) {

				Pos temp = que.poll();
				for (int d = 0; d < dirs.length; d++) {
					int nr = temp.r + dirs[d][0];
					int nc = temp.c + dirs[d][1];

					if (isIn(nr, nc) && map[nr][nc] != num && !visited2[nr][nc]) {

						if (map[nr][nc] != 0) {
							min = Math.min(min, res);
							return;

						} else {
							que.offer(new Pos(nr, nc, temp.range + 1));
							visited2[nr][nc] = true;
						}

					}
				}
			}
			res++;
		}

	}

	private static void setIsland(int r, int c,int cnt) {

		visited[r][c] = true;

		map[r][c] = cnt; // 몇번 섬인지 표시

		for (int i = 0; i < 4; i++)

		{
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if (0 <= nr && nr < N && 0 <= nc && nc < N)
				if (map[nr][nc]==1 && !visited[nr][nc])
					setIsland(nr, nc, cnt);
		}

	}

	static boolean isIn(int r, int c) {
		return (r < N && c < N && r > -1 && c > -1);
	}

}
