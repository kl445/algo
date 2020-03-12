package algo.hw0227;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_7699_D4_수지의수지맞는여행 {

	static class Pos{
		int r;
		int c;
		char ch;
		public Pos(int r, int c,char ch) {
			this.r = r;
			this.c = c;
			this.ch=ch;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", ch=" + ch + "]";
		}
		
		
	}
	
	public static boolean mapIn(int row,int col, int nr, int nc) {
		
		return (nr>-1 && nc>-1 && nr<row && nc<col);
	}
	public static int[][] dirs= {{0,1},{0,-1},{-1,0},{1,0}};
	
	public static int max;
	public static boolean listIn(ArrayList<Character> list) {
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(i)==list.get(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean flag=false;
	
	public static void dfs(char[][] map,int r, int c, ArrayList<Character> list) {
		
		if(max==26) {
			return;
		}
		if(listIn(list)) {
//			System.out.println(list.toString());
			max=Math.max(max,list.size()-1);
			return;
		}
		else if(list.size()==map.length*map[0].length ) {
			max=Math.max(max,list.size());
		}
		else {

			for (int d = 0; d < dirs.length; d++) {
				int nr=r+dirs[d][0];
				int nc=c+dirs[d][1];
				if(mapIn(map.length, map[0].length, nr, nc)) {
					char token=map[nr][nc];
					list.add(token);
//					list.add(map[nr][nc]);
					dfs(map, nr, nc,  list);
//					list.remove(list.size()-1);
					if(list.lastIndexOf(token)!=-1) {
						list.remove(list.lastIndexOf(token));
					}
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			int row=sc.nextInt();
			int col=sc.nextInt();
			
			
			char map[][]=new char[row][col];
			
			for (int j = 0; j < map.length; j++) {
				map[j]=sc.next().toCharArray();
			}
//			Stack<Pos> st= new Stack<>();
			
			ArrayList<Character> list= new ArrayList<>();
			
			max=Integer.MIN_VALUE;
			
//			st.push(new Pos(0,0,map[0][0]));
			
			list.add(map[0][0]);
			dfs(map, 0, 0, list);
//			while(!st.isEmpty()) {
//				Pos temp=st.pop();
//				
//				if(listIn(list, temp.ch)) {
//					max=Math.max(max,list.size());
//					
//				}
//				else {
//					list.add(temp.ch);
//					for (int d = 0; d < dirs.length; d++) {
//						int nr=temp.r+dirs[d][0];
//						int nc=temp.c+dirs[d][1];
//						if(mapIn(row, col, nr, nc)) {
//							st.push(new Pos(nr,nc,map[nr][nc]));
//						}
//					}
//				}
//			}
			
			System.out.printf("#%d %d\n",i,max);
			
			
		}
		
	}

}
