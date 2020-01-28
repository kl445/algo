package com.robot;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class WaterStrider_김동현 {

	public static boolean jump(int r, int c, int way, int[][] arr, int i) {
	
		if (i > 0) {
			if (way == 1) {
				if ((r + i) < arr.length) {
					if (arr[r + i][c] == 0 ) {
						arr[r+i][c]=+1;
						return jump(r + i, c, way, arr, i - 1);
					}
					else {
						
						return true;
					}
				}
			}

			else {
				if ((c + i) < arr.length) {
					if (arr[r][c + i] == 0) {
						arr[r][c+i]=+1;
						return jump(r, c + i, way, arr, i - 1);
				}
					
					else {
						return true;

						
					
				}
			}
			}
		}
		return false;
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\solution2.txt"));
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
					ans = j + 1;
					break;
				} else {
					if (jump(strider[j][0], strider[j][1], strider[j][2], lake, 3)) {
						ans = j + 1;
						break;
					}

				}
			}
			
//			for (int k = 0; k < lake.length; k++) {
//				System.out.println(Arrays.toString(lake[k]));
//			}
			System.out.printf("#%d %d\n", i, ans);

		}

	}

}
