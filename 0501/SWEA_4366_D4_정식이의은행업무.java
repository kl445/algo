package algo.hw0501;

import java.util.Scanner;

public class SWEA_4366_D4_정식이의은행업무 {

	static int twoToten(String str) {
		double ten = 0;
		for (int i = 0; i < str.length(); i++) {
			ten += Math.pow(2, str.length()-1-i) * (str.charAt(i) - '0');
		}
		return (int) ten;
	}

	static int threeToten(String str) {
		double ten = 0;
		for (int i = 0; i < str.length(); i++) {
			ten += Math.pow(3,str.length()-1-i) * (str.charAt(i) - '0');
		}
		return (int)ten;
	}
	
	static String tenTotwo(int ten) {
		String str=Integer.toBinaryString(ten);
		return str;
	}
	static String setMax(int n,int var) {
		StringBuilder sb=new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append(var);
		}
		return sb.toString();
	}
	static String tenTothree(int ten) {
		
		StringBuilder three=new StringBuilder();
		
		while((ten/3)!=0) {
			
			Integer a=ten%3;
			three.append(a);
			ten=ten/3;
			
		}
		three.append(ten);
		three.reverse();
		
		return three.toString();
	}

	static int isTrue(String str1, String str2) {
		int n=0;
		
		if(str1.length()!=str2.length()) {
			return n;
		}
		else {
			for (int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i)!=str2.charAt(i)) {
					n++;
				}
			}
			
		}
		
		
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t + 1).append(" ");

//			String bin2 =sc.next();
			StringBuilder bin2 =new StringBuilder(sc.next());
			String bin3 =sc.next();
//			StringBuilder bin3 =new StringBuilder(sc.next());
			

			for (int i = 0; i < bin2.length(); i++) {
				char tk=bin2.charAt(i);
				
				if(tk=='1') {
					bin2.setCharAt(i, '0');
					
					if(1==isTrue(bin3,tenTothree(twoToten(bin2.toString())))) {
						sb.append(twoToten(bin2.toString()));
						break;
					}
					
					bin2.setCharAt(i, '1');
				}else {
					bin2.setCharAt(i, '1');
					if(1==isTrue(bin3,tenTothree(twoToten(bin2.toString())))) {
						sb.append(twoToten(bin2.toString()));
						break;
					}
					
					bin2.setCharAt(i, '0');
				}
			}
			
			System.out.println(sb.toString());
			
		}
	}

}
