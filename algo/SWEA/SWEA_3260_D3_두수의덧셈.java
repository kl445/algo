package algo.hw0224;

import java.math.BigInteger;
import java.util.Scanner;


public class SWEA_3260_D3_두수의덧셈 {

	public static void ans(StringBuilder sb1, StringBuilder sb2,int i) {
		int d=0;
		for (int j = 0; j <sb1.length(); j++) {
			Integer n1=0;
			Integer n2=0;
			
			n1=sb1.charAt(j)-'0';
			try {
				n2=sb2.charAt(j)-'0';				
			}catch(Exception e){
				n2=0;
			}
			
			Integer sum=n1+n2+d;
			if(sum>=10) {
				d=1;
				sum %=10;
				sb1.replace(j, j+1,sum.toString());
				
			}else {
				
				sb1.replace(j, j+1,sum.toString());
				d=0;
			}
		}
		if(d==1) {
			sb1.append("1");
		}
		
		sb1.append(" ").append(i).append("#");
		for (int j = sb1.length()-1; j >= 0; j--) {
			System.out.print(sb1.charAt(j));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			BigInteger a= sc.nextBigInteger();
			BigInteger b= sc.nextBigInteger();
			
			System.out.printf("123213#%d %d\n",i,a.add(b));
			
//			StringBuilder sb1= new StringBuilder();
//			StringBuilder sb2= new StringBuilder();
//			String str =sc.next();
//			for (int j = str.length()-1; j >=0; j--) {
//				sb1.append(str.charAt(j));
//			}
//			
//			String str2=sc.next();
//			for (int j = str2.length()-1; j >=0; j--) {
//				sb2.append(str2.charAt(j));
//			}
//			
//			
//			if(sb1.length()>sb2.length()){
//				ans(sb1,sb2,i);
//			}else {
//				ans(sb2,sb1,i);
//			}
			
			
		
		}
	}

}
