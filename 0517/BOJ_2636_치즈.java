package algo.hw0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {

	

	static int R, C;
	static int map[][];
	static boolean visited[][];
	static int res = 0;
	static int time;
	static int cheese = 0;

	static Queue<Pos> side = new LinkedList<>();

	static class Pos {
		int r;
		int c;

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];

		time = 0;
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(input.readLine());

			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] == 1) {
					cheese++;
				}
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		int cnt = 0;

		time = 0;
		while (cheese > 0) {
			res = cheese;

			side.clear();
			visited = new boolean[R][C];
			bfs(new Pos(0, 0));

			time++;
		}

		if (cheese <= 0) {
			System.out.println(time);
			System.out.println(res);
		}

	}

	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	static boolean isIn(int r, int c) {
		return (-1 < r && -1 < c && r < R && c < C);
	}

	static void bfs(Pos start) {

		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {
			Pos temp = q.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = temp.r + dirs[d][0];
				int nc = temp.c + dirs[d][1];

				if (isIn(nr, nc) && !visited[nr][nc]) {
					if (map[nr][nc] == 0) {
						q.offer(new Pos(nr, nc));
						map[nr][nc] = 0;
						visited[nr][nc] = true;
					}
					if (map[nr][nc] == 1) {
						side.offer(new Pos(nr, nc));
						map[nr][nc] = 0;
						visited[nr][nc] = true;
					}

				}
			}

		}
		cheese -= side.size();
	}

}
