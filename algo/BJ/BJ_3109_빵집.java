	package swea_0211;
	
	import java.util.Arrays;
	import java.util.Scanner;
	import java.util.Stack;
	
	 class Pos{
		public int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	public class BJ_3109_빵집 {
		static int cnt=0;
		
	
		public static boolean isIn(int r, int c, char[][] map) {
			return (r < map.length && c < map[0].length && r > -1 && c > -1 && map[r][c]=='.');
		}
	
		public static int[][] dirs = { { -1, -1 },{ 0, -1 },{ 1, -1 }};
	
		public static void printMap(char[][] map) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	
		public static void sameMap(char[][] map, char arr[][]) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					map[i][j]=arr[i][j];
				}
			}
		}
		public static void pipe(char[][] map, int r, int c, char visited[][],int max) {
			
//			if(cnt>=(map.length-max)) {
//				return;
//			}
			
			
			if (c==0) {
				cnt++;
				sameMap(map,visited);
				return;
			} 
			else {
					
					
//				for (int d = 0; d < dirs.length; d++) {
//					int nr=r+dirs[d][0];
//					int nc=c+dirs[d][1];
//					
//					if(isIn(nr,nc,map)) {
//						visited[r][c]='x';
//						pipe(map,nr,nc,visited);
//						visited[r][c]='.';
//					}
//				}

						if(isIn(r-1,c-1,map)) {
							visited[r][c]='x';
							pipe(map,r-1,c-1,visited,max);
//							visited[r][c]='.';
						}
						else if(isIn(r,c-1,map)) {
							visited[r][c]='x';
							pipe(map,r,c-1,visited,max);
//							visited[r][c]='.';
						}
						else if(isIn(r+1,c-1,map)) {
							visited[r][c]='x';
							pipe(map,r+1,c-1,visited,max);
//							visited[r][c]='.';
						}
					
			}
	
		}
	
		public static void main(String[] args) {
	
			Scanner sc = new Scanner(System.in);
	
			int r = sc.nextInt();
			int c = sc.nextInt();
	
			char map[][] = new char[r][c];
			char visited[][] = new char[r][c];
	
			for (int i = 0; i < map.length; i++) {
				String str = sc.next();
				map[i] = str.toCharArray();

			}
//			sameMap(visited, map);
	
	//		printMap(map);
			
			
			
			Stack<Pos> st= new Stack<>();
			
			
			int max=0;
			int xtemp=0;
			
			for (int i = 0; i < map[0].length; i++) {
				
				xtemp=0;
				for (int j = 0; j < map.length; j++) {
					if(map[j][i]=='x') {
						xtemp++;
					}
				}
				max=Math.max(max, xtemp);
				
			} 
			
//			System.out.println("max"+ max);
			for (int i = 0; i < map.length; i++) {
			
//				sameMap(visited, map);
				
//				if(cnt>=(r-max)) {
//					break;
//				}
				if(map[i][map[0].length-2]=='.'){
					
					pipe(map,i,map[0].length-2,visited,max);
					
//				st.push(new Pos(i,map[0].length-2));
//				
//				while(!st.isEmpty()) {
//					
//					Pos ps=st.pop();
//					
//					if(ps.c==0) {
//						cnt++;
//						while(!st.isEmpty()) {
//							st.pop();
//						}
//					}
//					
//					for (int d = 0; d < dirs.length; d++) {
//						int nr=ps.r+dirs[d][0];
//						int nc=ps.c+dirs[d][1];
//						
//						if(isIn(nr,nc,map)) {
//							st.push(new Pos(nr,nc));
//						}
//					}
//						
//				}
//				
//			}
			}
			
			}
			System.out.println(cnt);
//			printMap(map);
			
			
			
	
		}
	
	}
