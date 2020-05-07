package algo.hw0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {

	static int[][] team_res;
	static int valid;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		team_res=new int[4][18];
		for (int i = 0; i < 4; i++) {
			tk=new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
					team_res[i][j]=Integer.parseInt(tk.nextToken());
			}
			valid=0;
			dfs(0,1,team_res[i]);
			sb.append(valid).append(" ");
			
		}
		System.out.println(sb.toString());
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 6; j++) {
//				for (int k = 0; k < 3; k++) {
//					System.out.print(team_res[i][j][k]+" ");
//				}
//			}
//			System.out.println();
//		}
		
		
		
		
	}

	//0-{1,2,3,4,5} 1-{2,3,4,5} 2-{3,4,5} 3-{4,5} 4-{5}
	private static void dfs(int teamA, int teamB, int[] score) {
		// 상대팀이 6을 넘어가는 경우 -우리팀이 변경됨
		if(teamB==6) {
			dfs(teamA+1, teamA+2,score);
			return;
		}
		
		//teamA가 4보다 커지면 솔루션 실행
		if(teamA>4) {
			for (int i = 0; i < score.length; i++) {
				//아직 스코어 결과내에 내용이 있다면 실패
				if(score[i]>0) {
					valid=0;
					return;
				}
			}
			valid=1;
			return;
		}
		
		for (int i = 0, j=2; i <3; i++,j--) {
			if(score[teamA*3+i]>0 && score[teamB*3+j]>0) {
				score[teamA*3+i]--;
				score[teamB*3+j]--;
				dfs(teamA, teamB+1, score);
				score[teamA*3+i]++;
				score[teamB*3+j]++;
			}
		}
		
		
		/*
		//teamA가 이기고 teamB가 지는경우
		if(score[teamA*3+0]>0 && score[teamB*3+2]>0) {
			score[teamA*3+0]--;
			score[teamB*3+2]--;
			dfs(teamA, teamB+1, score);
			score[teamA*3+0]++;
			score[teamB*3+2]++;
			
		}
		//teamA와 teamB가 비기는 경우
		if(score[teamA*3+1]>0 && score[teamB*3+1]>0) {
			score[teamA*3+1]--;
			score[teamB*3+1]--;
			dfs(teamA, teamB+1, score);
			score[teamA*3+1]++;
			score[teamB*3+1]++;
		}
		//teamA가지고 teamB가 이기는 경유
		if(score[teamA*3+2]>0 && score[teamB*3+0]>0) {
			score[teamA*3+2]--;
			score[teamB*3+0]--;
			dfs(teamA, teamB+1, score);
			score[teamA*3+2]++;
			score[teamB*3+0]++;
		}*/
		
		
	}

}
