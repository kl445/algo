package algo_basic.day1;

import java.util.Arrays;

public class P41_BubbleSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {85,14,58,32,47,91,63,25,78,35,84,30};
		int temp=0;
		
		for(int i=0; i<array.length;i++) {
	
			
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
		
			}
		}
		System.out.println(Arrays.toString(array));
	
	

	}

}
