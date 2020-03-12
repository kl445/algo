package algo.hw0227;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7208_D4_지도칠하기 {
	public static int color=0;
	public static int color_array[]= {1,2,3,4};
	
	public static void ans(int[][] graph,int []country,int n,int[] temp) {
		int[] copy_array=new int[n];
		for (int i = 0; i < copy_array.length; i++) {
			copy_array[i]=country[i];
		}
		
		int thisColor=0;
		for (int j = 0; j < temp.length-1; j++) {	
			for (int k = 0; k < graph.length; k++) {
				
				if(graph[temp[j]][k]==1) {
					
					if(copy_array[temp[j]]==copy_array[k]) {
						thisColor++;
//						graph[k][j]=0;
						copy_array[temp[j]]=n++;
					}
				}
			}
		}
		color=Math.min(color, thisColor);
	}
	
	public static void dfs(int r, int c,int[] temp, int graph[][],int country[],int n,boolean[] visited){
		
		if(r==c) {
			ans(graph, country, n, temp);
			
		}
		else {
			
			for (int i = 0; i <n; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[c]=i;
					dfs(r, c+1,temp, graph, country, n, visited);
					visited[i]=false;
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			
			int n=sc.nextInt();
			int country[]=new int[n];
			
			int graph[][]=new int[n][n];
			
			for (int j = 0; j < country.length; j++) {
				country[j]=sc.nextInt();	
			}
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph.length; k++) {
					graph[j][k]=sc.nextInt();
				}
			}
			color=Integer.MAX_VALUE;
			dfs(n, 0, new int[n], graph, country, n, new boolean[n]);
			
//			for (int j = 0; j < graph.length-1; j++) {	
//				for (int k = 0; k < graph.length; k++) {
//					if(graph[j][k]==1) {
//						
//						if(country[j]==country[k]) {
//							color++;
////							graph[k][j]=0;
//							country[j]=n++;
//						}
//					}
//				}
//			}
//			color=Math.min(color, color);
			
			System.out.printf("#%d %d\n",i,color);
			
			
		}
	}

}
