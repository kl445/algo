package algo_day5;

import java.util.Arrays;

public class PowerSet {

	static char[] src= {'A','B','C'};
	
	
	static boolean[] child= {true,false};
	//각 원소의 포함 여부를 저장
	static boolean[] status=new boolean[src.length];
	
	
	public static void dfs(int n,int r) {
		if(r==n) {
			System.out.print(Arrays.toString(status)+": ");
			for (int i = 0; i < status.length; i++) {
				if(status[i]) {
					System.out.print(src[i]+" ");
				}
			}
			System.out.println();
		}
		else {
			for (int i = 0; i < child.length; i++) {
				status[r]=child[i];
				dfs(n,r+1);
			}
		}
		
	}
	public static void pSet(char[] temp, int current, int n) {
		
		if(n==current) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for(int i=0;i<src.length;i++) {
				if(status[i])
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		dfs(3,0);

	}

}
