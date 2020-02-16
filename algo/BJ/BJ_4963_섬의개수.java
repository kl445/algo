package algo.hw0201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_4963_섬의개수 {

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	public static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
			{ 0, -1 } };

	public static boolean isIn(int r, int c, int[][] map) {
		return (r > -1 && c > -1 && r < map.length && c < map[0].length);
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int c = -1, r = -1;

		while (true) {
			c = sc.nextInt();
			r = sc.nextInt();

			int map[][] = new int[r][c];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			Queue<Pos> que = new LinkedList<>();
			int count=0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {

					if (map[i][j] == 1) {
						map[i][j]=0;
						que.offer(new Pos(i, j));

						while (!que.isEmpty()) {

							Pos temp = que.poll();
//							printMap(map);

							for (int d = 0; d < dirs.length; d++) {

								int nr = temp.r + dirs[d][0];
								int nc = temp.c + dirs[d][1];

								if (isIn(nr, nc, map) && map[nr][nc] == 1) {
									map[nr][nc]=0;
									que.offer(new Pos(nr, nc));
								}

							}
						}
						count++;
					}
					
				}
			}
			if(r==0 && c==0) {
				break;
			}
			
			System.out.println(count);

		}
	}

}
