package algo_ad.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1247_D5_최적경로 {

	private static int[] office= new int[2];
	private static int[] home= new int[2];
	private static int min=Integer.MAX_VALUE;
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void sumRange(Queue<Pos> list) {
		
		int now_min=0;
		
		Pos start=list.poll();
		while(!list.isEmpty()) {
			
			now_min+=Math.abs(start.x-list.peek().x)+Math.abs(start.y-list.peek().y);
				
			start=list.poll();
		}
		
		min=Math.min(min, now_min);
		
	}
	
	public static void perm(int r, int c, boolean visited[], int[] temp,int[][] cus) {
		
		if(r==c) {
			Queue<Pos> list=new LinkedList<>();
			list.add(new Pos(office[0],office[1]));
			for (int i = 0; i < temp.length; i++) {
				list.add(new Pos(cus[temp[i]][0],cus[temp[i]][1]));
			}
			list.add(new Pos(home[0],home[1]));
			
			sumRange(list);
			
		}
		else {
			for (int i = 0; i < visited.length; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[c]=i;
					perm(r, c+1, visited, temp,cus);
					visited[i]=false;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			
			int[][] cus=new int[n][2];
			for (int j = 0; j < office.length; j++) {
				office[j]=sc.nextInt();
			}
			for (int j = 0; j < home.length; j++) {
				home[j]=sc.nextInt();
			}
			for (int j = 0; j < cus.length; j++) {
				cus[j][0]=sc.nextInt();
				cus[j][1]=sc.nextInt();
			}
			
			min=Integer.MAX_VALUE;
			perm(n, 0, new boolean[n], new int[n], cus);
			
			
			
			System.out.printf("#%d %d\n",i,min);
			
			
			
		}
	}

}
