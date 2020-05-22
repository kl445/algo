package algo.hw0521;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_1062_가르침 {

	static int N,K;
	static char[][] words;
	static boolean[] letters= new boolean[26];
	static int[] input=new int[26];
	static int max=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		K=sc.nextInt();
		
		letters['a'-'a']=true;
		letters['c'-'a']=true;
		letters['n'-'a']=true;
		letters['t'-'a']=true;
		letters['i'-'a']=true;
		
		words=new char[N][];

		for (int i = 0; i < N; i++) {
			words[i]=sc.next().toCharArray();				
		}
		
		
		combi('a',5);
		
		System.out.println(max);
		
		
	}

	private static void combi(int c, int cnt) {
		if(cnt==K) {
			check();
			
			return;
		}
		
		if(c>'z')return;
		
		combi(c+1, cnt);
		
		int letter=c-'a';
		
		if(!letters[letter]) {
			letters[letter]=true;
			combi(c+1, cnt+1);
			letters[letter]=false;
		}
		
		
	}

	private static void check() {
		int count=0;
		for (int i = 0; i < N; i++) {
			boolean isRead=true;
			for (int j = 0; j < words[i].length; j++) {
				int letter=words[i][j]-'a';
				if(!letters[letter]) {
					isRead=false;
					break;
				}
			}
			if(isRead) {
				count++;
			}
		}
		
		max=Math.max(max, count);
		
	}
	


}
