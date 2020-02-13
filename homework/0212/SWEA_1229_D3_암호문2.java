package swea_0213;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1229_D3_암호문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		for (int i = 1; i <=10; i++) {
			int n= sc.nextInt();
			
			
			LinkedList<Integer> list= new LinkedList<>();
			
			for (int j = 0; j <n; j++) {
				list.add(sc.nextInt());
			}
			
			//명령어
			int m=sc.nextInt();
			
			for (int j = 0; j < m;j++ ) {
				
				char token=sc.next().charAt(0);
				
				if(token=='I') {
					int x=sc.nextInt();
					int y=sc.nextInt();
					
					int s_array[]=new int[y];
					
					for (int k = 0; k < s_array.length; k++) {						
						s_array[k]=sc.nextInt();
					}
					for (int k = s_array.length-1; k >-1 ; k--) {
						list.add(x,s_array[k]);
					}
					
				}
				else if(token=='D') {
					int x=sc.nextInt();
					int y=sc.nextInt();
					
					
					for (int k = 0; k <y; k++) {
						list.remove(x);
					}
					
				}
				
			}
			
			
			System.out.print("#"+i);
			
			for (int j = 0; j < 10; j++) {
				System.out.print(" "+list.get(j));
			}
			System.out.println();
			
		}
		
	}

}
