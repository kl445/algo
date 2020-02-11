package swea_0206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SWEA_1225_D3_암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		
			
		for (int i = 0; i < 10; i++) {
			int tc=sc.nextInt();
			
			int array[] = new int[8];
			Queue<Integer> qu= new LinkedList<>();
				
			for (int j = 0; j < 8; j++) {
				array[j]=sc.nextInt();
				qu.offer(array[j]);
				
			}
			
			int sub=1;
			
			while(true) {
				
				int temp=qu.poll();
				temp-=sub;
				sub=(sub%5)+1;
				if(temp<=0) {
					temp=0;
					qu.offer(temp);
					break;
				}
				
				qu.offer(temp);
					
				
			}
			
			System.out.print("#"+tc);
			
			while(!qu.isEmpty()) {
				System.out.print(" "+qu.poll());
			}
			System.out.println();
		
			
		}

	}

}
