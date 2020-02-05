package algo_day5;

import java.util.Arrays;

public class P246_Execerise {

	public static int[] src= {1,2,3,4,5,6,7,8,9,10};
	
	public static boolean[] set= {true,false};
	public static boolean[] status=new boolean[10];
	
	
	
	public static boolean under10() {
		int sum=0;
		for (int i = 0; i < status.length; i++) {
			if(status[i]==true) {
				sum+=i+1;	
			}
		}
		if(sum>10) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean is10() {
		int sum=0;
		for (int i = 0; i < status.length; i++) {
			if(status[i]==true) {
				sum+=i+1;
			}
		}
		if(sum==10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void pSet(int n, int c) {
		
		if(n==c) {
			if(is10()) {
				
				for (int i = 0; i < status.length; i++) {
					if(status[i]==true) {
						System.out.print((i+1)+" ");
					}
				}
				System.out.println();
			
			}
		}
		else {
			
			for(int i=0; i<set.length;i++) {
				status[c]=set[i];
				
				if(under10()) {
					pSet(n,c+1);
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pSet(10,0);
	}

}
