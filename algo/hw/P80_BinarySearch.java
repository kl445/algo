package algo.hw;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class P80_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Random rand= new Random();
		
		int[] arr = {2,7,4,9,11,23,19};
//		int[] arr = new int[10];
		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i]=rand.nextInt(100)+1;
//		}
		
		System.out.println("검색할 숫자 입력:");
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int key=sc.nextInt();
		binarySearch(0, arr.length-1, arr.length/2, arr, key);
		
		
	}
	
	public static void binarySearch(int start, int end, int k,int[] arr,int key) {
		
		if(start>=end) {
			if(arr[k]==key) {
				System.out.printf("%d는 배열의 %d번 인덱스에 있습니다\n",key,k);
			}
			else {
			System.out.printf("%d는 배열내부에 없습니다.\n",key);
			}
		}
		else {
			
		
		if(arr[k]==key) {
			System.out.printf("%d는 배열의 %d번 인덱스에 있습니다\n",key,k);
		}
		else if(arr[k]>key) {
			binarySearch(start, k-1, (start+k-1)/2, arr, key);
		}
		else if(arr[k]<key) {
			binarySearch(k+1, end, (end+k+1)/2, arr, key);
		}
		}
		
	}

}
