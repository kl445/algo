package algo.hw0227;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1808_D4_지희의고장난계산기 {

	static int X;
	static int min;
	static boolean btn[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			//min값 초기화
			min=Integer.MAX_VALUE;
			
			//입력
			btn=new boolean[10];
			for (int j = 0; j < 10; j++) {
				if(sc.nextInt()==1) {
					btn[j]=true;
				}
			}
			
			X=sc.nextInt();
		
			//btn 배열 (boolean)
			
			//처리 dfs 재귀함수
			find(X,0);
			
			//base case ->종료조건
			// x값이 주어진 모든 수로 누를 수 있는지 검사, x길이를 리턴
			
			//처리
			// res의 값을 -1로 초기화
			//2~제곱근 까지반복
				//i는 x의 약수, 모든 수로 누를 수 있는지 검사
					//i의 길이를 구하고 
						//몫이 x의 약수, 모든 수로 누를 수 있는지 -> 재귀 호출
			//몫이 -1이 아니면 -> x약수, 누를 수 있음
				//i의 길이와 몫의 길이+ *= 
			//결과를 min과 비교
			
			
			//출력
			if (min == Integer.MAX_VALUE) {
				min = -1;
			}
			System.out.printf("#%d %d\n", i, min);

		}
	}

	private static int find(int x, int cnt) {
		//base case ->종료조건
		
		if(isMake(x+"")) {
			// x값이 주어진 모든 수로 누를 수 있는지 검사, x길이를 리턴
			
			if(cnt==0) {
				min=len(x)+1;	//계산버튼을 위해 1 더하기;
			}
			
			return len(x)+1;
			
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
