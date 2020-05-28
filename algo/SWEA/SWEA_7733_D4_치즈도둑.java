package algo.hw0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733_D4_치즈도둑 {

	
	static int N;
	static int map[][];
	static int dirs[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visited[][];
	static int max,cnt, day_max;
	
	
	static class Pos{
		int r;
		int c;
		int day;
		public Pos(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", day=" + day + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(input.readLine());
		
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N=Integer.parseInt(input.readLine());
			day_max=0;
			map=new int[N][N];
			max=1;
			for (int i = 0; i < N; i++) {
				StringTokenizer tk=new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(tk.nextToken());
					day_max=Math.max(day_max, map[i][j]);
				}
			}
			
			
			
			for (int i = 1; i <= day_max; i++) {
				visited=new boolean[N][N];
				cnt=0;
				
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(map[j][k]<=i) {
							map[j][k]=0;
						}
						else {
							if(!visited[j][k]) {
								bfs(new Pos(j,k,map[j][k]),i);
								
							}
						}
					}
				}
				max=Math.max(max, cnt);
				
	
			}
			
			System.out.println("#"+tc+" "+max);
			
			
		}
	}

	private static void bfs(Pos pos,int day) {
		
		
		Queue<Pos> q=new LinkedList<>();
		
		
		q.add(pos);
		visited[pos.r][pos.c]=true;
		
		
		while(!q.isEmpty()) {
			
			Pos temp=q.poll();
			
			for (int d = 0; d < dirs.length; d++) {
				
				int nr=temp.r+dirs[d][0];
				int nc=temp.c+dirs[d][1];
				
				
				if(isIn(nr,nc)&& !visited[nr][nc] && map[nr][nc]>day) {
					q.add(new Pos(nr,nc,map[nr][nc]));
					visited[nr][nc]=true;
				}
			}
			
			
		}
		
		cnt++;
	}

	private static boolean isIn(int nr, int nc) {
		return (nr<N && nc<N && -1<nr && -1<nc);
	}

}
