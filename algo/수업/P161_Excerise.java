package algo_day4;

import java.util.Stack;

public class P161_Excerise {

	public static void main(String[] args) {
		
		String str=("(())(())s");
		
		System.out.println(barcketCheck(str));
		
	}
	
	public static boolean barcketCheck(String str) {
		Stack<Character> stack=new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				stack.push('(');
			}
			else if(str.charAt(i)==')') {

				if(stack.isEmpty()) {
					return false;
				}
				else if(stack.peek()=='(') {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
