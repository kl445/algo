package swea_0212;

import java.util.Scanner;

public class BJ_2567_색종이2 {

	public static void set(int[][] map, int r, int c) {

		for (int i = r; i < r + 10; i++) {

			for (int j = c; j < c + 10; j++) {
				map[i][j] = 1;
			}
		}

	}

	public static int sum(int[][] map) {
		int cnt = 0;
		int idx = 0;

		for (int i = 0; i < map.length; i++) {

			idx = 0;
			for (int j = 0; j < map.length; j++) {

				if (map[i][j] != idx) {
					cnt++;
					idx = map[i][j];
				}

			}
		}

		for (int i = 0; i < map.length; i++) {

			idx = 0;
			for (int j = 0; j < map.length; j++) {

				if (map[j][i] != idx) {
					cnt++;
					idx = map[j][i];
				}

			}
		}
		
		return cnt;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int map[][] = new int[101][101];

		int arra[][] = new int[tc][2];

		for (int i = 0; i < tc; i++) {
			arra[i][0] = sc.nextInt();
			arra[i][1] = sc.nextInt();

			set(map, arra[i][1], arra[i][0]);

		}
		
		int cnt=sum(map);
		
		System.out.println(cnt);
	}

}
