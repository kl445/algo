package swea_0212;

import java.util.Scanner;

public class BJ_8958_ox퀴즈 {

	public static void main(String[] args) {


		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			String str=sc.next();

			int grade[]= new int[str.length()+1];
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='X') {
					grade[j+1]=0;
				}else {
					grade[j+1]=grade[j]+1;
				}
			}
			int sum=0;
			for (int j = 0; j < grade.length; j++) {
				sum+=grade[j];
			}
			System.out.println(sum);
		}
	}

}
