package algo.hw0311;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1251_D4_하나로3 {

	//i=출발하는 섬 j= 도착하는 섬 money=다리건설비용
	static class Bridge{
		int i;
		int j;
		double money;
		
		public Bridge(int i, int j, double money) {
			super();
			this.i = i;
			this.j = j;
			this.money = money;
		}

		@Override
		public String toString() {
			return "Bridge [i=" + i + ", j=" + j + ", money=" + money + "]";
		}	
	}
	
	static int N;
	static double E;
	static int[] X, Y, map, rank;
	
	

	static void set() {
		for (int i = 0; i < map.length; i++) {
			map[i]=i;
		}
	}
	static int find(int n) {
		
		if(n==map[n]) return n;
		else {
			map[n]=find(map[n]);
			return map[n];
		}
	}
	static void union(int n1, int n2) {
		
		int temp_n1=find(n1);
		int temp_n2=find(n2);
		
		if(rank[temp_n1]>rank[temp_n2]) {
			map[temp_n2]=temp_n1;
		}
		else {
			map[temp_n1]=temp_n2;
			if(rank[temp_n1]==rank[temp_n2]) {
				rank[temp_n2]++;
			}
		
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t+1).append(" ");
			
			//입력
			N=sc.nextInt();
			X=new int[N];
			Y=new int[N];
			for (int i = 0; i < N; i++) {
				X[i]=sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Y[i]=sc.nextInt();
			}
			
			E=sc.nextDouble();
			map=new int[N];
			set();
			rank=new int[N];
			PriorityQueue<Bridge> list= new PriorityQueue<Bridge>(new Comparator<Bridge>() {

				@Override
				public int compare(Bridge o1, Bridge o2) {
					Double res1=o1.money;
					Double res2=o2.money;
					return res1.compareTo(res2);
				}
			});
			
			//섬들에 대한 모든 간선정보를 우선순위 큐에 삽입
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					double x=Math.pow(Math.abs(X[i]-X[j]),2);
					double y=Math.pow(Math.abs(Y[i]-Y[j]),2);
					list.add(new Bridge(i,j,E*(x+y)));
				}
			}
		
			double min=0;
			int cnt=0;
			
			// 정점-1 만큼의 간선을 뽑을때까지
			while(cnt!=N-1) {
				
				Bridge temp=list.poll();
				int a= find(temp.i);
				int b= find(temp.j);
				
				//그룹이 일치하는지 확인한 후
				if(a==b) continue;
				
				//서로 다른 그룹의 경우 하나의 그룹으로 통합
				union(a, b);
				
				//선택된 간선들에 대한 비용을 합산
				min+=temp.money;
				cnt++;
				if(cnt==N-1) {
					break;
				}
			}
			sb.append(Math.round(min));
			System.out.println(sb.toString());
			
		}
	}

}
