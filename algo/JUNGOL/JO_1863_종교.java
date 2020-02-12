package algo.hw0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class JO_1863_종교 {

	static int[] s_array;
	public static int into(int[][] arr,int num,int start) {
		
		for (int i = start; i >=0; i--) {
			if(num==arr[i][1]) {
				return into(arr, arr[i][0],i);
			}
		}
		return num;
				
	}
	public static void setArray(int[] array) {
		for (int i = 1; i < array.length; i++) {
			array[i]=i;
		}
	}
	public static void setNum(int num1, int num2) {
		num1 = find(num1);
		num2 = find(num2);
		
		if(num1 == num2) {
			return;
		}
		s_array[num2] = num1;
		
	}
	public static int find(int num) {
		if(num==s_array[num]) return num;
		int index = find(s_array[num]);
		s_array[num]=index;
		return index;
	}
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());
		
		s_array=new int[n+1];
		setArray(s_array);
		
		/*
		if (m == 0) {
			System.out.println(n);
		} else {
		
			int l_array[][] = new int[m][2];
			
			int[] m_array = new int[n];
			
			*/
			int lar[]=new int[2];
						
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				lar[0] = Integer.parseInt(st.nextToken());
				lar[1] = Integer.parseInt(st.nextToken());
				
				setNum(lar[0],lar[1]);
				/*
				l_array[i][0] = Integer.parseInt(st.nextToken());
				l_array[i][1] = Integer.parseInt(st.nextToken());
				if (l_array[i][0] > l_array[i][1]) {
					int temp = l_array[i][0];
					l_array[i][0] = l_array[i][1];
					l_array[i][1] = temp;
				}*/
				
				
				

			}
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				
				if(s_array[i]==i) cnt++;
				
			}
			System.out.println(cnt);

/*
			Arrays.sort(l_array, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					Integer res1 = o1[0];
					Integer res2 = o2[0];

					if (res1 == res2) {
						res1 = o1[1];
						res2 = o2[1];
					}
					return res1.compareTo(res2);
				}
			});

			
			
			for (int i = m_array.length-1; i >= 0; i--) {
				m_array[i]=into(l_array,i+1,m-1);
			}	

			int sample = m_array[0];
			int cnt = 1;

			for (int i = 0; i < m_array.length; i++) {
				if (sample != m_array[i]) {
					sample=m_array[i];
					cnt++;
				}
			}
			
			
			System.out.println(cnt);

		}*/
	}
}
