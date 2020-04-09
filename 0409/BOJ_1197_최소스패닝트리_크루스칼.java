package algo.hw0409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class BOJ_1197_최소스패닝트리_크루스칼 {

	
	static class cruscal implements Comparable<cruscal>{
		
		int v1;
		int v2;
		int m;
		@Override
		public String toString() {
			return "cruscal [v1=" + v1 + ", v2=" + v2 + ", m=" + m + "]";
		}

		public cruscal(int v1, int v2, int m) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.m = m;
		}

		@Override
		public int compareTo(cruscal o) {
			
			if(this.m<o.m)
				return -1;
			else if(this.m==o.m)
				return 0;
			else
				return 1;
		}

	}
	
	static int V, E;

	static int[] parents;
	static int[] rank;

	static void setAll() {
		
		for (int i = 0; i < V+1; i++) {
			parents[i]=i;
		}
	}
	
	static int findParent(int n) {
		
		if(n==parents[n])	return n;
		
		else {
			return parents[n]=findParent(parents[n]);
			
		}
	}
	
	static void union(int n1, int n2) {
	
		
//		parents[n1]=n2;
		
		if(rank[n1]> rank[n2]) {
			parents[n2]=n1;
		}else {
			parents[n1]=n2;
			
			if(rank[n1]==rank[n2]) {
				rank[n2]++;
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		V=sc.nextInt();
		E=sc.nextInt();
		
		parents=new int[V+1];
		rank=new int[V+1];
		setAll();
		
		ArrayList<cruscal> list= new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			cruscal temp= new cruscal(sc.nextInt(), sc.nextInt(), sc.nextInt());
			list.add(temp);
		}
		
		Collections.sort(list);
		
		int res=0;
		int cnt=0;
		for (int i = 0; i < list.size(); i++) {
			cruscal temp=list.get(i);
			int temp_n1=findParent(temp.v1);
			int temp_n2=findParent(temp.v2);
			if(temp_n1==temp_n2) continue;
			
			union(temp_n1, temp_n2);
			res +=temp.m;
			if(cnt==V-1) break;
		}

		System.out.println(res);

	}

}
