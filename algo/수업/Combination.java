package algo_day7;

import java.util.Arrays;

public class Combination {

	public static char[] chars = { 'A', 'B', 'C', 'D' };

	public static void main(String[] args) {
		// 4개의 원소에서 2개를 선택하는 순열을 구하시오.

		makePermutaion(2, 0, new char[2], new boolean[chars.length]);
		System.out.println();
		makeCombination(2, 0, new char[2],0);

	}

	public static void makeCombination(int r, int c, char[] temp,int start) {

//		//for문 조합
//		for (int i = 0; i < chars.length; i++) {
//			for (int j = i+1; j < chars.length; j++) {
//				System.out.println(chars[i]+" : "+chars[j] );
//			}
//		}
//		System.out.println();
		
		//재귀 조합
		
		if (r == c) {

			System.out.println(Arrays.toString(temp));
			return;
		} else {

			for (int i = start; i < chars.length; i++) {

				
					
					temp[c] = chars[i];
					makeCombination(r, c + 1, temp,i+1 );
					
				
			}
		}
		
	}

	public static void makePermutaion(int r, int c, char[] temp, boolean visited[]) {

		if (r == c) {

			System.out.println(Arrays.toString(temp));
			return;
		} else {

			for (int i = 0; i < chars.length; i++) {

				if (!visited[i]) {
					visited[i] = true;
					temp[c] = chars[i];
					makePermutaion(r, c + 1, temp, visited);
					visited[i] = false;
				}

			}
		}

	}

}
