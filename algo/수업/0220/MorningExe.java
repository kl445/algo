package algo_ad.day2;

import java.util.Arrays;
import java.util.LinkedList;

public class MorningExe {

	private static char[] chars= {'A','B','C','D','E'};
	
	public static void set(int r, int c, boolean[] visited, boolean[] check) {
		if(r==c) {
			LinkedList<Character> list=new LinkedList<>();
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					list.add(chars[i]);
				}
			}
			System.out.println(list.toString());
			
		}
		else {
			for (int i = 0; i < check.length; i++) {
				visited[c]=check[i];
				set(r, c+1, visited, check);
			}
		}
	}
	
	public static void combi(int r, int c, int start ,char[] temp) {
		if(r==c) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i = start; i < chars.length; i++) {
				temp[c]=chars[i];
				combi(r, c+1, i+1, temp);
			}
		}
	}
	public static void swap(char[] array, int idx1, int idx2) {
		
		char temp=array[idx1];
		array[idx1]=array[idx2];
		array[idx2]=temp;
	}
	public static boolean nextPerm(char[] array) {
		
		int i;
		for (i = array.length-2; i >= 0; i--) {
			if(array[i]<array[i+1]) {
				break;
			}
		}
		
		if(i==-1) {
			return false;
		}
		int j;
		for (j = array.length-1; j >=0; j--) {
			if(array[i]<array[j]) {
				break;
			}
			
		}
		swap(array,i,j);
		
		for (int a=i+1, b=array.length-1; a <b; a++,b--) {
			swap(array,a,b);
			
		}
		
		return true;
		
		
		
	}
	
	public static void perm(int r, int c, boolean[] visited, char[] temp) {
		
		if(r==c) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i = 0; i < chars.length; i++) {
				if(!visited[i]) {
					visited[i]=true;
					temp[c]=chars[i];
					perm(r, c+1, visited, temp);
					visited[i]=false;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean check[]= {true,false};
		
		set(5, 0, new boolean[5], check);
		
		System.out.println();
		
		combi(3, 0, 0, new char[3]);
		
		System.out.println();
		
		perm(3, 0, new boolean[5], new char[3]);
		System.err.println();
		
		System.out.println(chars);
		nextPerm(chars);
		System.out.println(chars);
	}

}
