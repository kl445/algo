package algo_day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P216_Execerise {

	private static Stack<Character> stack=new Stack<>();
	
	//후위표식 저장 리스트
	private static List<Character> postfix=new ArrayList<>();
	
	public static void calcSampleEncode() {
		for (int i = 0; i < src.length(); i++) {
			char token= src.charAt(i);
			int tokenOrder=getInStackOrder(token);
			
			if(tokenOrder==0) {	 		//숫자는 출력
				postfix.add(token);
					
			}
			else if(token=='(') {		//여는 괄호는 push
				stack.push(token);
			}
			else if(token==')') {		//여는괄호를 만날떄까지 pop
				while(true) {
					char top=stack.pop();
					if(top=='(') {
						break;
					}
					else {
						postfix.add(top);
					}
				}
			}
			else {
				while(!stack.isEmpty()) {
					char top=stack.peek(); 	//스택 내의 제거 대상 찾기 
					if(getInStackOrder(top)>=tokenOrder) {
						postfix.add(stack.pop());
					}
					else {
						break;
					}
					
				}
				//다빠지면 들어가기
				stack.push(token);
				
			}
			
		}//문장 읽기 끝
		
		//남은 스택 처리
		while(!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		
		System.out.println(postfix);
	}
	
	public static void caclSampleDecode() {
		 
		Stack<Integer> intst=new Stack<>();
		for(int i=0; i<postfix.size();i++) {
			char token=postfix.get(i);
			
			if(getInStackOrder(token)==0) {
				intst.push(token-'0');
			}
			else {
				int num2=intst.pop();
				int num1=intst.pop();
				int res=0;
				if(token=='*') {
					res=num1*num2;
				}
				else if(token=='/') {
					res=num1/num2;
				}
				else if(token=='-') {
					res=num1-num2;
				}
				else if(token=='+') {
					res=num1+num2;
				}
				intst.push(res);
			}
		}
		int ans=intst.pop();
		
		System.out.println("answer: "+ans);
		
	}
	
	
	
	private static String src= "2+(3*4)/5";
//	private static String src= "5+5-4+8+5-5+5";
	
	
	
	
	public static void calc() {
		
		Stack<Character> st= new Stack<>();
		
		for (int i = 0; i < src.length(); i++) {
			char c=src.charAt(i);
			
			switch (getInStackOrder(c)) {
			
			case 0:
				System.out.print(c);
				break;
				
			case 1:
				st.push(c);
				break;
			
			case 2:
				while(getInStackOrder(st.peek())<getInStackOrder(c)) {
					System.out.print(st.pop());
				}
				st.pop();
				break;
				
			case 3:
				st.push(c);
				break;
			}
			
	
			
			
		}
		
	}
	
	public static int getInStackOrder(char c) {
		if(c=='*' || c=='/') {
			return 4;
		}
		else if(c=='+' || c=='-') {
			return 3;
		}
		if(c=='(' ) {
			return 2;
		}
		else if(c==')'){
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		calcSampleEncode();
		caclSampleDecode();
		

	}

}
