package algo.hw0513;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252_줄세우기 {

	static List<List<Integer>> list;
	static int degree[];

	static int N,M;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		degree=new int[N+1];
		
		list=new ArrayList<>();
		Queue<Integer> q=new LinkedList<>();
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
			
		for (int i = 0; i < M; i++) {
			
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			
			
			list.get(num1).add(num2);
			degree[num2]++;
			
			
		
		}
		
		
		for (int i = 1; i < N+1; i++) {
			if(degree[i]==0) {
				q.offer(i);
			}
		}
		
		ArrayList<Integer> res=new ArrayList<>();
		
		while(!q.isEmpty()) {
			
			int now=q.poll();
			
			res.add(now);
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int temp=list.get(now).get(i);
				
				degree[temp]--;
				
				if(degree[temp]==0) {
					q.offer(temp);
				}
			}
			
			
		}
		
		for (Integer i : res) {
			System.out.print(i+" ");
		}
		
	}


}
