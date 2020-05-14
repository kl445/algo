package algo.hw0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {

	static int R, C;
	static char map[][];
	static boolean visited[][][]; // row, col, key  

	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Pos {
		int r;
		int c;
		int cnt;
		int key;

		public Pos(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}



		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		map = new char[R][C];
		visited=new boolean[R][C][1<<6];
		Pos start=null;
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(input.readLine());
			String str = tk.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='0') {
					start=new Pos(i,j,0,0);
				}
			}
		}
			
			int res=bfs(start);
			System.out.println(res);
		}

		

	private static int bfs(Pos start) {
		Queue<Pos> q=new LinkedList<>();
		
		q.offer(start);
		visited[start.r][start.c][0]=true;
		
		Pos temp;
		while(!q.isEmpty()) {
			temp=q.poll();
			
			if(map[temp.r][temp.c]=='1') {
				return temp.cnt;
			}
			
			for (int d = 0; d < dirs.length; d++) {
				
				int nr= temp.r+dirs[d][0];
				int nc= temp.c+dirs[d][1];
				int key= temp.key;
				
				//1. 범위 벗어나는지 체크
				if(!isIn(nr, nc)) {
					continue;
				}
				//2. 벽이면 무시
				if(map[nr][nc]=='#') {
					continue;
				}
				//3. 방문한곳 무시
				if(visited[nr][nc][key]) {
					continue;
				}
				//4. 키가 있으면 습득
				if('a'<=map[nr][nc] && 'f'>=map[nr][nc]) {
					key |= (1<< (map[nr][nc]-'a')); //기존 key값과 해당 key에 해당하는 문자열을 or 연산
				}
				//5. 문인데 키가 없으면 무시
				if('A'<=map[nr][nc] && 'F'>=map[nr][nc]) {
					//현재 key와 문을 비트마스킹
					if((key &(1<< (map[nr][nc]-'A')))==0) {
						continue;
					}
					
				}
				//6. 방문체크후 재삽입
				visited[nr][nc][key]=true;
				q.offer(new Pos(nr, nc, temp.cnt+1, key));
				
			}
			
		}
		
		return-1;
	}

	static boolean isIn(int r, int c) {
		return (r < R && c < C && -1 < r && -1 < c);
	}




}
