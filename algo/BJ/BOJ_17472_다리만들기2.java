package algo.hw0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

	static int R, C;
	static int[][] map, graph;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int islandIdx; // 섬의 번호
	static int INF = 987654321;// 최대값

	static class Vertex implements Comparable<Vertex>{
		int idx, cost;

		public Vertex(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Vertex [idx=" + idx + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());

		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
//		printMap();

		islandIdx = 2;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 땅을 발견하면 거기를 기반으로 BFS탐색 -> 연결된 지점들을 표시
				if (map[r][c] == 1) {
					bfs(r, c); // 한번의 BFS -> 섬하나 발견
					islandIdx++;// 섬 번호 증가
				}
			}
		}
//		printMap(map);

		// 그래프 초기화 하기
		graph = new int[islandIdx][islandIdx];
		// 각 섬간의 최단거리로 그래프 구성하기 - 그래프의 값을 최대값으로 초기화

		for (int i = 2; i < graph.length; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		//각 섬별로 거리(간선 가중치) 찾아보기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]>1) {
					makeGrph(r,c);
				}
			}
		}
//		printMap(graph);
		
		//mst 출력
		System.out.println(prim());

	}
	
	static int prim() {
		//모든 vertex가 처음에 여기 들어있다가 탈출한다.
		PriorityQueue<Vertex> notMstGroup=new PriorityQueue<>();
		//연결 비용과 관련된 섬들의 정보 관리 배열
		Vertex[] vertexes=new Vertex[islandIdx];
		
		for (int i = 2; i < islandIdx; i++) {
			if(i==2) {
				vertexes[i]=new Vertex(i,0);
			}else {
				vertexes[i]=new Vertex(i,INF);
				
			}
			notMstGroup.offer(vertexes[i]);
		}
		
		int sum=0;
		
		while(!notMstGroup.isEmpty()) {
			Vertex front=notMstGroup.poll();
			
			if(front.cost==INF) {
				return -1;
			}
			sum+=front.cost;
			
			for (int i = 2; i < islandIdx; i++) {
				Vertex child=vertexes[i];
				//아직 mst 요소가 아니라면
				if(notMstGroup.contains(child)) {
					//그래프에서 비용 조회, 현재 가지고 있는 값보다 작으면 업데이트
					if(child.cost>graph[front.idx][i]) {
						child.cost=graph[front.idx][i];
						notMstGroup.remove(child);
						notMstGroup.offer(child);
					}
				}
			}
		}
			
			
		return sum;
	}

	private static void makeGrph(int r, int c) {
		//내땅
		int base=map[r][c];
		for (int d = 0; d < dirs.length; d++) {
			
			for (int l = 1; ;l++) {
				int nr=r+dirs[d][0]*l;
				int nc=c+dirs[d][1]*l;
				
				
				if(isIn(nr, nc)) {
					//바다라면 쭉 진행
					if(map[nr][nc]==0) {
						continue;
					}
					//내륙인경우 -중지
					else if(map[nr][nc]==base) {
						break;
					}
					//다른땅이라면 -> 거리가 2칸 이상일 때
					else {
						//다리를 만들 수 있는 경우
						if(l>2) {
							//무향 그랲 -> 양방향 업데이트
							graph[map[nr][nc]][base]=graph[base][map[nr][nc]]=
									Math.min(graph[base][map[nr][nc]],l-1);
							break;
							
						}
						else {
							break;
						}
					}
				}
				//영역 안에 없는 경우
				else {
					break;
				}
			}
		}
		
		
	}

	static boolean isIn(int r, int c) {

		return (r > -1 && r < R && c > -1 && c < C);

	}

	private static void bfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r, c));
		// 방문표시 - map 자체에 islandidx로 표시 한다.
		map[r][c] = islandIdx;

		while (!que.isEmpty()) {
			Point front = que.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nr = front.r + dirs[d][0];
				int nc = front.c + dirs[d][1];

				// map[nr][nc]==1 -> 방문하지 않은 땅
				if (isIn(nr, nc) && map[nr][nc] == 1) {

					map[nr][nc] = islandIdx;
					que.offer(new Point(nr, nc));

				}
			}

		}
	}

}
