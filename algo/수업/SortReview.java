package algo_day3;

import java.util.Arrays;
import java.util.Comparator;

public class SortReview {

	public static void main(String[] args) {
		String[] src = { "dream", "is", "come", "true" };

		Arrays.sort(src);

		System.out.println(Arrays.toString(src));
		// 글자수를 오름차순으로 정렬;

		Arrays.sort(src, new Comparator<String>() {
				
			@Override
			public int compare(String o1, String o2) {
				//인테이져쓰는이유 오버플로우를 막는 번거로운 작업을 방지
				
				Integer len1= o1.length();
				Integer len2= o2.length();
				
				//길이가 같은경우 알파벳의 내림차순으로 정렬
				if(len1==len2) {
					return o1.compareTo(o2)*-1;
				}
				else {
					return len1.compareTo(len2);
				}				
			}
		});
		System.out.println(Arrays.toString(src));

		int[][] arr = { { 1, 2, 3 }, { 7, 8, 9 }, { 4, 5, 6 } };

		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				
				Integer len1 = 0;
				Integer len2 = 0;
				for(int val:o1) {
					len1+=val;
				}
				for(int val:o2) {
					len2+=val;
				}

				return len1.compareTo(len2);

			}
		});
		
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}

	}
}