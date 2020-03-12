package algo.hw0309;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7793_D5오나의여신님 {

	static class Pos {
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}

		int r;
		int c;
		int depth;

		public Pos(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	static char map[][];
	static int n, m, min;

	static boolean isIn(int r, int c) {
		return (r > -1 && r < n && c > -1 && c < m);
	}

	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Pos S, D, Devil_s;
	static Queue<Pos> player, devil;

	// 현재 상태 큐에 있는 데빌까지 진행
	static void bfsDevil() {
		int size = devil.size();

		while (size-- > 0) {
			Pos temp = devil.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = temp.r + dirs[d][0];
				int nc = temp.c + dirs[d][1];
				if (isIn(nr, nc)) { // 범위에 있다면 악마는 . S 를 대상으로함
					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
						map[nr][nc] = '*';
						// 새로운 devil 추가
						devil.offer(new Pos(nr, nc, temp.depth + 1));
					}
				}
			}

		}
	}

	static int bfsPlayer() {
		int size = player.size();
		while (size-- > 0) {
			Pos temp = player.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nr = temp.r + dirs[d][0];
				int nc = temp.c + dirs[d][1];
				if (isIn(nr, nc)) { // 범위에 있다면 .은 이동 D는 종료
					if (map[nr][nc] == 'D') {
						return temp.depth + 1;
					}
					else if (map[nr][nc] == '.') {
						// 새로운 devil 추가
						map[nr][nc] = 'S';
						player.offer(new Pos(nr, nc, temp.depth + 1));
					}
				}
			}

		}
		return -1;

	}

	public static void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {

			n = sc.nextInt();
			m = sc.nextInt();
			map = new char[n][m];
			min = -1;
			devil = new LinkedList<>();
			player = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				String str = sc.next();
				map[i] = str.toCharArray();
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'S') {
						player.offer(new Pos(i, j, 0));
					} else if (map[i][j] == '*') {
						devil.offer(new Pos(i, j, 0));
					}

				}
			}

//			printMap(map);
//			System.out.println(player);
//			System.out.println(devil);

			// 끝나는 시점 : 모든 플레이어소멸 or 플레이어가 여신에 도달

			while (true) {

				// 1.만약 플레이어가 없다면-> gameover
				if (player.size() == 0) {
					break;
				}

				// 2.divil 1초 동작
				bfsDevil();
				// 3. player 1초동작
				int res = bfsPlayer();

				if (res != -1) {
					min = res;
					break;
				}

			}

			if (min ==-1) {
				System.out.println("#" + t + " GAME OVER");
			} else {
				System.out.printf("#%d %d\n", t, min);
			}
		}

	}

}
