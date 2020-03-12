package algo.hw0227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1808_D4_지희의고장난계산기2 {

	static int X;
	static int min;
	static boolean[] btn;
	static int[] memo;
	static int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

			min = Integer.MAX_VALUE;

			// 입력
			btn = new boolean[10];
			for (int j = 0; j < 10; j++) {
				if (sc.nextInt() == 1) {
					btn[j] = true;
				}
			}
		
			X = sc.nextInt();
			size=(int)Math.sqrt(X);
			memo=new int[size];
			
			find(X,0);
			
			
			
			
			
			if (min == Integer.MAX_VALUE) {
				min = -1;
			}
			System.out.printf("#%d %d\n", i, min);

		}
	}
	private static int find(int x, int cnt) {
		//base case ->종료조건
		if(x<size && memo[x]!=0) {
			return memo[x];
		}
		if(isMake(x+"")) {
			// x값이 주어진 모든 수로 누를 수 있는지 검사, x길이를 리턴
			int count=len(x)+1;
			if(cnt==0) {
				min=count;	//계산버튼을 위해 1 더하기;
			}
			if(x<size) {
				memo[x]=count;
			}
			return count;
		}
		//처리
		// res의 값을 -1로 초기화
		int res=-1;
		//2~제곱근 까지반복
		for (int i = 2,end=(int)Math.sqrt(x)+1; i < end; i++) {
			//i는 x의 약수, 모든 수로 누를 수 있는지 검사
			if(x%i==0 && isMake(i+"")) {
				//i의 길이를 구하고 
				int len1=len(i)+1;// num1+ *버튼
				//몫이 x의 약수, 모든 수로 누를 수 있는지 -> 재귀 호출
				int len2=find(x/i,cnt+1);
				//몫이 -1이 아니면 -> x약수, 누를 수 있음
				if(len2>-1) {
					//i의 길이와 몫의 길이+ *= 
					res=len1+len2;
					if(res<min && x==X) {
						min=res;
					}
				}
			
			}
			
		}
		if(x<size) {
			memo[x]=res;
		}
		return res;
		//결과를 min과 비교
	}
	private static int len(int x) {
		return (int)Math.log10(x)+1;
	}

	private static boolean isMake(String x) {
		for (char c : x.toCharArray()) {
			if(!btn[c-'0']) {
				return false;
			}
		}
		return true;
	}

}
