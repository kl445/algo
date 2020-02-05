package swea_0205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_D4_계산기3 {

	public static int tokenType(char c) {
		
		if(c=='*' || c=='/') {
			return 4;
		}
		else if(c=='+' || c=='-') {
			return 3;
		}
		else if(c==')') {
			return 2;
		}
		else if(c=='(') {
			return 1;
		}
		else {
			return 0;
	}
	}
		
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		List<Character> list=new ArrayList<>();
		
		for (int i = 1; i <=10; i++) {
			int n= sc.nextInt();
			
			String str=sc.next();
			Stack<Character> st= new Stack<>();
			
			for (int j = 0; j < str.length(); j++) {
				
				char token=str.charAt(j);
				
				if(tokenType(token)==0) {
					list.add(token);
				}
				else if(token=='(') {
					st.push(token);
				}
				else if(token==')') {
					while(true) {
						char top=st.pop();
						
						if(top=='(') {
							break;
						}
						else {
							list.add(top);
						}
					}
				}
				else {
					while(!st.isEmpty()) {
						char top=st.peek();
						if(tokenType(token)<=tokenType(top)) {
							list.add(st.pop());
						}
						else {
							break;
						}

						}
					st.push(token);
						
					}
				
				}
			
			while(!st.isEmpty()) {
				list.add(st.pop());
			}
			
//			for (int k = 0; k < list.size(); k++) {
//				System.out.println(list);
//				System.out.print(list.get(k)+" ");
//			}
				
				
			//계산
				
				Stack<Integer> int_st=new Stack<>();
				
				
				for (int j = 0; j < list.size(); j++) {
					char token=list.get(j);
					if(tokenType(token)==0) {
						int_st.push(token-'0');
					}
					else {
						int num2=int_st.pop();
						int num1=int_st.pop();
						int res=0;
						
						if(token=='*') {
							res=num1*num2;
						}
						else if(token=='+') {
							res=num1+num2;
						}
						else if(token=='/') {
							res=num1/num2;
						}
						else if(token=='-') {
							res=num1-num2;
						}
						
						int_st.push(res);
						
					}
				}
				System.out.printf("#%d %d\n",i,int_st.pop());
			}
		}

	}


