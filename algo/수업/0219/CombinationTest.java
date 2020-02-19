package algo_ad.day1;

import java.util.Arrays;

public class CombinationTest {

	private static char[] chars= {'A','B','C','D'};
	
	
	public static void main(String[] args) {
		//chars에서 3개를 뽑는 조합 만들기
		
		int r=3;
		
		//순열코드 재활용
//		makeCombination(r,new char[r],0);
		makeComvination2(chars.length, r, new char[r]);
		//조합의 정의 활용
	}
	
	
	//조합의 정의 활용 nCr= (n-1)C(r-1)+(n-1)Cr
	public static void makeComvination2(int n, int r, char[] temp) {
		
		
		//base case
		if(r==0) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		else if(n<r) {
			return;
		}
		else {
			temp[r-1]=chars[n-1];  //n,r은 모두 개수, 우리가 사용하는건 idx(0부터시작)
			makeComvination2(n-1, r-1, temp);//요소를 선택했을 때
			makeComvination2(n-1, r, temp);//요소를 선택하지 않았을 때
			
		}
	}
	
	
	

	//순열코드를 재활용한 조합
		public static void makeCombination(int r, char[] temp, int start) {
			
			//베이스 케이스
			
			if(r==0) {
				System.out.println("visited: "+Arrays.toString(temp));
				return;
			}
			else {
				for (int i = start; i < chars.length; i++) {
						temp[r-1]=chars[i];
						makeCombination(r-1, temp, i+1);
					
				}
				
			}
				
			
			
		}
}
