package algo.hw0311;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1251_D4_하나로2 {

	static int N, bridge;
	static double E;
	static double pay;
	
	static long[][] map;
	static long[][] graph; //정점간의 거리 그래프
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t).append(" ");
			N=sc.nextInt();
			
			map=new long[N][2];
			for (int i = 0; i < N; i++) {
				map[i][0]=sc.nextLong();
				
			}
			for (int i = 0; i < N; i++) {
				map[i][1]=sc.nextLong();
				
			}
			E=sc.nextDouble();
			//입력된 자료를 기반으로 섬간의 가중치 그래프 구하기
			
			graph=new long[N][N];
			long[] from, to;
			for(int r=0; r<N;r++) {
				from=map[r];
				for(int c=r+1;c<N;c++) {
					to=map[c];
					graph[c][r]=graph[r][c]=(from[0]-to[0])*(from[0]-to[0])+(from[1]-to[1])*(from[1]-to[1]);
				}
				
			}
			
			pay=prim(0) *E;
			
			sb.append(Math.round(pay));
			System.out.println(sb.toString());
			
			
		}
	}
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		
		public Edge(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			
			return Long.compare(this.cost, o.cost);
		}
		
	}
	private static double prim(int start) {
		
		//mst에 들어가지 않은 녀석들
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		//모든 정점들 관리
		Edge[] dynamicGrpah=new Edge[N];
		
		//
		for (int n = 0; n < dynamicGrpah.length; n++) {
			dynamicGrpah[n]=new Edge(n, Long.MAX_VALUE);
			if(n==start) {
				dynamicGrpah[n].cost=0;
			}
			pq.add(dynamicGrpah[n]);			
		}
		
		long cost=0;

		while(!pq.isEmpty()) {
			Edge front= pq.poll(); //mst 포함된 녀석
			cost+=front.cost;
			
			//자식 탐색
			for (int i = 0; i < dynamicGrpah.length; i++) {
				Edge child= dynamicGrpah[i];
				//pq:비 mst
				if(pq.contains(child)) {
					long tempCost=graph[front.idx][child.idx];
					if(tempCost<child.cost) {
						child.cost=tempCost;
						pq.remove(child);
						pq.offer(child);
						
					}
				}
			}
		}
		
		return cost;
		
	}

}
