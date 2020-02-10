package swea_0210;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873_D3_상호의배틀필드 {

	private static int now_r=0, now_c=0;
	
	public static void printmap(char map[][]) {
		for (int j = 0; j < map.length; j++) {
			for (int j2 = 0; j2 < map[0].length; j2++) {
				System.out.print(map[j][j2]);
			}
			System.out.println();
		}
	}
	public static boolean isIn(int temp_r, int temp_c, int r, int c) {
		return (temp_c > -1 && temp_r > -1 && temp_r < r && temp_c < c);
	}

	public static void moveU(char[][] map, int r, int c) {
		map[r][c] = '^';

		if (isIn(r - 1, c, map.length, map[0].length)&&map[r -1][c]=='.') {
			map[r][c] = '.';
			map[r - 1][c] = '^';
			now_r=r-1;
			now_c=c;
		}

	}

	public static void moveD(char[][] map, int r, int c) {
		map[r][c] = 'v';
		if (isIn(r + 1, c, map.length, map[0].length)&&map[r + 1][c]=='.') {
			map[r][c] = '.';
			map[r + 1][c] = 'v';
			now_r=r+1;
			now_c=c;
		}
	}

	public static void moveL(char[][] map, int r, int c) {
		map[r][c] = '<';

		if (isIn(r, c-1, map.length, map[0].length)&&map[r][c-1]=='.') {
			map[r][c] = '.';
			map[r][c-1] = '<';
			now_r=r;
			now_c=c-1;
		}

	}

	public static void moveR(char[][] map, int r, int c) {
		map[r][c] = '>';

		if (isIn(r, c+1, map.length, map[0].length)&&map[r][c+1]=='.') {
			map[r][c] = '.';
			map[r][c+1] = '>';
			now_r=r;
			now_c=c+1;
		}

	}

	public static void shoot(char[][] map, int r_tem, int c_tem) {
		int r = 0;
		int c = 0;
		int type = 0;
		int j=r_tem;
		int j2=c_tem;
		
		
				if (map[j][j2] == '^') {
					r = j;
					c = j2;
					type = 1;
				} else if (map[j][j2] == 'v') {
					r = j;
					c = j2;
					type = 2;
				}
				else if (map[j][j2] == '>') {
					r = j;
					c = j2;
					type = 3;
				}
				else if (map[j][j2] == '<') {
					r = j;
					c = j2;
					type = 4;
				}
				else {
					type=0;
				}
		

		switch (type) {

		case 1:
			while (true) {
				if (isIn(r - 1, c, map.length, map[0].length)) {
					r = r - 1;

					if (map[r][c] == '*') {
						map[r][c] = '.';
						break;
					} else if (map[r][c] == '#') {
						break;
					}
				}
				else {
					break;
				}
			}
			break;

		case 2:
			while (true) {
				if (isIn(r + 1, c, map.length, map[0].length)) {
					r = r + 1;

					if (map[r][c] == '*') {
						map[r][c] = '.';
						break;
					} else if (map[r][c] == '#') {
						break;
					}
				}
				else {
					break;
				}
			}
			break;
		case 3:
			while (true) {
				if (isIn(r, c + 1, map.length, map[0].length)) {
					c = c + 1;

					if (map[r][c] == '*') {
						map[r][c] = '.';
						break;
					} else if (map[r][c] == '#') {
						break;
					}
				}
				else {
					break;
				}
			}
			break;
		case 4:
			while (true) {
				if (isIn(r, c - 1, map.length, map[0].length)) {
					c = c - 1;

					if (map[r][c] == '*') {
						map[r][c] = '.';
						break;
					} else if (map[r][c] == '#') {
						break;
					}
				}
				else {
					break;
				}
			}
			break;
			
		default:
			
			break;

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			now_r=0;
			now_c=0;
			char[][] map = new char[r][c];
			
			for (int j = 0; j < map.length; j++) {
				String str = sc.next();
				for (int k = 0; k < map[0].length; k++) {
					map[j][k] = str.charAt(k);
					if(		map[j][k]=='<' ||
							map[j][k]=='>' ||
							map[j][k]=='v' ||
							map[j][k]=='^' ) {
						now_r=j;
						now_c=k;
					}
				}
			}

//			System.out.println();
//			printmap(map);

			int n = sc.nextInt(); // 명령어수
			char[] order = sc.next().toCharArray();

//			System.out.println(Arrays.toString(order));

			int lll=0;
			for (int j = 0; j < n; j++) {
				switch (order[j]) {

				case 'S':
//					System.out.println("S");
					shoot(map, now_r, now_c);
					break;

				case 'U':
//					System.out.println("U");
					moveU(map, now_r, now_c);
					break;
				case 'D':
//					System.out.println("D");
					moveD(map, now_r, now_c);
					break;

				case 'L':
//					System.out.println("L");
					moveL(map, now_r, now_c);
					break;
				case 'R':
//					System.out.println("R");
					moveR(map,now_r,now_c);
					break;

				default:
					break;

				}
				
//				System.out.println(order[j]+" "+lll);
//				lll++;
//				System.out.println();
//				printmap(map);
			}
			
			System.out.print("#"+i+" ");
			printmap(map);
			
			
		}

	}
}
