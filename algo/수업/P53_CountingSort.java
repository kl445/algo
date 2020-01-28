package algo_basic.day1;

import java.util.Arrays;

public class P53_CountingSort {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,4,5,2,1,3,4,1,1,2,5,4,3};
		int[] b=new int[array.length];
		int max=0;
		
		for(int i=0; i<array.length;i++) {
			max=Math.max(max, array[i]);
		}
		
		int[] c=new int[max+1];
		
		for (int i = 0; i < array.length; i++) {
			c[array[i]]++;
		}
		for (int i = 0; i < c.length-1; i++) {
			c[i+1]=c[i]+c[i+1];
			
		}
		int[] temp=new int[array.length];
		for (int i = 0;  i <array.length; i++) {
			int num= array[i];
			int idx= c[num]-1;
			temp[idx]=num;
			c[num]--;
			
		}
		System.out.println(Arrays.toString(temp));
		

	}
	
//	public static int max(int[] array) {
//		int max=0;
//		for(int i=0; i<array.length;i++) {
//			if(max<array[i]) {
//				max=array[i];
//			}
//		}
//		return max;
//	}
	

}
