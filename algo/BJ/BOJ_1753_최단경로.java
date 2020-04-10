package algo.hw0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge() {};
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk=new StringTokenizer(br.readLine()," ");
		
		//정점, 간선
		int V=Integer.parseInt(tk.nextToken());
		int E=Integer.parseInt(tk.nextToken());
		
		//시작점
		int start_v=Integer.parseInt(br.readLine())-1;
		
		
		//인접리스트배열
		ArrayList<Edge>[] list= new ArrayList[V];
		//목적지배열
		Edge[] d=new Edge[V];
		//방문 확인 배열
		boolean[] visited=new boolean[V];
		
		
		for (int i = 0; i <V; i++) {
			list[i]=new ArrayList<Edge>();
			d[i]=new Edge(i,Integer.MAX_VALUE);
		}
		
		
		for (int i = 0; i < E; i++) {
			tk=new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(tk.nextToken())-1;
			int end=Integer.parseInt(tk.nextToken())-1;
			int w=Integer.parseInt(tk.nextToken());
			
			list[start].add(new Edge(end, w));
		}
		
		d[start_v].w=0;
		d[start_v].v=start_v;
		
		//우선순위큐에 D배열 삽입
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		
		for (int i = 0; i < d.length; i++) {
			pq.add(d[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge index=pq.poll();
			if(index.w==Integer.MAX_VALUE) {
				break;
			}
			for (Edge next : list[index.v]) {
				
				if(!visited[next.v] && d[next.v].w>next.w+d[index.v].w) {
					d[next.v].w=next.w+d[index.v].w;
					
					pq.remove(d[next.v]);
					pq.add(d[next.v]);
				}
			}
			visited[index.v]=true;
		}
		
		for (int i = 0; i < d.length; i++) {
			System.out.println((d[i].w==Integer.MAX_VALUE)?"INF":d[i].w);
		}
		
		
		
		
	}

}
