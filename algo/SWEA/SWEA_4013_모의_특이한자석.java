package algo.hw0522;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4013_모의_특이한자석 {

	static int[][] magnet;
	static int K;
	static int[][] quest;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			magnet = new int[4][8];
			K = sc.nextInt();
			quest = new int[K][2];

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < K; i++) {
				quest[i][0] = sc.nextInt() - 1;
				quest[i][1] = sc.nextInt();
			}

			int res = 0;
			for (int q = 0; q < K; q++) {

				move(quest[q][0], quest[q][1], 0);

//				for (int i = 0; i < magnet.length; i++) {
//					System.out.println(Arrays.toString(magnet[i]));
//				}
//				System.out.println();

			}

			for (int i = 0; i < 4; i++) {
				res += magnet[i][0]*(1<<i);
			}

			System.out.println("#" + tc + " " + res);

		}
	}

	private static void move(int idx, int clock_way, int next) {

		int left = magnet[idx][6];
		int right = magnet[idx][2];

		move_one(magnet[idx], clock_way);

		if (next == 0) {

			if (idx == 0) {
				if (right != magnet[idx + 1][6]) {
					move(idx + 1, clock_way * -1, 1);
				}

			} else if (idx == 3) {
				if (left != magnet[idx - 1][2]) {
					move(idx - 1, clock_way * -1, -1);
				}
			} else {
				if (right != magnet[idx + 1][6]) {
					move(idx + 1, clock_way * -1, 1);
				}
				
				if (left != magnet[idx - 1][2]) {
					move(idx - 1, clock_way * -1, -1);
				}

			}

		}
		else if(next== -1) {
			if(idx==0) {
				return;
			}
				
			if (left != magnet[idx - 1][2]) {
					move(idx - 1, clock_way * -1, -1);
				}

			
			
		}
		else if(next==1){
			if (idx == 3) {
				return;

			}
			
			else {
				if (right != magnet[idx + 1][6]) {
					move(idx + 1, clock_way * -1, 1);
				}
				
			}
			
			
		}

	}

	private static void move_one(int[] array, int way) {

		if (way == -1) {

			int temp = array[0];
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
			array[array.length - 1] = temp;
		}
		else {
			int temp = array[array.length-1];
			for (int i = array.length-1; i >0; i--) {
				array[i] = array[i -1];
			}
			array[0] = temp;
		}

	}

}
