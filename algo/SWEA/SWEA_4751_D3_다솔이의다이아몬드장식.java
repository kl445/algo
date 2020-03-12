package algo.hw0224;

import java.util.Scanner;

public class SWEA_4751_D3_다솔이의다이아몬드장식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

			String str = sc.next();

			StringBuilder sbTop = new StringBuilder();
			StringBuilder sbSec = new StringBuilder();
			StringBuilder sbBottom= new StringBuilder();

			sbTop.append("..#");
			sbBottom.append("#.");
			int n = str.length();

			int range = 4 + n + (n - 1) * 3;
			for (int j = 0; j < range; j++) {

				if (j % 2 == 0) {
					sbSec.append(".");
				} else {
					sbSec.append("#");
				}
			}
			for (int j = 0; j < str.length(); j++) {
				sbTop.append("...#");
				sbBottom.append(str.charAt(j)).append(".#.");
			}
			sbBottom.deleteCharAt(sbBottom.length()-1);
			sbTop.delete(sbBottom.length()-5,sbBottom.length()-1);
			sbTop.append("..");
//			sbBottom.deleteCharAt(sbBottom.length()-1);

			System.out.println(sbTop.toString());
			System.out.println(sbSec.toString());
			System.out.println(sbBottom.toString());
			System.out.println(sbSec.toString());
			System.out.println(sbTop.toString());
		}
	}

}
