package algo.hw0201;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;


public class JA_1828_냉장고 {

	
	static class Tem{
		int minTem, maxTem;

		public Tem(int minTem, int maxTem) {
			this.minTem = minTem;
			this.maxTem = maxTem;
		}
		
	
	}
	
	public static void reSort(int[][] array) {
		Arrays.sort(array, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                int res = o1[0] - o2[0];
                if (res == 0) {
                	res = o1[1] - o2[1];
                }
                return res;
            }
        });

	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int arr[][] = new int[tc][2];

		for (int i = 0; i < tc; i++) {

			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println("srot");
		reSort(arr);
        
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		Stack<Tem> st= new Stack<>();
		
		
		int cnt = 0;
		int temp=0;
		
		st.push(new Tem(arr[0][0],arr[0][1]));
		
		for (int i = 1; i < arr.length;i++) {
			
			
			if(st.peek().maxTem>=arr[i][0]) {
				if(st.peek().maxTem>=arr[i][1]) {
					st.push(new Tem(arr[i][0],arr[i][1]));
				}
				else {
					st.push(new Tem(arr[i][0],st.peek().maxTem));
				}
			}
			else {
				while(!st.isEmpty()) {
					st.pop();
				}
				cnt++;
				st.push(new Tem(arr[i][0],arr[i][1]));
			}
			
		}
		cnt++;
		
		System.out.println(cnt);

	}

}
