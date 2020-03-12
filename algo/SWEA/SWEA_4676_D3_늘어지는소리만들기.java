package algo.hw0227;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_4676_D3_늘어지는소리만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner  sc=new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			String str=sc.next();
			LinkedList<Character> list=new LinkedList<>();
			for (int j = 0; j < str.length(); j++) {
				list.add(str.charAt(j));
			}
			int n=sc.nextInt();
			int[] array=new int[n];
			
			
			for (int j = 0; j < array.length; j++) {
				array[j]=sc.nextInt();
				int cnt=0;
				for (int k = 0; k < list.size()+1; k++) {
					
					if(cnt==array[j]){
						list.add(k,'-');
						break;
					}
					if(list.get(k)!='-') {
						cnt++;
					}
					
				}
			}
			
			System.out.print("#"+i+" ");
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
			}
			System.out.println();
			
			
			
		}
	}

}
