package algo.hw0224;

import java.util.Scanner;

public class SWEA_8104_D3_조만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		for (int i =1; i <=tc; i++) {
			
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		
		//조 만들기
		int sum[]=new int[m];
		
		boolean flag=true;
		for (int j = 1,k=0; j <= n*m; j++) {
			
			//true인 경우 오름차순으로 
			if(flag) {
				sum[k++]+=j;
			}
			//false인 경우 내림차순으로
			else {
				sum[k--]+=j;
			}
			//오름차순이 끝났을때 내림차순으로 변경
			if(k==m && flag==true) {
				flag=false;
				k--;
			}
			//내림차순이 끝났을때 오름차순으로 변경
			else if(k==-1 &&flag==false) {
				flag=true;
				k++;
			}
		}
		
		
		System.out.print("#"+i);
		for (int j = 0; j < sum.length; j++) {
			System.out.print(" "+sum[j]);
		}
		}
	}

}
