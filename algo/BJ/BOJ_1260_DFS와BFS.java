package algo_ad.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS와BFS {

	public static boolean allGo(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
	public static void bfs(int[][] graph, int v, boolean[] visited) {
		Queue<Integer> que= new LinkedList<>();
		que.offer(v-1);
		
		while(!que.isEmpty()) {
			int temp= que.poll();
			if(!visited[temp]) {
				System.out.print(temp+1+" ");
				visited[temp]=true;
			}
			
			
			for (int i = 0; i < graph.length; i++) {
				if(graph[temp][i]==1 && !visited[i]) {
					que.offer(i);
				}
			}
		}
	}
	
	public static void dfs(int[][] graph,int v ,boolean[] visited) {
		
		Stack<Integer> st=new Stack<>();
		
		st.add(v-1);
		while(!st.isEmpty()) {
			int temp= st.pop();
			if(!visited[temp]) {
				System.out.print(temp+1+" ");
				visited[temp]=true;
			}
			
			
			for (int i = graph.length-1; i >=0; i--) {
				if(graph[temp][i]==1 && !visited[i]) {
					st.push(i);
					
				}
			}
					
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc =new Scanner(System.in);
		
		int n= sc.nextInt();
		int m= sc.nextInt();
		
		int v=sc.nextInt();
		
		int graph[][]=new int[n][n];
		
		for (int i = 0; i < m; i++) {
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			
			graph[num1-1][num2-1]=1;
			graph[num2-1][num1-1]=1;
		}
		
//			for (int i = 0; i < graph.length; i++) {
//				for (int j = 0; j < graph.length; j++) {
//					System.out.print(graph[i][j]+" ");
//				}
//				System.out.println();
//			} 
		
		
		dfs(graph, v, new boolean[n]);
		System.out.println();
		bfs(graph,v,new boolean[n]);
		
	}

}
