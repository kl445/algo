package algo.hw0514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class SWEA_5643_D4_키순서 {

	static int N,M;
	static int[] cnt;
	
	static List<Pos> list;
	
	static class Pos{
		int me;
		List<Integer> parent;
		List<Integer> son;
		
		public Pos(int me) {
			super();
			this.me = me;
			this.parent=new ArrayList<Integer>();
			this.son=new ArrayList<Integer>();
		}
		
		
		
	}
	//상위 객체 개수 구하기
	static int get_parent(Pos pos ,boolean[] visited) {
		int cnt=1;
		
		if(pos.parent.size()==0) {
			return 1;
		}
		
		for (int i = 0; i < pos.parent.size(); i++) {
			int now=pos.parent.get(i);
			if(!visited[now]) {
				visited[now]=true;
				cnt+=get_parent(list.get(now), visited);		
			}
		}
		return cnt;
	}
	//하위 객체 개수 구하기
	static int get_son(Pos pos ,boolean[] visited) {
		int cnt=1;
		
		if(pos.son.size()==0) {
			return 1;
		}
		
		for (int i = 0; i < pos.son.size(); i++) {
			int now=pos.son.get(i);
			if(!visited[now]) {
				visited[now]=true;
				cnt+=get_son(list.get(now), visited);		
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int TC=sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			N=sc.nextInt();
			M=sc.nextInt();
			cnt=new int[N+1];
			
			list=new ArrayList<>();
			for (int j = 0; j < N+1; j++) {
				list.add(new Pos(j));
			}
			
			for (int i = 0; i < M; i++) {
				int num1=sc.nextInt();
				int num2=sc.nextInt();
				
				list.get(num1).son.add(num2);
				list.get(num2).parent.add(num1);
				
				
			}
			
			
			int res=0;
			for (int i = 1; i < list.size(); i++) {
				
				cnt[i]+=get_parent(list.get(i), new boolean[N+1]);
				cnt[i]+=get_son(list.get(i), new boolean[N+1]);
				
				//cnt는 자신을 포함한 상위객체+자신을 포함한 하위객체 이기 때문에 
				//자신이 2번 중복되었으므로 1감소가 필요
				//그 결과 전체 인원수와 일치한다면 자신의 위치찾기 가능
				if(cnt[i]-1==N) {
					res++;
				}
			}
			
//			System.out.println(Arrays.toString(cnt));
			sb.append(res);
			System.out.println(sb.toString());
			
			
		}
		
		
	}

}
