package algo.hw0402;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_6719_D4_성수의프로그래밍강좌시청 {

	static int N,K;
	static int array[];
	static double ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		int TC= sc.nextInt();
		
		//케이스 세팅
		for (int t = 1; t <= TC; t++) {
			
			//입력
			N=sc.nextInt();
			K=sc.nextInt();
			ans=0;
			array=new int[N];
			
			for (int i = 0; i < N; i++) {
				array[i]=sc.nextInt();
			}
			
			
			//강좌 배열 array를 오름차순으로 정렬 
			Arrays.sort(array);
			Stack<Integer> st= new Stack<>();
			
			//배열의 뒤에서 부터 k개까지의 강좌를 stack에 삽입
			for (int i = array.length-1,j=0; j<K; i--,j++) {
				st.push(array[i]);
			}
			
			//stack이 빌때까지 실력계산
			while(!st.isEmpty()) {
				ans=(ans+st.pop())/2;
			}
			System.out.println("#"+t+" "+ans);
			

			
			
			
			
			
			
			
			
			
		}
	}

}
