package algo_day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class P367_Exercise {

	public static void insertionSort(int[]arr, int num) {
//		int temp[]=new int[num];
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j >0; j--) {
				
				if(arr[j-1]>arr[j]) {
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
				else {
					break;
				}
			}
		}	
		
	}
	
	public static void insertionSortList(LinkedList<Integer> list, int num) {
	
		for (int i = 1; i < list.size(); i++) {
			
			for (int j = i; j >0; j--) {
				
				if(list.get(j)<list.get(j-1)) {
					list.add(j-1,list.remove(j));
				}
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr= new int[1000];
		
		Random rand= new Random();
		LinkedList<Integer> list =new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=rand.nextInt(1000);
			list.add(arr[i]);
		}
		
		insertionSort(arr,1000);
		insertionSortList(list,1000);
		
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1]) {
				System.out.println("E -index"+i);
			break;	
			}
		}
		System.out.println(list.toString());
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i)>list.get(i+1)) {
				System.out.println("E -index"+i);
				break;	
			}
		}
		
	}

}
