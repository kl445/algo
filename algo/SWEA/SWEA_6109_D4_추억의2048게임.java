package algo.hw0429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_6109_D4_추억의2048게임 {

	static int N;
	static int[][] map;
	static String[] ways = { "up", "down", "right", "left" };

	static ArrayList<Queue<Integer>> qlist;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t + 1);

			N = sc.nextInt();

			map = new int[N][N];
			qlist = new ArrayList<Queue<Integer>>();

			String way = sc.next();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			switch (way) {
			case "up":
				up();
				break;
				
			case "down":
				down();
				break;
				
			case "left":
				left();
				break;
				
			case "right":
				right();
				break;
			default:
				break;
			}
			
			System.out.println(sb.toString());
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}

	}
	

	static void swap(int i, int j, int ni, int nj) {
		int temp = map[i][j];
		map[i][j] = map[ni][nj];
		map[ni][nj] = temp;
	}

	static Queue<Integer> sum(Queue<Integer> que) {
		Queue<Integer> temp = new LinkedList<>();

		while (!que.isEmpty()) {
			Integer num = que.poll();
			if (num.equals(que.peek())) {
				num *= 2;
				que.poll();
			}
			temp.offer(num);
		}
		return temp;
	}

	static void left() {

		for (int i = 0; i < map.length; i++) {
			Queue<Integer> que = new LinkedList<Integer>();
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					que.add(map[i][j]);
				}
			}
			que = sum(que);
			for (int j = 0; j < map.length; j++) {
				if (!que.isEmpty()) {
					map[i][j] = que.poll();
				} else {
					map[i][j] = 0;
				}
			}

		}
	}
	
	static void right() {
		
		for (int i = 0; i < map.length; i++) {
			Queue<Integer> que = new LinkedList<Integer>();
			for (int j = map.length-1; j >-1; j--) {
				if (map[i][j] != 0) {
					que.add(map[i][j]);
				}
			}
			que = sum(que);
			for (int j = map.length-1; j >-1; j--) {
				if (!que.isEmpty()) {
					map[i][j] = que.poll();
				} else {
					map[i][j] = 0;
				}
			}
			
		}
	}

	static void up() {

		for (int i = 0; i < map.length; i++) {
			Queue<Integer> que = new LinkedList<Integer>();
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] != 0) {
					que.add(map[j][i]);
				}
			}
			que = sum(que);
			for (int j = 0; j < map.length; j++) {
				if (!que.isEmpty()) {
					map[j][i] = que.poll();
				} else {
					map[j][i] = 0;
				}
			}

		}
	}
	static void down() {

		for (int i = map.length-1; i >-1; i--) {
			Queue<Integer> que = new LinkedList<Integer>();
			for (int j = map.length-1; j >-1; j--) {
				if (map[j][i] != 0) {
					que.add(map[j][i]);
				}
			}
			que = sum(que);
			for (int j = map.length-1; j >-1; j--) {
				if (!que.isEmpty()) {
					map[j][i] = que.poll();
				} else {
					map[j][i] = 0;
				}
			}

		}
	}

}
