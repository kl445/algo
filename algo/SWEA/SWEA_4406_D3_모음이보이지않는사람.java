package swea_0205;

import java.util.Scanner;

public class SWEA_4406_D3_모음이보이지않는사람 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		char[] array= {'a','e','i','o','u'};
//		String array= "aeiou";
		int tc=sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			String str=sc.next();
			char[] ans= new char[str.length()];
			
			System.out.print("#"+i+" ");
			boolean flag=true;
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < array.length; k++) {
					if(str.charAt(j)==array[k]) {
						flag=false;
					}
					
				}
				if(flag) {
					System.out.print(str.charAt(j));
				}
				flag=true;
				
			}
			System.out.println();
		}
	}

}
