package algo.hw0311;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1251_D4_하나로 {

	static int N, bridge;
	static double E;
	static double pay;
	
	static int[][] map;
	static double[][] memo;
	static boolean[] visited;
	static int[] parent;
	
	static class Pos{
		int start;
		int end;
		double range;
		public Pos(int start,int end, double range) {
			this.start = start;
			this.end=end;
			this.range = range;
		}
		@Override
		public String toString() {
			return "[start=" + start +",end"+end+ ", range=" + range + "]";
		}
	}
//	static LinkedList<Pos> list;
	static PriorityQueue<Pos> list;
	
	static  int find(int a) {
		if(a==parent[a]) return a;
		
		parent[a]=find(parent[a]);
		return parent[a];
	}
	static void union(int a, int b) {
		int aParent=find(a);
		int bParent=find(b);
		if(aParent!=bParent) {
			parent[aParent]=b;
		}else {
			return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t).append(" ");
			N=sc.nextInt();
			bridge=N-1;
			
			pay=Double.MAX_VALUE;
			map=new int[N][2];
			memo=new double[N][N];
			visited=new boolean[N];
			parent=new int[N];
			
			for (int i = 0; i < N; i++) {
				parent[i]=i;
			}
			
//			list= new LinkedList<>();
			list=new PriorityQueue<>(new Comparator<Pos>() {

				@Override
				public int compare(Pos o1, Pos o2) {
					// TODO Auto-generated method stub
					Double type1=o1.range;
					Double type2=o2.range;
					return type1.compareTo(type2);
				}
			});
			
			
			for (int i = 0; i < N; i++) {
				map[i][0]=sc.nextInt();
				
			}
			for (int i = 0; i < N; i++) {
				map[i][1]=sc.nextInt();
				
			}
			E=sc.nextDouble();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(i==j) continue;
					double s_x=map[i][0];
					double s_y=map[i][1];
					double e_x=map[j][0];
					double e_y=map[j][1];
					
					if(memo[i][j]!=0) {
						
					}else {
						double x=Math.pow(Math.abs(s_x-e_x), 2);
						double y=Math.pow(Math.abs(s_y-e_y), 2);
//						memo[i][j]=E*(x+y);
						double res=E*(x+y);
						
						list.add(new Pos(i,j,res));
					}
					
				}
			}
			
			int idx=0;
			double range=0;
			int line=0;
			while(line<N-1) {
//				Pos temp=list.get(idx++);
				Pos temp=list.poll();
				
				int a=find(temp.start);
				int b=find(temp.end);
				
				if(a==b) {
					continue;
				}
				union(a,b);
				line++;
				range+=temp.range;
			}
			
			
			
			
			
//			perm(0, new int[N], new boolean[N]);
			pay=range;
			sb.append(Math.round(pay));
			System.out.println(sb.toString());
			
			
		}
	}

}
