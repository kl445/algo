package swea_0210;

import java.util.Scanner;

public class SWEA_1217_D3_거듭제곱 {

	public static int mult(int n, int r,int res) {
		
		if(r>1) {
			return n*mult(n,r-1,res);
		}
		else {
			return n;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		for (int i = 1; i <=10; i++) {
			
		
			int tc= sc.nextInt();
			
			int n=sc.nextInt();
			int r=sc.nextInt();
			
			
			
			System.out.printf("#%d %d\n",tc,mult(n,r,1));
		}
	}

}
