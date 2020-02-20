package algo_ad.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk= new StringTokenizer(bf.readLine());
		int n1 = Integer.parseInt(tk.nextToken());
		int n2 = Integer.parseInt(tk.nextToken());
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
		

		int n1_array[] = new int[n1];
		int n2_array[] = new int[n2];
		int total[] = new int[n1 + n2];

		tk= new StringTokenizer(bf.readLine());
		for (int i = 0; i < n1_array.length; i++) {
			n1_array[i] = Integer.parseInt(tk.nextToken());
//			n1_array[i] = sc.nextInt();
		}
		tk= new StringTokenizer(bf.readLine());
		for (int i = 0; i < n2_array.length; i++) {
			n2_array[i] = Integer.parseInt(tk.nextToken());
//			n2_array[i] = sc.nextInt();
		}

		int n1_index = 0;
		int n2_index = 0;

		for (int i = 0; i < total.length; i++) {

			if (n1_index == n1_array.length) {
				total[i]=n2_array[n2_index];
				n2_index++;

			} else if (n2_index == n2_array.length) {
				total[i] = n1_array[n1_index];
				n1_index++;
			} else {

				if (n1_array[n1_index] < n2_array[n2_index]) {
					total[i] = n1_array[n1_index];
					n1_index++;
				} else {
					total[i] = n2_array[n2_index];
					n2_index++;
				}
			}
		}
		for (int i = 0; i < total.length; i++) {
			
			System.out.print(total[i]+" ");
		}

	}

}
