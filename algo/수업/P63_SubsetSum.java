package algo_day3;

import java.util.ArrayList;
import java.util.List;

public class P63_SubsetSum {
//	public static int[] arr= {1,5,-8,3,4,-9,2};
	public static int[] arr= {2,5,4,1,-7};
	
	public static void main(String[] args) {
			
		boolean ans=false;
		
		
		for(int i=1; i<(1<<arr.length);i++) {
			int sum=0;
			List<Integer> subset= new ArrayList<>();
			for(int j=0; j<arr.length;j++) {
				if((i&(1<<j))>0) {
					sum +=arr[j];
					subset.add(arr[j]);
				}
			}
			if(sum==0) {
				ans=true;
				
			}
		}
		
		if(ans) {
			System.out.println("참");
		}
		else{
			System.out.println("거짓");
		}

	}

}
