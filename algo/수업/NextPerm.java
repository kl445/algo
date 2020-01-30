package algo_day4;

import java.util.Arrays;

public class NextPerm {

	private static int[] nums= {2,4,3,1};

	public static void main(String[] args) {
		
//		nextPerm(nums);
		Arrays.sort(nums);
		do {
		nextPerm(nums);
		}while(nextPerm(nums));
	}
	
	//nums의 다음 순열은?
//	public static boolean nextPermIn(int num) {
//		
//	}
	
	public static boolean nextPerm(int[] array) {
		int i=-1;
		int j=0;
		for(int a=array.length-2;a>=0;a--) {
			if(array[a]<array[a+1]) {
				i=a;
				break;
			}
		}
//		System.out.println("I:"+i);
		
		if(i!=-1) {
		for(int a=array.length-1;a>0;a--) {
			if(array[i]<array[a]){
				j=a;
				break;
			}
		}
//		System.out.println("J:"+j);
		
		int temp=array[j];
		array[j]=array[i];
		array[i]=temp;
		
		for(int a=i+1, b=array.length;a<b;a++,b--) {
			temp=array[a];
			array[a]=array[array.length-a];
			array[array.length-a]=temp;
		}
		System.out.println(Arrays.toString(array));
		return true;
		}
		else {
//			System.out.println("마지막 순열");
			return false;
		}
		
		
	}
	public static void swap(int num1,int num2) {
		
	}

}
