package algo.hw0402;

import java.util.Scanner;

public class SWEA_6782_D5_현주가좋아하는제곱근놀이 {

	static long N;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		//테스트 케이스 및 정수 N 입력받기
		int tc=sc.nextInt();
		
		for (int t = 0; t < tc; t++) {
			N=sc.nextLong();
			
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t+1).append(" ");
			
			
			int cnt=0;
			double temp;
			
			//N이 2가 될때까지 반복
			while(N!=2) {
				
				//sqrt(N)이하의 가장 근접한 정수를 찾아 temp2에 저장
				temp=Math.sqrt(N);
				long temp2= (long)temp;
				
				//temp2의 제곱이 N과 같다면 sqrt(N)은 정수이므로 N을 재정의하고 카운트 증가
				if(N==temp2*temp2) {
					N=temp2;
					cnt++;
					
				}
				//temp2의 제곱이 N보다 작다면 다음 정수(temp2+1)의 제곱 n2를 구함
				else {
					//
					long n2=(temp2+1)*(temp2+1);
//					long n2=temp2*temp2+2*(temp2-1)+3;
					//N을 n2와 같게 만들어주고 그 수만큼 count를 증가시킴
					cnt+=n2-N;
					N=n2;
					
				}
				
			}
			sb.append(cnt);
			
			System.out.println(sb.toString());

		}
		
	}

}
