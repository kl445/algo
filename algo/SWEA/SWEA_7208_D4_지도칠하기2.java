package algo.hw0521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7208_D4_지도칠하기 {

	static int map[][];
	static int N;
	static int[] color;
	static int[] fill;
	
	static int min;
	
	public static void main(String[] args) throws Exception {
		
		//데이터 입력
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(input.readLine());
		
		int TC=Integer.parseInt(tk.nextToken());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N=Integer.parseInt(input.readLine());
			map=new int[N][N];
			color=new int[N];
			fill=new int[N];
			min=Integer.MAX_VALUE;
			
			tk=new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				color[i]=Integer.parseInt(tk.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				tk=new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(tk.nextToken());
				}
			}
			
			
		//순열 생성 후, 생성된 순열이 인접된 국가의 색이 다르게 작성된 순열이 생성된 경우 기존의 color 값과
		//새로 생성한 순열이 얼마나 다른지 비교 후 카운트
			
			dfs(0);
		
		
		//결과 출력
			System.out.println("#"+tc+" "+(min==Integer.MAX_VALUE?0:min));
		}
	}

	private static void dfs(int cnt) {

		if(cnt==N) {
			//인접된 국가가 다른 color로 칠할 수 있는 순열인 경우
			if(check()) {
				int count=0;
				for (int i = 0; i < N; i++) {
					if(color[i]!=fill[i]) {
						count++;
					}
				}
				min=Math.min(min, count);
			}
			return;
		}
		
		//중복 순열
		for (int i = 1; i <= 4; i++) {
			fill[cnt]=i;
			dfs(cnt+1);
		}
		
	}

	private static boolean check() {
		
		for (int i = 0; i < N; i++) {//cur
			for (int j = 0; j < N; j++) { //인접국
				
				if(map[i][j]==1 && fill[i]==fill[j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
