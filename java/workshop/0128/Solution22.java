package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution22 {

	public static void jump(int r, int c, int way, int[][] arr, int i) {

		if (i > 0) {
			if (way == 2) {// 하
				if ((r + i) < arr.length && (r + i) > -1) {
					if (i == 1) {
						if (arr[r + i][c] == 0) {
							arr[r + i][c] = +1;
						}
					} else {
						if (arr[r + i][c] == 0) {
							jump(r + i, c, way, arr, i - 1);
						}
					}
				}
			}

			else if (way == 4) {// 우
				if ((c + i) < arr.length && (c + i) > -1) {
					if (i == 1) {
						if (arr[r][c + i] == 0) {
							arr[r][c + i] = +1;
						}
					} else {
						if (arr[r][c + i] == 0) {
							jump(r, c + i, way, arr, i - 1);
						}
					}
				}
			} else if (way == 1) {// 상
				if ((r - i) < arr.length && (r - i) > -1) {
					if (i == 1) {
						if (arr[r - i][c] == 0) {
							arr[r - i][c] = +1;
						}

					} else {
						if (arr[r - i][c] == 0) {
							jump(r - i, c, way, arr, i - 1);
						}

					}
				}
			} else if (way == 3) {// 좌
				if ((c - i) < arr.length && (c - i) > -1) {
					if (i == 1) {
						if (arr[r][c - i] == 0) {
							arr[r][c - i] = +1;
						}

					} else {
						if (arr[r][c - i] == 0) {
							jump(r, c - i, way, arr, i - 1);
						}

					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\solution5.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

			int n = sc.nextInt();
			int[][] lake = new int[n][n];

			int s = sc.nextInt();
			int[][] strider = new int[s][3];

			int ans = 0;

			for (int k = 0; k < s; k++) {
				strider[k][0] = sc.nextInt();
				strider[k][1] = sc.nextInt();
				strider[k][2] = sc.nextInt();

			}

			for (int j = 0; j < strider.length; j++) {
				if (lake[strider[j][0]][strider[j][1]] != 0) {
				} else {
					jump(strider[j][0], strider[j][1], strider[j][2], lake, 3);
				}
//				for (int k = 0; k < lake.length; k++) {
//					System.out.println(Arrays.toString(lake[k]));
//				}
//				System.out.println("*********");
			}
			int sum = 0;
			for (int j = 0; j < lake.length; j++) {
				for (int k = 0; k < lake.length; k++) {
					sum += lake[j][k];
				}
			}
//			for (int k = 0; k < lake.length; k++) {
//				System.out.println(Arrays.toString(lake[k]));
//			}
			System.out.printf("#%d %d\n", i, sum);

		}

	}
}
