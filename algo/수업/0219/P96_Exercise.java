package algo_ad.day1;

import java.util.ArrayList;

public class P96_Exercise {

	private static int[] array= {-1,3,-9,6,7,1,5,4,-2};
	private static int maxCombi=Integer.MIN_VALUE;
	private static int maxPerm=Integer.MIN_VALUE;
	
	
	public static void powerSet(int r, int c, boolean visited[], boolean check[]) {
		
		if(c==r) {
			ArrayList<Integer> list= new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					list.add(array[i]);
//					System.out.println(array[i]);
				}
			}
			if(tempSum(list)==0) {
				System.out.println(list.toString());
			}
		}
		else {
			for (int i = 0; i < check.length; i++) {
				visited[c]=check[i];
				powerSet(r,c+1,visited,check);
			}
		}
		
	}
	
	public static int tempSum(int[] temp) {
		
		int sum=0;
		for (int i = 0; i < temp.length; i++) {
			sum+=temp[i];
		}
		return sum;
	}
	public static int tempSum(ArrayList<Integer> temp) {
		
		int sum=0;
		for (int i = 0; i < temp.size(); i++) {
			sum+=temp.get(i);
		}
		return sum;
	}
	
	public static void combi(int r, int c, int[] temp,int start) {
		
		if(r==c) {
			maxCombi=Math.max(tempSum(temp), maxCombi);
			return;
		}
		else {
			for (int i =start; i < array.length; i++) {
				temp[c]=array[i];
				combi(r, c+1, temp, i+1);
			}
		}
		
	}
	
	public static void perm(int r, int c, boolean visited[], int temp[] ) {
		if(r==c) {
			
			int sum= temp[0]*10+temp[1];
			maxPerm=Math.max(maxPerm, sum);
			
			return;
		}
		else {
			for (int i = 0; i < array.length; i++) {
				if(!visited[i] && array[i]>=0) {
					visited[i]=true;
					temp[c]=array[i];
					perm(r, c+1, visited, temp);
					visited[i]=false;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		combi(2, 0, new int[2], 0);
		System.out.println(maxCombi);
		 
		boolean[] check= {true,false};
		powerSet(array.length, 0, new boolean[array.length],check);
		
		perm(2	,0 , new boolean[array.length], new int[array.length]);
		System.out.println(maxPerm);

	}

}
