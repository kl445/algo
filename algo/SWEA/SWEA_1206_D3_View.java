package swea_0210;

import java.util.Scanner;

public class SWEA_1206_D3_View {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int n = sc.nextInt();

			int[] tower = new int[n];
			for (int j = 0; j < tower.length; j++) {
				tower[j]=sc.nextInt();
			}

			int cnt = 0;
		

			for (int j = 2; j < tower.length - 2; j++) {
				int  temp1=0;
				int  temp2=0;
				
				if (tower[j - 2] <= tower[j - 1]) {
					if (tower[j] - tower[j - 1] > 0) {
						temp1=tower[j] - tower[j - 1];
//						cnt += tower[j] - tower[j - 1];
						
						
						if (tower[j +2] <= tower[j +1]) {
							if (tower[j] - tower[j + 1] > 0) {
								temp2= tower[j] - tower[j + 1];
//								cnt += tower[j] - tower[j + 1];
							}

						} else {
							if (tower[j] - tower[j + 2] > 0) {
								temp2= tower[j] - tower[j + 2];
//								cnt += tower[j] - tower[j + 2];
							}
						}
					}
					cnt+=Math.min(temp1, temp2);

				} 
				else {
					if (tower[j] - tower[j - 2] > 0) {
						
//						cnt += tower[j] - tower[j - 2];
						temp1= tower[j] - tower[j - 2];
						
						if (tower[j +2] <= tower[j +1]) {
							if (tower[j] - tower[j + 1] > 0) {
//								cnt += tower[j] - tower[j + 1];
								temp2= tower[j] - tower[j + 1];
							}

						} else {
							if (tower[j] - tower[j + 2] > 0) {
								temp2= tower[j] - tower[j + 2];
//								cnt += tower[j] - tower[j + 2];
							}
						}

					}
					cnt+=Math.min(temp1, temp2);
				}

			}
			
			
			System.out.printf("#%d %d\n",i,cnt);
		}

	}

}
