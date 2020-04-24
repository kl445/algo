package algo.hw0423;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_16234_인구이동 {

	static int N,R,L;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class pos{
		int r;
		int c;
		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		N=sc.nextInt();
		L=sc.nextInt();
		R=sc.nextInt();
		
		map=new int[N][N];
		
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		
		while(true) {
			visited=new boolean[N][N];
			if(!move()) {
				cnt++;
			}else {
				break;
			}
			
		}
		
		System.out.println(cnt);

		
	}
	static boolean insIn(int r,int c) {
		return (r>-1 && c>-1 && r<N && c<N);
	}
	static boolean move() {
		List<pos> list;
		boolean isMove=true;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					list=new LinkedList<pos>();
					list.add(new pos(i,j));
					int sum=dfs(i,j,list,0);
					
					if(list.size()>1) {
						avg(sum,list);
						isMove=false;
					}
					
				}
			}
		}
		return isMove;
		
	}
	
	static int dfs(int r, int c, List<pos> list, int sum) {
		visited[r][c]=true;
		sum=map[r][c];
		
		for (int d = 0; d < dirs.length; d++) {
			int n_r=r+dirs[d][0];
			int n_c=c+dirs[d][1];
			
			if(insIn(n_r, n_c)) {
				if(!visited[n_r][n_c]) {
					int sub=Math.abs(map[r][c]-map[n_r][n_c]);
					if(sub>=L && sub<=R) {
						list.add(new pos(n_r,n_c));
						sum+=dfs(n_r, n_c, list, sum);
					}
				}
			}
		}
		
		return sum;
	}
	
	static void avg(int sum,List<pos> list) {
		int avg=sum/list.size();
		for (pos p : list) {
			map[p.r][p.c]=avg;
		}
	}
	
	

	
}
