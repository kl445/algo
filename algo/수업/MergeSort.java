package algo_day7;

import java.util.Arrays;

public class MergeSort {

	
	public static void mergeSum(int[] arr, int start,int mid,int end) {
		//병합정렬의 단점 -추가 메모리 사용
		
		int[] temp=new int[arr.length];
		
		//왼쪽 기점
		int li=start;
		
		//오른쪽 기점
		int ri=mid+1;
		
		//임시배열의 기점
		int ti=start;;
	
		//양쪽 모두에 값있다면 한명씩 나옴
		while(li<=mid && ri<=end) {
			if(arr[li]<=arr[ri]) {
				temp[ti++]=arr[li++];
			}
			else {
				temp[ti++]=arr[ri++];
			}
		}
		
		//어느한쪽만 끝남
		while(li<=mid) {
			temp[ti++]=arr[li++];
		}
		while(ri<=end) {
			temp[ti++]=arr[ri++];
		}
		//temp를 다시 arr로
		
		for (int i = start; i <=end; i++) {
			arr[i]=temp[i];
		}
	}
	
	public static void merge(int[] arr,int start,int end) {
		//종료조건
		
		if(start==end) {
			return;
		}
		
		//쪼개기
		int midel=(start+end)/2;
		merge(arr, start, midel);
		merge(arr, midel+1, end);
		
		//정렬 및 합치기
		
		mergeSum(arr,start,midel,end);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[]= {69,10,30,2,16,8,31,72};
		
		merge(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	

	

}
