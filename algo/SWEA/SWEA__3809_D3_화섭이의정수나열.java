package swea_0213;

import java.util.Scanner;

public class SWEA__3809_D3_화섭이의정수나열 {

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			
			int n=sc.nextInt();
			int array[]=new int[n];
	
			
			for (int j = 0; j < n; j++) {

				
				array[j]=sc.nextInt();
			}
			
			
			int num=-1;
			boolean whileflag=true;
			while(whileflag) {
				num++;
				int[] sample_array=num_array(num);
				boolean flag=true;
				for (int j = 0; j <=array.length-sample_array.length; j++) {
					flag=true;
					for (int k = 0; k < sample_array.length; k++) {
						
						
						if(array[j+k]==sample_array[k]) {
							flag=flag&&true;
						}else {
							flag=flag&&false;
						}
						
						
					}
					if(flag) {
						whileflag=true;
						break;
					
					}else {
						whileflag=false;	
					}
				}
			}
			System.out.printf("#%d %d\n",i,num);
			
		}

	}
	public static int[] num_array(int num) {
		
		Integer sample=num;
		String str=sample.toString();
		int range[]= new int[str.length()];
		
		for (int i = 0; i <str.length(); i++) {
			range[i]=str.charAt(i)-'0';
		}
		return range;
	}

}
