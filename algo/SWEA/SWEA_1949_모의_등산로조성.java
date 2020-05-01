package algo.hw0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1949_모의_등산로조성 {
	
	static class Pos{
		int r;
		int c;
		int res;
		
		public Pos(int r, int c,int res) {
			super();
			this.r = r;
			this.c = c;
			this.res=res;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", res=" + res + "]";
		}
	}
	
	static int N,K,cnt;
	static int map[][];
	static boolean visited[][];
	
	static int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
	
	static boolean isIn(int r, int c) {
		return (r>-1 && c>-1 && r<N && c<N &&!visited[r][c]);
	}
	
	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	static void dfs(int[][] map2,int r,int c, ArrayList<Pos> list, boolean flag,int[] temp) {
		
//		printMap();
//		System.out.println();
		
		for (int d = 0; d < dirs.length; d++) {
			int nr=r+dirs[d][0];
			int nc=c+dirs[d][1];
			
			if(isIn(nr, nc) && map2[nr][nc]<map2[r][c]) {

				

				list.add(new Pos(nr,nc,map2[nr][nc]));
				visited[nr][nc]=true;
				dfs(map2,nr, nc, list, flag,temp);
				
				list.remove(list.size()-1);
				visited[nr][nc]=false;

				
			}
			else if(isIn(nr, nc) && map2[nr][nc]<K+map2[r][c] && !flag) {
				flag=true;
				temp[0]=nr;
				temp[1]=nc;
				temp[2]=1;
				temp[3]=map2[nr][nc];
				map2[nr][nc]=map2[r][c]-1;
				
				list.add(new Pos(nr,nc,map2[nr][nc]));
				visited[nr][nc]=true;
				dfs(map2,nr, nc, list, flag,temp);
				list.remove(list.size()-1);
				visited[nr][nc]=false;
				flag=false;
				temp[2]=0;
				map2[nr][nc]=temp[3];
				
			}
			
			
		}
		
		
		
		int now=list.isEmpty()?0:list.size();
		cnt=Math.max(cnt, now);

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk= new StringTokenizer(br.readLine());
		
		int TC=Integer.parseInt(tk.nextToken());
		
		for (int tc = 0; tc < TC; tc++) {
			
			StringBuilder sb=new StringBuilder();
			
			sb.append("#").append(tc+1).append(" ");
			
			tk=new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(tk.nextToken());
			K=Integer.parseInt(tk.nextToken());
			map=new int[N][N];
			int max=-1;
			
			
			for (int i = 0; i < map.length; i++) {
				tk=new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					int token=Integer.parseInt(tk.nextToken());
					
					max=Math.max(max, token);
					map[i][j]=token;
				}
			}
			
			
			cnt=Integer.MIN_VALUE;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					if(map[i][j]==max) {
						visited=new boolean[N][N];
						visited[i][j]=true;
						dfs(map,i, j, new ArrayList<Pos>(), false,new int[4]);
						visited[i][j]=false;
					}	
				}
			}
			
			sb.append(cnt+1);
			System.out.println(sb.toString());

		}
		
	}

}
