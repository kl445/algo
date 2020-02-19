package algo_ad.day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA_1240_D3_단순2진암호코드 {

	public static Map<String, Integer> code = new HashMap<String, Integer>();

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		code.put("0001101", 0);
		code.put("0011001", 1);
		code.put("0010011", 2);
		code.put("0111101", 3);
		code.put("0100011", 4);
		code.put("0110001", 5);
		code.put("0101111", 6);
		code.put("0111011", 7);
		code.put("0110111", 8);
		code.put("0001011", 9);
//		System.out.println(code);

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {

			int r = sc.nextInt();
			int c = sc.nextInt();

			int[][] map = new int[r][c];

			String str[] = new String[r];

			int index = -1;
			for (int j = 0; j < str.length; j++) {
				str[j] = sc.next();
//				System.out.println(str[j]);
				if (str[j].indexOf('1') != -1) {
					index = j;
				}
			}

			int e_index = -1;
			int s_index = -1;
			for (int j = str[index].length() - 1; j >= 0; j--) {
				if (str[index].charAt(j) == '1') {
					e_index = j;
					break;
				}

			}
//			System.out.println(e_index);
			s_index = e_index - 56 + 1;

			String[] s_code = new String[8];
			int res_index = 0;
			for (int k = s_index, cnt = 0; k < s_index + 56; k += 7) {

				StringBuilder sb = new StringBuilder();
				for (int j = k; j < k + 7; j++) {
					sb.append(str[index].charAt(j));
				}
				s_code[res_index++] = sb.toString();
			}

			int[] res=new int[8];
			
			for (int j = 0; j < res.length; j++) {
				res[j]=code.get(s_code[j]);
			} 
			
			
			int sum=0;
			for (int j = 0; j < res.length-1; j++) {
				if((j+1)%2==1) {
					sum+=res[j]*3;
				}else {
					sum+=res[j];
				}
			}
//			System.out.println(sum);
			int output=0;
			if((sum+res[7])%10==0) {
				for (int j = 0; j < res.length; j++) {
					output+=res[j];
				}
			}
			
//			System.out.println(Arrays.toString(res));
			System.out.printf("#%d %d\n",i,output);
			
			
			
		}

	}

}
