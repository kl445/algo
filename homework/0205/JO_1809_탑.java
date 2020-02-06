package algo.hw0201;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class JO_1809_탑 {

	// 재귀
public static void building(int[] array, int[] answer, int end, int max, int index) {

		if (end == array.length) {

			return;

		} 
		
		if(max<=array[end]){
			max=array[end];
			answer[end]=0;
			index=end;
			
		}
		else {
		

			for (int j = end; j >= index; j--) {

				if (array[j] > array[end]) {

					answer[end] = j + 1;

					max = array[j];

					index = j;

					break;

				} else {

				}

			}

			

		}
		System.out.print(answer[end] + " ");

		building(array, answer, end + 1, max, index);

	}

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
//		int[] answer = new int[n];
		int answer = 0;
		Stack<Integer> sizest = new Stack<>();
		Stack<Integer> indexst = new Stack<>();

		for (int i = 0; i < n; i++) {
			int token = sc.nextInt();
			
			if (sizest.isEmpty()) {
				answer=0;
//				answer[i] = 0;
			} else {
				while (!sizest.isEmpty()) {
					if (sizest.peek() < token) {
						sizest.pop();
						indexst.pop();
						if(sizest.isEmpty()) {
//							answer[i]=0;
							answer=0;
						}
					} else {
//						answer[i] = indexst.peek() + 1;
						answer = indexst.peek() + 1;
						break;
					}
				}
				
			}
			sizest.push(token);
			indexst.push(i);

//			System.out.print(answer[i] + " ");
			System.out.print(answer + " ");
		}

//		building(array,answer,0,0,0);

	}

}
