package algo.hw0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_모의_요리사 {

	static int N, min;
	static int[][] map;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			select = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			
			
			min = Integer.MAX_VALUE;
			combi(0, 0);

			sb.append(min);
			System.out.println(sb.toString());

		}

	}
	
	
	static void combi(int c, int start) {
		
		if(start>=N) return;
		if(N/2==c) {
			
			int sum1=0;
			int sum0=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(select[i]!=select[j]) continue;
					
					if(select[i]) {
						sum1+=map[i][j]+map[j][i];
					}
					else{
						sum0+=map[i][j]+map[j][i];
					}
				}
			}
			min=Math.min(min, Math.abs(sum1-sum0));
			return;
		}
		else {
			for (int i = start; i < N; i++) {
				select[i]=true;
				combi(c+1, i+1);
				select[i]=false;
			}
		}
	}

}
