package algo.hw0429;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class SWEA_5658_모의_보물상자비밀번호 {

	static int N,K;
	static int P;//각 변당 글자수
	static char[] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			N=sc.nextInt();
			K=sc.nextInt();
			P=N/4;
			String input=sc.next();
			
			array=input.toCharArray();
			
			TreeSet<Long> set=new TreeSet<>();
			
			
			for (int i = 0; i < P; i++) {
				String str=new String(array);
				
				for (int j =0; j < 4; j++) {
//					System.out.println(str.substring(j*P,j*P+P));
//					System.out.println(to10(str.substring(j*P,j*P+P)));
					set.add(to10(str.substring(j*P,j*P+P)));
				}
//				System.out.println();
				moveArray();
			}
			
			for (int i = 0; i <K-1; i++) {
				
				set.pollLast();
			}
			
			System.out.println("#"+t+" "+set.pollLast());
			
		
			
		
		}
	}
	
	static void moveArray() {
		char temp=array[array.length-1];
		
		for (int i =array.length-1; i >0 ; i--) {
			array[i]=array[i-1];
		}
		array[0]=temp;
		
		
		
	}
	
	static long to10(String str) {
		
		long res=0;
		
		for (int i = 0; i < str.length(); i++) {
			char token=str.charAt(i);
			int temp=token-'0';
			if(temp>9) {
				temp=token-'A'+10;
			}
			res+=temp*Math.pow(16, P-i-1);
		}
		return res;
		
	}

}
