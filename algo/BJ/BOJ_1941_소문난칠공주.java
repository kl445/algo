package algo.hw0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_소문난칠공주 {

	static char[][] map=new char[5][5];
	static int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	static int res=0;
	static boolean visited[]=new boolean[25];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			map[i]=input.readLine().toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		
		for(int i=0; i<25;i++) {
//			combi(i,1,0);
			
		}
		
		dfs(0, 0, 0,new int[7]);
		
		System.out.println(res);
		
	}
	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static void dfs(int idx, int start,int sCnt,int temp[]) {
		if(idx==7) {
			Arrays.fill(visited, false);
//			System.out.println(Arrays.toString(temp));
			for (int i = 0; i < temp.length; i++) {
				visited[temp[i]]=true;
				if(map[temp[i]/5][temp[i]%5]=='S') {
					sCnt++;
				}
			}
			
			if(sCnt>=4) {// 4명 이상인지
				
				if(bfs(temp[0]/5,temp[0]%5)) { //연결되어있는지
					res++;
				}
			}
			
			
			
//			System.out.println(Arrays.toString(visited));
//			for (int i = 0; i < visited.length; i++) {
//				if(visited[i]) {
//					System.out.print("("+i/5+","+i%5+") ");
//					
//				}
//			}
//			System.out.println();
			return;
		}
		
		for (int i = start; i < 25; i++) {
				temp[idx]=i;
				dfs(idx+1, i+1, sCnt,temp);
	
		
		}
		
		
	}
	
	static boolean bfs(int r, int c) {
		Queue<Pos> que=new LinkedList<>();
		que.offer(new Pos(r,c));
		
		boolean[][] v1=new boolean[5][5];
		v1[r][c]=true;
	
		Pos ps=null;
		int vCnt=1;
		while(!que.isEmpty()) {
			ps=que.poll();
			
			
			for (int d = 0; d < dirs.length; d++) {
				int nr= ps.r+dirs[d][0];
				int nc= ps.c+dirs[d][1];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				
				if(v1[nr][nc]) {
					continue;
				}
				
				//같은 팀 판별(7공주로 선발되지 않았는지)
				if(!visited[nr*5+nc]) {
					continue;
				}
				
				v1[nr][nc]=true;
				que.offer(new Pos(nr,nc));
				vCnt++;
			}
		}
		
		
		return vCnt==7?true:false;
	}
	
	private static void combi(int idx, int cnt,int sCnt) {
		visited[idx]=true;
		
		if(map[idx/5][idx%5]=='S') {
			sCnt++;
		}
		
		
		//종료
		if(cnt==7) {
			System.out.println(Arrays.toString(visited));
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					System.out.print("("+i/5+","+i%5+") ");
					
				}
			}
			System.out.println();
			//판단
			if(sCnt>=4) {// 4명 이상인지
				
	
				if(bfs(idx/5,idx%5)) { //연결되어있는지
					res++;
				}
			}
			visited[idx]=false;
			return;
		}
		
		for (int i =idx+1; i < 25; i++) {
			if(visited[i]) { //선택되지  않았다면
				continue;
			}
			combi(i, cnt+1,sCnt);
			//백트래킹
			visited[idx]=false;
		}
		
	}

	static boolean isIn(int r,int c) {
		return(r<5 && c<5 && -1<r && -1<c);
	}

}
