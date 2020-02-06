package algo_day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidates {

	private static int[] array= {1,2,3,4,5,6,7,8,9};
	private static boolean[] visited=new boolean [array.length];
//	public static List<Integer> list= new ArrayList<>();
//	private static int[] temp= new int[array.length];
	
	public static void cadni(int r, int c,int temp[]) {
		
		if(r==c) {
			
			System.out.println(Arrays.toString(temp));
			return;
			
		}
		
		for(int i=0; i<array.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				temp[i]=array[i];
				cadni(r,c+1,temp);
				visited[i]=false;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cadni(9,0,new int[array.length]);
		
	}

}
