package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1220_D3_Magnetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		for(int i=1; i<=10;i++) {
		
			
			int range=sc.nextInt();
			
			int[][] map= new int[100][100];
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					map[j][k]=sc.nextInt();
				}
			
			}
			Stack<Integer> st= new Stack<>();
			
			int cnt=0;
			
			for(int j=0;j<100;j++) {
				for(int k=0; k<100;k++) {
					if(st.isEmpty()) {
						if(map[k][j]==1) {
							st.push(map[k][j]);
						}
					}
					else{
						if(map[k][j]==1) {
							st.push(map[k][j]);
						}
						else if(map[k][j]==2) {
							cnt++;
							while(!st.isEmpty()) {
								st.pop();
							}	
						}
					}
				}
				while(!st.isEmpty()) {
					st.pop();
				}	
			}
			
			System.out.printf("#%d %d\n",i,cnt);
			
			
		}
		
		
		
	}

}
