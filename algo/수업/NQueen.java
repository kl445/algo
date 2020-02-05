package algo_day5;

import java.util.Arrays;

public class NQueen {

	public static boolean isIn(int r, int c, int n) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

	public static boolean queenOk(int[][] map, int r, int c) {

		return true;
	}

	// dfs nQueen

	public static boolean answer = false;

	public static void dfs_nQueen(int n) {
		int[][] map = new int[n][n];

		if (answer) {
			System.out.println("배치가능");
		} else {
			System.out.println("배치 불가능");
		}

		for (int r = 0; r < n; r++) {
//			for (int c = 0; c < n; c++) {
//				dfs(r, n, map);	//dfs
			dfs2(r, n, map); // 백트래킹
		}
//		}
	}

	public static void dfs(int row, int n, int[][] map) {
		if (row == n) {
			if (isPromising(map)) {
				for (int[] line : map) {
					System.out.println(Arrays.toString(line));
				}
				System.out.println("배치 가능하다.");
				System.exit(0);
			}
			System.out.println();
			return;
		} else {
			// 순차적으로 하나씩 비교

			for (int c = 0; c < n; c++) {
				map[row][c] = 1;
				dfs(row + 1, n, map);
				map[row][c] = 0;
			}
		}
	}

	// 백트래킹
	public static void dfs2(int row, int n, int[][] map) {
		if (row == n) {

			for (int[] line : map) {
				System.out.println(Arrays.toString(line));
			}
			System.out.println("배치 가능하다.");
			System.exit(0);

			System.out.println();
			return;
		} else {
			// 순차적으로 하나씩 비교

			for (int c = 0; c < n; c++) {
				map[row][c] = 1;
				if (isPromising2(map, row + 1)) {
					dfs2(row + 1, n, map);
				}
				map[row][c] = 0;
			}
		}
	}

	// 백트래킹
	public static boolean isPromising2(int map[][], int row, int col) {

		// 수직 위와 대각선으로 체크하기
		for (int k = 1; k <= row; k++) {
			if (map[row - k][col] == 1) {
				return false;
			}
			if (col - k >= 0 && map[row - k][col - k] == 1) {
				return false;
			}
			if (col + k < map.length && map[row - k][col + k] == 1) {
				return false;
			}
		}

		return true;
	}

	// 완탐
	public static boolean isPromising(int map[][]) {

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				if (map[r][c] == 1) {
					// 수직 위와 대각선으로 체크하기
					for (int k = 1; k <= r; k++) {
						if (map[r - k][c] == 1) {
							return false;
						}
						if (c - k >= 0 && map[r - k][c - k] == 1) {
							return false;
						}
						if (c + k < map.length && map[r - k][c + k] == 1) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs_nQueen(4);
	}

}
