package algo.hw0227;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SWEA_2105_모의_디저트카페 {

	static int n,max, s_r,s_c;
	static int map[][];
	static boolean visited[][];
	static HashSet<Integer>	list= new HashSet<Integer>();
	
	static int[][] dirs= {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int t = 1; t <=tc; t++) {
			//입력처리
				//max를 0으로 초기화
			max=0;
				//N을 입력받아 N*N배열 생성
				//N*N boolean 생성
			n=sc.nextInt();
			map=new int[n][n];
			visited=new boolean[n][n];

			//데이터 읽기
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			//탐색 -dfs
			//N*N을 돌면서 i j 번째의 카페부터 투어 시작
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					//시작좌표를 i,j로 설정
					s_r=i;
					s_c=j;
					//set 초기화
					list.clear();
					//visited배열 초기화
					for (int k = 0; k < n; k++) {
						Arrays.fill(visited[k], false);
					}
					//dfs 탐색(i,j,d)
					dfs(i,j,0);
					
				}
			}
			if(max==0) {
				max=-1;
			}
			System.out.printf("#%d %d\n",t,max);
		}
	}
	private static void dfs(int r, int c, int dir) {
		
		//현재 노드에 대한 방문처리
		visited[r][c]=true;
		//set에 현재 노드 추가
		list.add(map[r][c]);
		//현재 방향에서 부터  4반복
		for (int i = dir; i < 4; i++) {			
			int nr=r+dirs[i][0];
			int nc=c+dirs[i][1];
			int cnt=list.size();
			//다음좌표가 시작 좌표이고 cnt>=4이상인지 검사 -> 한바퀴 돌음
			if(nr==s_r && nc==s_c && cnt>=4) {
				//cnt와 max 비교 후 갱신
				if(cnt>max) {
					max=cnt;
					return;
				}
			}
			
			//다음좌표가 경계내에 있고 방문 한적 없고, 처음먹었는지 검사
			if(nr>-1 && nr<n && nc>-1 && nc<n &&!visited[nr][nc] && !list.contains(map[nr][nc])) {
				//다음 노드 이동 -> 재귀호출
				dfs(nr, nc, i);
			}
		}
		//visited 방문표시 해제
		visited[r][c]=false;
		//set 현재노드 제거
		list.remove(map[r][c]);
		
	}

}
