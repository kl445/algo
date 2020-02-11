package swea_0211;

import java.util.Scanner;

public class SWEA_1983_D2_조교의성적매기기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			int k=sc.nextInt();
			k--;
			
			double arr[]=new double[n];
			
			for (int j = 0; j < arr.length; j++) {
				arr[j]+=sc.nextInt()*0.35;
				arr[j]+=sc.nextInt()*0.45;
				arr[j]+=sc.nextInt()*0.2;
			}
			
			int cnt=0;
			for (int j = 0; j < arr.length; j++) {
				
				if(arr[k]<arr[j]) {
					cnt++;
				}
			}
			
			
			cnt++;
			String grade;
			
			if(cnt<=n/10) {
				grade="A+";
			}
			else if(cnt<=n/10*2) {
				grade="A0";
			}
			else if(cnt<=n/10*3) {
				grade="A-";
			}
			else if(cnt<=n/10*4) {
				grade="B+";
			}
			else if(cnt<=n/10*5) {
				grade="B0";
			}
			else if(cnt<=n/10*6) {
				grade="B-";
			}
			else if(cnt<=n/10*7) {
				grade="C+";
			}
			else if(cnt<=n/10*8) {
				grade="C0";
			}
			else if(cnt<=n/10*9) {
				grade="C-";
			}
			
			else  {
				grade="D0";
			}
			
			System.out.println("#"+i+" "+grade);
			
			
			
		}
	}

}
