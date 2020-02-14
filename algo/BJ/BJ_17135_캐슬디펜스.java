package swea_0213;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class BJ_17135_캐슬디펜스 {

	//게임플레이
	public static void doGame(int[][] originmap,int[] arrowLine,int d, int n) {
		
	int[][] map=makeSampleMap(originmap);
		
		for (int i = 0; i < arrowLine.length; i++) {
			map[n][arrowLine[i]]=2;
		}

		int now_down_enemy=0;
		while (allEnemyDown(map) != 0) {

//			printMap(map);
			int temp = allEnemyDown(map);
		//	System.out.println("shoot:");
			shoot(map, d);
			now_down_enemy += temp - allEnemyDown(map);

//			printMap(map);
			goEnemy(map, n);
		//	System.out.println("go");

		}
//		System.out.println(now_down_enemy);
		
		down_enemy=Math.max(down_enemy, now_down_enemy);
		
	}
	//궁수 배치 조합
	public static void combi(int originmap[][],int r, int c, int[]temp,int start,int m, boolean[] visited,int d,int n) {
		if(r==c) {
			
			doGame(originmap,temp,d, n);
			
			return;
		}
		else {
			
			for (int i = start; i <m ; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[c]=i;
					combi(originmap,r,c+1,temp,i+1,m,visited,d,n);
					visited[i]=false;
				}
			}
		}
		
	}
	
	
	
	static int down_enemy = 0;

	static class Enemy {
		int r;
		int c;
		int d;

		public Enemy(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	public static int[][] makeSampleMap(int[][] map) {
		int[][] sampleMap=new int [map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sampleMap[i][j]=map[i][j];
			}
		}
		return sampleMap;
		
	}
	//맵 그리기
	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	//적군 한칸 전진
	public static void goEnemy(int[][] map, int n) {
		int[][] temp_map = new int[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				temp_map[i][j] = map[i][j];
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (i != 0) {
				for (int j = 0; j < temp_map[0].length; j++) {

					map[i][j] = temp_map[i - 1][j];
				}
			} else {
				for (int j = 0; j < temp_map[0].length; j++) {

					map[i][j] = 0;
				}
			}
		}

	}

	//궁수 화살발사
	public static void shoot(int map[][], int d) {

		Stack<Enemy> st = new Stack<>();

		PriorityQueue<Enemy> pq = new PriorityQueue<>(new Comparator<Enemy>() {

			@Override
			public int compare(Enemy o1, Enemy o2) {

				Integer res1 = o1.d;
				Integer res2 = o2.d;

				if (res1 == res2) {
					res1 = o1.c;
					res2 = o2.c;
				}

				// TODO Auto-generated method stub
				return res1.compareTo(res2);
			}
		});

		int cnt = 3;
		for (int i = 0; i < map[0].length; i++) {
			int arrow_r = map.length - 1;
			if (map[arrow_r][i] == 2) {

				for (int j = 0; j < map.length - 1; j++) {
					for (int k = 0; k < map[0].length; k++) {
						if (map[j][k] == 1) {
							int d_range = (Math.abs(arrow_r - j) + Math.abs(i - k));
							if (d_range <= d) {
								pq.offer(new Enemy(j, k, d_range));
							}
						}
					}
				}
				if (!pq.isEmpty()) {
					st.push(pq.poll());
				}
				pq.clear();

			}
		}
		while (!st.isEmpty()) {
			Enemy temp = st.pop();
			map[temp.r][temp.c] = 0;
		}

	}

	//남은 적들
	public static int allEnemyDown(int[][] map) {

		int one = 0;

		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					one++;

				}
			}
		}
		return one;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int originmap[][] = new int[n + 1][m];

		int d = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				originmap[i][j] = sc.nextInt();
			}
		}
		
		combi(originmap, 3, 0, new int[3], 0, m, new boolean[m], d, n);

//		printMap(map);
		//
		
//		
//		int[][] map=makeSampleMap(originmap);
//		
//		map[n][3] = 2;
//		map[n][1] = 2;
//		map[n][4] = 2;
//		//
//
////		printMap(map);
////		shoot(map, d);
////		goEnemy(map, n);
////		
////		printMap(map);
//		int now_down_enemy=0;
//		while (allEnemyDown(map) != 0) {
//
//			printMap(map);
//			int temp = allEnemyDown(map);
//			System.out.println("shoot:");
//			shoot(map, d);
//			now_down_enemy += temp - allEnemyDown(map);
//
//			printMap(map);
//			goEnemy(map, n);
//			System.out.println("go");
//
//		}
//		down_enemy=Math.max(down_enemy, now_down_enemy);
//		
		
		System.out.println(down_enemy);

	}

}
