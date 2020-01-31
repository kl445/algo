package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1234_D3_비밀번호 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int range=sc.nextInt();
			
			String str= sc.next();
			Stack<Character> st= new Stack<>();
			
			for(int j= 0; j<str.length();j++) {
				
				if(st.isEmpty()) {
					st.push(str.charAt(j));
				}
				else {
					if(st.peek()==str.charAt(j)) {
						st.pop();
					}
					else {
						st.push(str.charAt(j));
					}
				}
			}
			System.out.print("#"+i+" ");
			StringBuilder sb= new StringBuilder();
			while(!st.isEmpty()) {
//				System.out.print(st.pop());
				sb.append(st.pop());
			}
			
			System.out.println(sb.reverse());
		}
	}

}
