package algo.hw;

import java.util.Scanner;

public class SWEA_7728_D3_다양성측정 {

	public static void variety(int num, int[] array) {
		
		if(num<10) {
			 array[num%10]++;
		}
		else {
			variety(num/10,array);
			 array[num%10]++;
		}
		
		
	}
	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		
		
		int tc=sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int num= sc.nextInt();
			int[] array=new int[10];
			variety(num,array);
			int count=0;
			
			for(int j=0; j<array.length;j++) {
				if(array[j]!=0) {
					count++;
				}
			}
			System.out.printf("#%d %d\n",i,count);
			
			
			
			
		}

	}

}
