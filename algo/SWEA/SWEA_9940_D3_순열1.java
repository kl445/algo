package algo.hw0514;

import java.util.Scanner;

public class SWEA_9940_D3_순열1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int Tc = sc.nextInt();

		for (int tc = 0; tc < Tc; tc++) {

			int N = sc.nextInt();
			int map[] = new int[N + 1];
			boolean visited[] = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++) {
				map[i] = sc.nextInt();

				visited[map[i]] = true;
			}

			boolean flag = true;
			for (int i = 1; i < visited.length; i++) {
				if (visited[i] == false) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("#" + (tc + 1) + " Yes");

			} else {
				System.out.println("#" + (tc + 1) + " No");
			}

		}
	}

}
