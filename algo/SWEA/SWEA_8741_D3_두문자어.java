package swea_0210;

import java.util.Scanner;

public class SWEA_8741_D3_두문자어 {

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			
			String str1=sc.next();
			String str2=sc.next();
			String str3=sc.next();
			
			System.out.print("#"+i+" ");
			System.out.print(str1.toUpperCase().charAt(0));
			System.out.print(str2.toUpperCase().charAt(0));
			System.out.println(str3.toUpperCase().charAt(0));
		}

	}

}
