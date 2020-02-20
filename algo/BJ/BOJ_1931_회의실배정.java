package algo_ad.day2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1931_회의실배정 {

	static class Time{
		int s_time;
		int e_time;
		public Time(int s_time, int e_time) {
			this.s_time = s_time;
			this.e_time = e_time;
		}
		
	}
	public static void main(String[] args) {


		Scanner sc =new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		
		int[][] array=new int[tc][2];
		
		for (int i = 0; i < array.length; i++) {
			array[i][0]=sc.nextInt();
			array[i][1]=sc.nextInt();
		}
		
		Arrays.sort(array,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				Integer res1=o1[1];
				Integer res2=o2[1];
				if(res1==res2) {
					res1=o1[0];
					res2=o2[0];
				}
				return res1.compareTo(res2);
			}
		});
		
		
		Stack<Time> st=new Stack();
		
		
		st.push(new Time(array[0][0],array[0][1]));
		
		
		for (int i = 1; i < array.length; i++) {
			Time temp=st.peek();
			if(temp.e_time>array[i][0]) {
				
			}else {
				st.push(new Time(array[i][0],array[i][1]));
			}
		}
		
		System.out.println(st.size());
		
		
		
		

	}

}
