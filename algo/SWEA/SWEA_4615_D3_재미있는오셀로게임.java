package algo.hw0201;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_4615_D3_재미있는오셀로게임 {

	public static void setColor(int[][] map, int color, int r, int c, int type[]) {
		Stack<Integer> st = new Stack<>();
		int way = 0;
		boolean flag1 = false;
		boolean flag2 = false;

		for (int i = 1; i < type.length; i++) {
			if (type[i] != 0) {
				switch (i) {

				case 1:
					flag1 = false;
					flag2 = false;
					// row 검사 ->1
					for (int j = c - 1; j > 0; j--) {

						if (map[r][j] != 0 && map[r][j] != color) {
							map[r][j] = color;
						}

						else if (map[r][j] == color) {
							break;
						}
					}

					break;

				case 2:
					flag1 = false;
					flag2 = false;

					// row 검사2 ->2
					for (int j = c + 1; j < map.length; j++) {

						if (map[r][j] != 0 && map[r][j] != color) {
							map[r][j] = color;
						}

						else if (map[r][j] == color) {
							break;
						}
					}
					break;

				case 3:
					flag1 = false;
					flag2 = false;

					// col 검사 ->3
					for (int j = r - 1; j > 0; j--) {

						if (map[j][c] != 0 && map[j][c] != color) {
							map[j][c] = color;
						} else if (map[j][c] == color) {
							break;
						}
					}

					break;

				case 4:
					flag1 = false;
					flag2 = false;

					// col 검사2 ->4
					for (int j = r + 1; j < map.length; j++) {

						if (map[j][c] != 0 && map[j][c] != color) {
							map[j][c] = color;
						}

						else if (map[j][c] == color) {
							break;
						}

					}
					break;

				case 5:

					// 오른대각 검사 ->5
					way = -1;
					for (int j = r + way, k = c + way; j > 0 && k > 0; j += way, k += way) {

						if (map[j][k] != 0 && map[j][k] != color) {
							map[j][k] = color;
						} else if (map[j][k] == color) {
							break;
						}

					}

					break;

				case 6:

					// 오른 대각 검사2 ->6
					way = 1;
					for (int j = r + way, k = c + way; j < map.length && k < map.length; j += way, k += way) {

						if (map[j][k] != 0 && map[j][k] != color) {
							map[j][k] = color;
						} else if (map[j][k] == color) {
							break;
						}

					}

					break;

				case 7:

					way = -1;
					for (int j = r + way, k = c - way; j > 0 && k < map.length; j += way, k -= way) {

						if (map[j][k] != 0 && map[j][k] != color) {
							map[j][k] = color;
						} else if (map[j][k] == color) {
							break;
						}
					}

					break;

				case 8:

					way = 1;
					for (int j = r + way, k = c - way; j < map.length && k > 0; j += way, k -= way) {

						if (map[j][k] != 0 && map[j][k] != color) {
							map[j][k] = color;
						} else if (map[j][k] == color) {
							break;
						}
					}

					break;

				default:
					break;

				}
			}
		}

	}

	public static int[] isOk(int r, int c, int color, int[][] map) {

		int[] type = new int[9];

		boolean flag1 = false;
		boolean flag2 = false;
		// row 검사 ->1
		for (int j = c - 1; j > 0; j--) {

			if (flag1) {
				if (map[r][j] != 0 && map[r][j] != color) {
					flag2 = true;
				} else if (map[r][j] == color) {
					type[1]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[r][j] != 0 && map[r][j] != color) {
				flag1 = true;
			}
		}

		flag1 = false;
		flag2 = false;

		// row 검사2 ->2
		for (int j = c + 1; j < map.length; j++) {

			if (flag1) {
				if (map[r][j] != 0 && map[r][j] != color) {
					flag2 = true;
				} else if (map[r][j] == color) {
					type[2]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[r][j] != 0 && map[r][j] != color) {
				flag1 = true;
			}
		}

		flag1 = false;
		flag2 = false;

		// col 검사 ->3
		for (int j = r - 1; j > 0; j--) {

			if (flag1) {
				if (map[j][c] != 0 && map[j][c] != color) {
					flag2 = true;
				} else if (map[j][c] == color) {
					type[3]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][c] != 0 && map[j][c] != color) {
				flag1 = true;
			}
		}

		flag1 = false;
		flag2 = false;

		// col 검사2 ->4
		for (int j = r + 1; j < map.length; j++) {

			if (flag1) {
				if (map[j][c] != 0 && map[j][c] != color) {
					flag2 = true;
				} else if (map[j][c] == color) {
					type[4]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][c] != 0 && map[j][c] != color) {
				flag1 = true;
			}
		}

		flag1 = false;
		flag2 = false;

		// 오른대각 검사 ->5
		int way = -1;
		for (int j = r + way, k = c + way; j > 0 && k > 0; j += way, k += way) {

			if (flag1) {
				if (map[j][k] != 0 && map[j][k] != color) {
					flag2 = true;
				} else if (map[j][k] == color) {
					type[5]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][k] != 0 && map[j][k] != color) {
				flag1 = true;
			}

		}
		flag1 = false;
		flag2 = false;

		// 오른 대각 검사2 ->6
		way = 1;
		for (int j = r + way, k = c + way; j < map.length && k < map.length; j += way, k += way) {

			if (flag1) {
				if (map[j][k] != 0 && map[j][k] != color) {
					flag2 = true;
				} else if (map[j][k] == color) {
					type[6]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][k] != 0 && map[j][k] != color) {
				flag1 = true;
			}

		}
		flag1 = false;
		flag2 = false;

		// 왼대각 검사 ->7
		way = -1;
		for (int j = r + way, k = c - way; j > 0 && k < map.length; j += way, k -= way) {

			if (flag1) {
				if (map[j][k] != 0 && map[j][k] != color) {
					flag2 = true;
				} else if (map[j][k] == color) {
					type[7]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][k] != 0 && map[j][k] != color) {
				flag1 = true;
			}

		}
		flag1 = false;
		flag2 = false;

		// 왼 대각 검사2 ->8
		way = 1;
		for (int j = r + way, k = c - way; j < map.length && k > 0; j += way, k -= way) {

			if (flag1) {
				if (map[j][k] != 0 && map[j][k] != color) {
					flag2 = true;
				} else if (map[j][k] == color) {
					type[8]++;
					break;
				} else {
					flag2 = false;
					flag1 = false;
					break;
				}
			}
			if (map[j][k] != 0 && map[j][k] != color) {
				flag1 = true;
			}

		}
		flag1 = false;
		flag2 = false;

		return type;
	}

	public static boolean isFull(int r, int c, int[][] map) {

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void playG(int r, int c, int color, int[][] map, int type[]) {

		// 놓을 수 있다.
		map[r][c] = color;

		setColor(map, color, r, c, type);

	}

	public static int[] number(int[][] map) {
		int cnt[] = new int[3];

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				cnt[map[i][j]]++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			n++;

			int map[][] = new int[n][n];

			map[n / 2][n / 2 + 1] = 1;
			map[n / 2][n / 2] = 2;
			map[n / 2 + 1][n / 2] = 1;
			map[n / 2 + 1][n / 2 + 1] = 2;

			for (int j = 0; j < m; j++) {
				int new_c = sc.nextInt();
				int new_r = sc.nextInt();
				int new_color = sc.nextInt();

				if (!isFull(new_r, new_c, map)) {
					int type[] = isOk(new_r, new_c, new_color, map);
					int typetest = 0;

					for (int k = 0; k < type.length; k++) {
						typetest += type[k];
					}

					if ((typetest != 0)) {
						playG(new_r, new_c, new_color, map, type);
					}
				} else {
					break;
				}

			}
			int ans[] = new int[3];
			ans = number(map);

			System.out.printf("#%d %d %d\n", i, ans[1], ans[2]);
		}
	}

}
