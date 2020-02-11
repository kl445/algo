package swea_0211;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JO_1863_종교 {

	static class Arr{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int m=sc.nextInt();
		if(m==0) {
			System.out.println(n);
		}
		else {
		int l_array[][]=new int[m][m];
//		int[] r_array=new int[m];
		int[] m_array=new int[m];
		
		for (int i = 0; i < m; i++) {
			l_array[i][0]=sc.nextInt();
			l_array[i][1]=sc.nextInt();
			
			if(l_array[i][0]>l_array[i][1]) {
				int temp=l_array[i][0];
				l_array[i][0]=l_array[i][1];
				l_array[i][1]=temp;
			}
			m_array[i]=l_array[i][1];
		
		}

//		for (int i = 0; i < m_array.length; i++) {
//			System.out.println(l_array[i][0]+":"+l_array[i][1]);
//			System.out.println();
//		}
		
		Arrays.sort(l_array,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				Integer res1=o1[0];
				Integer res2=o2[0];
				
				if(res1==res2) {
					res1=o1[1];
					res2=o2[1];
				}
				return res1.compareTo(res2);
			}
		});
		
//		System.out.println("m"+Arrays.toString(m_array));
		
		
		for (int i = 0; i < m_array.length; i++) {
			System.out.println(l_array[i][0]+":"+l_array[i][1]);
			System.out.println();
		}
		
		for (int i = l_array.length-1; i >=0; i--) {
			for (int j = 0; j < m_array.length; j++) {
				if(l_array[i][1]==m_array[j]) {
					m_array[j]=l_array[i][0];
				}
			}
		}
		
		int sample=m_array[0];
		int cnt=1;
		
		for (int i = 0; i < m_array.length; i++) {
			if(sample!=m_array[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	}
}
