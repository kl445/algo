package algo.hw0224;

import java.util.Scanner;

public class SWEA_4789_D3_성공적인공연기획 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

			String str = sc.next();

			int n = 0;
			int buy = 0;
			for (int j = 1; j <=str.length(); j++) {

				int tk = str.charAt(j-1) - '0';
				if (tk != 0) {
					if (n < j - 1) {
						buy += j - 1 - n;
						n = j-1 + tk;
					} else {
						n += tk;
					}

				} 
				else {
					if(j==1) {
					n++;
					buy++;
					}else {
						
					}

				}
			}
			System.out.printf("#%d %d\n", i, buy);
		}
	}

}
