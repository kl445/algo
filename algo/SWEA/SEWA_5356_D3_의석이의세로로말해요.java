package algo.hw;

import java.util.Arrays;
import java.util.Scanner;

public class SEWA_5356_D3_의석이의세로로말해요 {

	
	public static char[][] arrSet(char[][] char_arr) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<15;j++) {
				char_arr[i][j]='*';
			}
		}
		return char_arr;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		String[] str_arr=new String[5];
		char[][] char_arr=new char[5][15];
		

		for(int i=1;i<=tc;i++) {
			System.out.print("#"+i+" ");
			char_arr=arrSet(char_arr);
			for(int j=0;j<5;j++) {
				str_arr[j]=sc.next();
				
				for(int k=0; k<str_arr[j].length();k++) {
					char_arr[j][k]=str_arr[j].charAt(k);
				}
				
//				System.out.println(Arrays.toString(char_arr[i]));
			}

//			for(int j=0;j<15;j++) {
//			
//				
//				System.out.print("arr"+j+":");
//			if(char_arr[0][j]=='*') {
//				System.out.print("isnull");
//			}
//			else {
//				System.out.print(char_arr[0][j]);
//			}
//			
//		
//			}
			for(int j=0;j<15;j++) {
				for(int k=0; k<5;k++) {
					if(char_arr[k][j]!='*') {
					System.out.print(char_arr[k][j]);
					}
				}
				
			}
			System.out.println();
			
			
		
		
		}
	}

}
