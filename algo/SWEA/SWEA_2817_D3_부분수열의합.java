package algo_ad.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class SWEA_2817_D3_부분수열의합 {

	public static int cnt=0;
	
	public static void isOk(LinkedList<Integer> list,int k) {
		
		int sum=0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
			if(sum>k) {
				break;
			}
		}
		if(sum==k) {
			cnt++;
		}
		
	}
	public static void set(int r, int c, boolean[] visited, boolean[] check,int[] array, int k) {
		
		if(r==c) {
			LinkedList<Integer> list= new LinkedList<>();
			int sum=0;
			boolean flag=true;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					sum+=array[i];
					if(sum>k) {
						flag=false;
						break;
					}
				}
			}
			if(flag && sum==k) {
				cnt++;
			}
//			isOk(list, k);
			
			
			
		}
		else {
			for (int i = 0; i < check.length; i++) {
				visited[c]=check[i];
				set(r, c+1, visited, check,array,k);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Scanner sc =new Scanner(System.in);
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk= new StringTokenizer(bf.readLine());
	
//		int  tc=sc.nextInt();
		int  tc=Integer.parseInt(tk.nextToken());
		
		for (int i =1; i <=tc; i++) {
			
//			StringBuilder sb= new StringBuilder();
//			sb.append("#").append(i).append(" ");
			
			
//			int n= sc.nextInt();
//			int k=sc.nextInt();
			tk= new StringTokenizer(bf.readLine());
			int n= Integer.parseInt(tk.nextToken());
			int k=Integer.parseInt(tk.nextToken());
			
			int[] array= new int[n];
			tk= new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				
				array[j]=Integer.parseInt(tk.nextToken());
//				array[j]=sc.nextInt();
			}
			
			
			
			boolean[] check= {true,false};
			
			cnt=0;
			
			set(n, 0, new boolean[n], check, array,k);
//			sb.append(cnt);
			System.out.printf("#%d %d\n",i,cnt);
//			System.out.printf(sb.toString());
			
			
		}
		
		
		
	}

}
