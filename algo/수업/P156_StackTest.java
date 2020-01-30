package algo_day4;

import java.util.Stack;

public class P156_StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(100);
		stack.push(200);
		
		System.out.println(stack.peek()+" : "+stack.size());
		System.out.println(stack.pop()+" : "+stack.size());
		System.out.println(stack.pop()+" : "+stack.size());
		
		if(!stack.isEmpty()) {
			System.out.println(stack.pop()+" : "+stack.size());
		}
		else {
			System.out.println("비어있음");
		}
		
	}

}
