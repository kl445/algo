package algo_ad.day1;

import java.util.Arrays;

public class PermutationTest {

	
	private static char[] chars= {'A','B','C','D'};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//for문을 통해 순열 구하기
//		makePermutationIter();
		
		//visitied순열
//		makePermutationVisited(3, new char[3], new boolean[chars.length]);

		//swap순열
//		makePermutationSwap(3, 0);
		
		//nexPerm
		makePermutationNP();
		
		
	}
	
	public static void makePermutationNP(){
		//nextPermutation은 정렬 후 사용해여함
		Arrays.sort(chars);
		do {
			System.out.println(Arrays.toString(chars));
		}while(nextPermutation());
		
	}
	
	//nextPermutation
	public static boolean nextPermutation() {
	
		//step1. i찾기
		int i;
		for ( i = chars.length-2; i >=0; i--) {
			if(chars[i]<chars[i+1]) {
				break;
			}
		}
		// 이미 마지막 순열인 경우는 만족하는 i가 없다
		if(i<0) {
			return false;
		}
		
		//step 2 j찾기
		
		int j;
		for (j = chars.length-1; j>=0; j--) {
			if(chars[j]>chars[i]) {
				break;
			}
			
		}
		//step 3 swap
		swap(i,j);
		
		//step 4 reverse
		for (int a =i+1,b=chars.length-1; a <b; a++,b--) {
			swap(a,b);
			
		}
		return true;
	}
	
	//swap 순열   r: 뽑을 요소의 개수  depth:깊이
	public static void makePermutationSwap(int r, int depth) {
	
			if(depth==r) {
				System.out.println("swap: "+ Arrays.toString(Arrays.copyOfRange(chars, 0, r)));
				return;
			}
			else {
				for (int i = depth; i < chars.length; i++) {
					swap(depth,i);
					makePermutationSwap(r, depth+1);
					swap(i,depth);
				}
			}
		
	}	
	public static void swap(int a, int b) {
		char temp=chars[a];
		chars[a]=chars[b];
		chars[b]=temp;
	}
	
	
	//vistited 순열
	public static void makePermutationVisited(int r, char[] temp, boolean[] visited) {
		
		//베이스 케이스
		
		if(r==0) {
			System.out.println("visited: "+Arrays.toString(temp));
			return;
		}
		else {
			for (int i = 0; i < chars.length; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[r-1]=chars[i];
					makePermutationVisited(r-1, temp, visited);
					visited[i]=false;
				}
				
			}
			
		}
			
		
		
	}

		
	//for문 순열
		public static void makePermutationIter() {
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				if(i==j) {	//순열은 중복 불가능
					continue;
				}
				for (int k = 0; k < chars.length; k++) {
					if(i==k || j==k) {
						continue;
					}
					System.out.printf("반복문: %c, %c, %c, %n",chars[i],chars[j],chars[k]);
				}
			}
		}
		
	}

}
