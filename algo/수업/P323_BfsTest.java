package algo_day6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P323_BfsTest {

	private static String src= "1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7";
	
	private static List<Integer>[] graph= new List[8];
	private static int[] mindepth=new int[8];
	
	
	public static void getGrpah(){
	
		
		
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

		
	}
	
	
	public static void bfs(int start) {
		//최소값을 찾을거니 최대값으로 초기화
		Arrays.fill(mindepth, Integer.MAX_VALUE);
		
		//방문표시
		boolean[] visitied=new boolean[8];
		
		//출발점을 큐에 넣고 시작
		Queue<Integer> qu= new LinkedList<>();	
		
		qu.offer(start);
		visitied[start]=true;
		
		mindepth[start]=0;
		
		
		while(!qu.isEmpty()) {
			Integer front=qu.poll();
			System.out.print(front+" - ");
			
			List<Integer> childs=graph[front];
			for (int i = 0; i < childs.size(); i++) {
				Integer child= childs.get(i);
				if(!visitied[child]) {
					if(mindepth[child] > mindepth[front]+1) {
						mindepth[child]=mindepth[front]+1;
					}
					
					qu.offer(child);
					visitied[child]=true;
				}
			}
		}
		System.out.println(Arrays.toString(mindepth));

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getGrpah();
		bfs(1);
		
		
	
	}

}
