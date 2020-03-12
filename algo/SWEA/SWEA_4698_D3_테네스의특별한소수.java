package algo.hw0227;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_4698_D3_테네스의특별한소수 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int cnt=0;
		int[] list=new int[1000000];
		list[2]=2;
		for (int i = 3; i <=1000000; i++) {
			boolean flag=true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				list[i]=i;
			}
		}
		
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			Integer d=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			cnt=0;
			
			String target =d.toString();
			for (int j = 0; j <list.length; j++) {
				
				Integer temp=list[j];
				
				if(temp>=a && temp<=b ) {
					
					String str= temp.toString();
					
					if(str.contains(target)) {
						cnt++;
					}
					
				}
			}
			
//			getAns(a, b, d);
			
			
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(i).append(" ").append(cnt);
			System.out.println(sb.toString());
		}
	}

}
