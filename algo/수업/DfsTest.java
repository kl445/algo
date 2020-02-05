package algo_day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsTest {
	
	public static void getGraph(int start) {
		
		int v =8;
		String src= "1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7";
		List<Integer>[] graph= new List[v];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] =new ArrayList<Integer>();
		}
		
		String[] splited=src.split(",");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a=Integer.parseInt(splited[i]);
			int b=Integer.parseInt(splited[i+1]);
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		
		for (int j = 0; j < graph.length; j++) {
			System.out.println(j + " > " + graph[j]);
		}
//		dfs1(graph,start,v );
		dfs2(start,graph);
	}
	//스택 dfs
	public static void dfs1(List<Integer>graph[], int start,int v) {
		boolean[] visited=new boolean[v];
		
		Stack<Integer> st= new Stack<>();
		List<Integer> path= new ArrayList<>();
	
		st.add(start);
	
		while(!st.isEmpty()) {
			
			//가장 마지막을 빼옴
			Integer top=st.pop();
			
			//방문했던 지역 패스
			if(visited[top]) {
				continue;
			}
			//처음 방문하는 경우 할일 하기
			else {
				visited[top]=true;
				path.add(top);
				
				//다음 정점 가보기
				
				List<Integer> childs= graph[top];
				
				//자식중 가능한 정점 방문
				for (int i = childs.size()-1;i>=0; i--) {
//					for (int i = 0;i<childs.size(); i++) {
					Integer child=childs.get(i);
					if(!visited[child]) {
						st.push(child);
					}
				}
				System.out.println(path);
			}
			//경로 출력
		}
		System.out.println("last: "+path);
	}
	//재귀 dfs
	
	public static boolean visited2[]= new boolean[8];
	public static List<Integer> path2= new ArrayList<>();

	
	public static void dfs2( int start,List<Integer>[] graph) {
		
		
		visited2[start] =true;
		path2.add(start);
				
		//다음 정점 가보기
				
		List<Integer> childs= graph[start];
				
				//자식중 가능한 정점 방문
		for (int i = childs.size()-1;i>=0; i--) {
				Integer child=childs.get(i);
				if(!visited2[child]) {
					dfs2(child,graph);
					}
				}
		
			
			//경로 출력
		
		System.out.println("last: "+path2);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getGraph(1);
		
		
	}

}
