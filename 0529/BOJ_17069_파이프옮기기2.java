package algo.hw0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {

	static int N;
	static int map[][];
	static int dirs[][][]= {{{0,1},{1,1},{0,0}},{{0,1},{1,1},{1,0}},{{1,0},{1,1},{0,0}}};
	static int max;
	
	static class Pos{
		int r;
		int c;
		int type;
		public Pos(int r, int c,int type) {
			super();
			this.r = r;
			this.c = c;
			this.type=type;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", type="+type+"]";
		}
		
	}
	public static void main(String[] args) throws  IOException {
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		map=new int[N][N];
		StringTokenizer tk=null;
		for (int i = 0; i < N; i++) {
			tk=new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		max=0;
		
		boolean[][] visited=new boolean[N][N];
		visited[0][1]=true;
		dfs(new Pos(0,1,0),visited);
		
		System.out.println(max);

	}
	static boolean isIn(int nr, int nc) {
		return(nr>=0 && nc>=0 && nr<N && nc<N);
	}
	private static void dfs(Pos pos, boolean[][] visited) {
		
		if(pos.r==N-1 && pos.c==N-1) {
			max++;
			return;
		}
		
		if(pos.type==1 && pos.c==N-1 && down(pos)) {
			
			max++;
			return;
		}
		
		
		
		for (int d = 0; d < dirs[pos.type].length; d++) {
			int nr= pos.r+dirs[pos.type][d][0];
			int nc= pos.c+dirs[pos.type][d][1];
			
			if(isIn(nr, nc) && !visited[nr][nc]) {
				
				if(pos.type!=1) {
					if(d!=1) {
						if(map[nr][nc]==0) {
							visited[nr][nc]=true;
							dfs(new Pos(nr,nc,pos.type), visited);
							visited[nr][nc]=false;
						}						
					}
					else{
						if(map[nr][nc]==0 && map[nr-1][nc]==0 && map[nr][nc-1]==0) {
							visited[nr][nc]=true;
							dfs(new Pos(nr,nc,d), visited);
							visited[nr][nc]=false;
						}
					}
					
				}
				else {
					if(d!=1) {
						if(map[nr][nc]==0) {
							visited[nr][nc]=true;
							dfs(new Pos(nr,nc,d), visited);
							visited[nr][nc]=false;
						}						
					}
					else{
						if(map[nr][nc]==1 && map[nr-1][nc]==1 && map[nr][nc-1]==1) {
							visited[nr][nc]=true;
							dfs(new Pos(nr,nc,pos.type), visited);
							visited[nr][nc]=false;
						}
					}
				}
			}
			
			
		}
		
		
		
	}
	static boolean down(Pos pos) {
		for (int i = pos.r; i < N; i++) {
			if(map[i][pos.c]==1) {
				return false;
			}
		}
		return true;
	}

}
