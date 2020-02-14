package swea_0213;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1221_D3_GNS {

	private static String[] str_array= {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

	
	static class Set{
		int n;
		String s;
		public Set(String s) {
			this.s = s;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			sc.next();
			int n=sc.nextInt();
			
			String str[]=new String[n];
			Set[] setclass=new Set[n];
			
			for (int j = 0; j < n; j++) {
				setclass[j]=new Set(sc.next());	
			}
			
			for (int j = 0; j < setclass.length; j++) {
				
				for (int k = 0; k < str_array.length; k++) {
					
					if(setclass[j].s.equals(str_array[k])) {
						setclass[j].n=k;
						break;
					}
				}
				
			}
			
			
			Arrays.sort(setclass,new Comparator<Set>() {

				@Override
				public int compare(Set o1, Set o2) {
					// TODO Auto-generated method stub
					
					Integer res1=o1.n;
					Integer res2=o2.n;
					
					return res1.compareTo(res2);
				}
			});
			
			
			System.out.println("#"+i);
			
			for (int j = 0; j < setclass.length; j++) {
				System.out.print(setclass[j].s+" ");
			}
			
			System.out.println();
		}
		
		
		
		
	}

}
