package swea_0213;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9480_D3_민정이와광직이의알파벳공부 {

	public static int total=0;
	
	public static boolean isAll(String[] str) {
		
		boolean[] alpa=new boolean[26];
		
		for (int i = 0; i < str.length; i++) {
			
			for (int j = 0; j < str[i].length(); j++) {
				alpa[str[i].charAt(j)-'a']=true;
			}
		}
		
		for (int i = 0; i < alpa.length; i++) {
			if(alpa[i]==false) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	public static void combi(int r, int c, String str[], boolean[] visited,int start, String[] temp ) {
		
		if(r==c) {
			if(isAll(temp)) {
//				System.out.println(Arrays.toString(temp));
				total++;
			}
			return;
		}
		else {
			
			for (int i = start; i < str.length; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[c]=str[i];
					combi(r, c+1, str, visited,i+1, temp);
					visited[i]=false;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			
			String str[]=new String[n];
			
			for (int j = 0; j < n; j++) {
				str[j]=sc.next();
				
			}
			
			
			for (int j = 1; j <= str.length; j++) {
				combi(j, 0, str, new boolean[n], 0, new String[j]);
				
			}
			
			System.out.printf("#%d %d\n",i,total);
				
			total=0;
			
			
			
			
			
			
			
			
			
		}

	}

}
