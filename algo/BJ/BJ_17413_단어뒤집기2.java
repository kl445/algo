package swea_0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
//		Scanner sc=new Scanner(System.in);
		
//		String str= sc.next();
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer src= new StringTokenizer(bf.readLine());
		
		
		String str=bf.readLine();
//		String str=src.nextToken();
//		
//		
//		while(src.hasMoreTokens()) {
//			str=str+" ";
//			str=str+src.nextToken();
//		}
		
		
		Stack<Character> st= new Stack<>();
		Queue<Character> que=new LinkedList<>();
		StringBuilder sb= new StringBuilder();
		
		boolean flag=false;
		for (int i = 0; i < str.length(); i++) {
			
			char token=str.charAt(i);
			
			
			
			if(token=='<') {
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
				
				flag=true;
				que.offer(token);
			}
			else if(token=='>') {
				flag=false;
				que.offer(token);
				
				while(!que.isEmpty()) {
					sb.append(que.poll());
				}
			}
			else if(token==' ') {
				if(flag) {
					que.offer(token);
				}
				else {
					
					while(!st.isEmpty()) {
						sb.append(st.pop());
					}
					sb.append(token);
				}
			}
			else {
				if(flag) {
					que.offer(token);
				}
				else {
					st.push(token);
				}
			}
			
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb.toString());
		
	}

}
