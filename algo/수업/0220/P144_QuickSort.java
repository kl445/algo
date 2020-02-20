package algo_ad.day2;

import java.util.Arrays;

public class P144_QuickSort {

	private static int[] src= {3,2,4,6,9,1,8,7,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(src));
		sort(src, 0, src.length-1);
		
		System.out.println(Arrays.toString(src));
		
	}
	
	public static void swap(int[] arr, int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static int partition(int[] arr, int begin, int end) {
		
		int left=begin;
		int right=end;
		int p= left; //파티션 위치 - 그냥 임의의 위치를 잡음
		
		
		while(left<right) {
			while(arr[left]<=arr[p]) {
				if(left>=end) {
					break;
				}
				left++;
			}
			while(arr[right]>=arr[p]) {
				if(right<=begin) {
					break;
				}
				right--;
			}
			
			if(left<right) {
				swap(arr,left,right);
			}
		}//while {피봇}{작은}{큰}
		
		//피봇을 작은녀석의 마지막 자리(right)와 스왑
		swap(arr,p,right);
		//피봇 위치 리턴
		return right;
	}
	public static void sort(int[]arr, int begin,int end) {
		if(begin<end) {
			//정렬할 대상이 있다면 쪼개기
			//s는 각 그룹의 경계값, 이미 정렬 완료된 위치
			int s=partition(arr,begin,end);
			
			sort(arr,begin,s-1); //좌측정렬
			sort(arr,s+1,end); //우측 정력
			
			
		}
	}

}
