package algo_basic.day2;

public class ArrTest {

	public static void main(String[] args) {
		int a = 10;
		int[] arr1 = new int[4];
		int[][] arr2 = new int[3][5];

		// 행순회
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
		// 열순회
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();

		// 행순회
		for (int i = 0; i < arr.length; i++) {
			int len = arr.length;
			for (int j = 0; j < len; j++) {
				if (i % 2 == 0) {
					System.out.print(arr[i][j]);
				} else {
					System.out.print(arr[i][len - 1 - j]);
				}
			}
		}
	}

	public static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

}
