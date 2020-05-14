package algo.hw0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	static int R, C, wall = 0;
	static char[][] map;
	static ArrayList<Pos> list = new ArrayList<>();

	static Set<Integer> set = new HashSet<>();

	static int min = Integer.MAX_VALUE;

	static class Pos {
		int r;
		int c;
		int type;// 카메라타입
		int angle;// 카메라 각도 0:상 1:우 2:하 3:좌

		public Pos(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			this.angle=0;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", type=" + type + ", angle=" + angle + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(input.readLine());

			for (int j = 0; j < C; j++) {
				map[i][j] = tk.nextToken().charAt(0);

				if ('1' <= map[i][j] && '5' >= map[i][j]) {
					list.add(new Pos(i, j, map[i][j] - '0'));
				}
				else if ('6' == map[i][j]) {
					wall++;
				}
			}

		}


		
		dfs2(list.size(), 0, new int[list.size()]);

		if(list.size()==0) {
			System.out.println((R*C)-wall);
			
		} 
		else {
			System.out.println(min==Integer.MAX_VALUE?0:min);
		}
		

	}
	static void dfs2(int now,int cur, int[] temp) {

		if (now == cur) {

			getBlack(temp);
			return;
		}

		for (int i = 0; i < 4; i++) {

						temp[cur]=i;
						dfs2(now ,cur+1, temp);

			}
		

	}
	


	private static void getBlack(int[] temp) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).angle=temp[i];
		}
		set.clear();
		int black = Integer.MAX_VALUE;
		for (int i = 0; i < temp.length; i++) {
			Pos cam = list.get(i);

			switch (cam.type) {

			case 1:
				draw1(cam);
				break;
			case 2:
				draw2(cam);
				break;
			case 3:
				draw3(cam);
				break;
			case 4:
				draw4(cam);
				break;

			case 5:
				draw5(cam);
				break;
			}

			black = (R * C) - wall - set.size();
//			if (black > min) {
//				break;
//			}
		}
//		System.out.println(black);
		min = Math.min(min, black);

	}

	private static void draw5(Pos cam) {
		cam.angle = 0;
		draw2(cam);
		cam.angle = 1;
		draw2(cam);

	}

	private static void draw4(Pos cam) {
		switch (cam.angle) {
		// 상
		case 0:
			cam.angle = 0;
			draw1(cam);
			cam.angle = 1;
			draw2(cam);
			break;
		// 우
		case 1:
			cam.angle = 1;
			draw1(cam);
			cam.angle = 0;
			draw2(cam);

			break;
		// 하
		case 2:
			cam.angle = 2;
			draw1(cam);
			cam.angle = 1;
			draw2(cam);

			break;
		// 좌
		case 3:
			cam.angle = 3;
			draw1(cam);
			cam.angle = 0;
			draw2(cam);
			break;

		default:
			break;
		}

	}

	private static void draw3(Pos cam) {
		switch (cam.angle) {
		// 상
		case 0:
			cam.angle = 0;
			draw1(cam);
			cam.angle = 1;
			draw1(cam);
			break;
		// 우
		case 1:
			cam.angle = 1;
			draw1(cam);
			cam.angle = 2;
			draw1(cam);

			break;
		// 하
		case 2:
			cam.angle = 2;
			draw1(cam);
			cam.angle = 3;
			draw1(cam);

			break;
		// 좌
		case 3:
			cam.angle = 3;
			draw1(cam);
			cam.angle = 0;
			draw1(cam);
			break;

		default:
			break;
		}

	}

	private static void draw2(Pos cam) {
		switch (cam.angle) {
		// 상
		case 0:
		case 2:

			for (int r = cam.r, c = cam.c; r >= 0; r--) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			for (int r = cam.r, c = cam.c; r < R; r++) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;
		// 우
		case 1:
		case 3:

			for (int c = cam.c, r = cam.r; c < C; c++) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			for (int c = cam.c, r = cam.r; c >= 0; c--) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;

		default:
			break;
		}

	}

	private static void draw1(Pos cam) {

		switch (cam.angle) {
		// 상
		case 0:

			for (int r = cam.r, c = cam.c; r >= 0; r--) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;
		// 우
		case 1:

			for (int c = cam.c, r = cam.r; c < C; c++) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;
		// 하
		case 2:
			for (int r = cam.r, c = cam.c; r < R; r++) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;
		// 좌
		case 3:
			for (int c = cam.c, r = cam.r; c >= 0; c--) {
				if (map[r][c] == '6') {
					break;
				} else {
					set.add((r * 10 + c));
				}
			}
			break;

		default:
			break;
		}

	}

}
