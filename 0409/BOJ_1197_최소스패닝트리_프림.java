package algo.hw0409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리_프림 {

	static class Prim {
		int n2;
		int m;
		
		
		public Prim(int n2, int m) {
			super();
			this.n2 = n2;
			this.m = m;
		}


		@Override
		public String toString() {
			return "Prim [n2=" + n2 + ", m=" + m + "]";
		}
		
		
	}
	static int V, E;

	static int[] key, p;
	
	static ArrayList<Prim> list[];
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		V=sc.nextInt();
		E=sc.nextInt();
		
		
		key= new int[V+1];
		p= new int [V+1];
		
		//인접 리스트 및 key 초기화
		boolean[] visitied=new boolean[V+1];
		list=new ArrayList[V+1];
		for (int i = 0; i <V+1 ; i++) {
			list[i]=new ArrayList<Prim>();
			key[i]=Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) {
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			int m=sc.nextInt();
			
			list[n1].add(new Prim(n2, m));
			list[n2].add(new Prim(n1, m));
			
		}
		
		
		//시작지점을 정점 1로 선택
		key[1]=0;
		p[1]=1;
		
		
		//최소 간선의 수만큼 진행
		for (int i = 1; i < V; i++) {
			int min=Integer.MAX_VALUE;
			
			int index=-1;
			// 현재 가중치들 중에 최소값을 찾고 해당 정점을 index로 삼음
			for (int k = 1; k < V+1; k++) {
				if(!visitied[k] && key[k]<min) {
					index=k;
					min=key[k];
	
				}
			}
			visitied[index]=true;
			
			//index에서 아직 방문하지 않은 정점들에 대한 가중치가  도착할 정점의 기존 가중치 값보다  작다면 이를 갱신함
			for (int k=0; k < list[index].size(); k++) {
				int n2=list[index].get(k).n2;
				int m=list[index].get(k).m;
				
				if(!visitied[n2] && m!=0 && key[n2]>m) {
					p[n2]=index;
					key[n2]=m;
				}
				
			}
			
		}
		int res=0;
		for (int i = 1; i < V+1; i++) {
			res+=key[i];
		}

		System.out.println(res);
		
		
		
		
	}

}
