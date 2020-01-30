package algo_day4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_D4_괄호짝짓기 {

	private static String[] box1= {"([{<",")]}>"};
	
	public static void main(String[] args) {

		
		Scanner sc= new Scanner(System.in);
		
		for(int i=1;i<11;i++) {
			int range=sc.nextInt();
			
			String str=sc.next();
			
			Stack<Integer> st=new Stack<>();
			int flag= 1;
			
			
			for(int j=0;j<range;j++) {
				char c=str.charAt(j);
				if((c=='(')||(c=='[')||(c=='{')||(c=='<')) {
					st.push(box1[0].indexOf(c));
				
				}
				else if((c==')')||(c==']')||(c=='}')||(c=='>')) {
					if(st.isEmpty()) {
						flag=0;
						break;
					}
					else {
						if(st.peek()!=box1[1].indexOf(c)) {
							flag=0;

							break;
						}
						else {
							st.pop();
						}
					}
					
				}
			}
			
			System.out.printf("#%d %d\n",i,flag);
			
		}
		

	}
	
	

}
