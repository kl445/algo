package algo.hw;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;

public class Solution32 {

	public static boolean isIn(int r, int c, int map_r, int map_c) {
		return (r >= 0 && c >= 0 && r < map_r && c < map_c);
	}

	public static int[] move(int r, int c, int[][] array) {
		int way = array[r][c] / 10;
//		System.out.println("way"+way);
		int run = array[r][c] % 10;
//	System.out.println("run"+run);
		int res[] = new int[2];

		switch (way) {
		case 1: {
			c = c + run;
			break;
		}
		case 2: {
			r = r + run;
			break;
		}
		case 3: {
			c = c - run;
			break;
		}
		case 4: {
			r = r - run;
			break;
		}

		}

		res[0] = r;
		res[1] = c;
		return res;
	}

	public static void showmap(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		} 
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\Solution32.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int map_r = sc.nextInt();
			int map_c = sc.nextInt();
			
			map_r++;
			map_c++;

			int[][] map = new int[map_r][map_c];

			int player_n = sc.nextInt();
			int player[][] = new int[player_n][3]; // x,y,점프

			for (int j = 1; j < map.length; j++) {
				for (int k = 1; k < map[0].length; k++) {
					map[j][k] = sc.nextInt();
				}
			}

			for (int j = 0; j < player_n; j++) {
				player[j][0] = (sc.nextInt());
				player[j][1] = (sc.nextInt());
				player[j][2] = sc.nextInt();

			}
			int spot_n = sc.nextInt();

			for (int j = 0; j < spot_n; j++) {
				int spot_r = (sc.nextInt());
				int spot_c = (sc.nextInt());
				map[spot_r][spot_c] = 0;
			}
//			showmap(map);

			int total_price = 0;

//			System.out.println(player_n + "사람");
			for (int j = 0; j < player_n; j++) {
//				System.out.println(j + 1 + "회");
				int start_r = player[j][0];
				int start_c = player[j][1];
//				System.out.println("R" + start_r + "c" + start_c + "J" + player[j][2]);
				total_price -= 1000;

				boolean flag = true;
				for (int k = 0; k < player[j][2]; k++) {
					if (isIn(move(start_r, start_c, map)[0], move(start_r, start_c, map)[1], map_r, map_c)) {
						int temp_r=move(start_r, start_c, map)[0];
						int temp_c=move(start_r, start_c, map)[1];
						start_r = temp_r;
						start_c = temp_c;
//						System.out.println("*2r:" + start_r + "c:" + start_c);

					} else {
//						System.out.println("out");
						flag = false;
					}

					if (map[start_r][start_c] == 0) {
//						System.out.println("spot");
						flag = false;
					}
				}

//				System.out.println(flag);
				if (flag == true) {
					total_price += map[start_r][start_c] * 100;
//					System.out.println(map[start_r][start_c] * 100 + "*" + j + "회");
				} else {
//					System.out.println(-1000 + "*" + j + "회");

				}

			}
			System.out.printf("#%d %d\n", i, total_price);

		}

	}

}
