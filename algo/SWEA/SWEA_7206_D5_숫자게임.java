package algo.hw0521;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA_7206_D5_숫자게임 {

	static HashMap<Integer,Integer> memo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//데이터 입력
			int N=sc.nextInt();
			memo=new HashMap<Integer,Integer>();
			//숫자 계산
			int cnt=game(N);
			
			
			//결과출력
			System.out.println("#"+tc+" "+cnt);
		}
		
	}

	private static int game(int n) {
		//n이 10 미만이면 리턴0
		
		if(n<10) {
			return 0;
		}
	
		int max=0;
		String str=""+n;
		int len=str.length()-1;
		
		
		/*
		 * 123	 	0: 안쪼갠경우
		 * 1 23		1: 첫번째 위에서 숫자를 조갠다
		 * 12 3		10: 두번째 위에서 숫자를 조갠다
		 * 1 2 3	11: 첫번째  두번째 위에서 숫자를 조갠다
		 */
		
		
		//부분집합을 이용해서 1 위치에서 숫자를 자른 후 곱함
		for (int i = 1,size=1<<len; i < size; i++) {
			int num=str.charAt(0)-'0';
			int mul=1;
			for (int j = 0; j < len; j++) {
				if((i & (1<<j))==0) { //쪼개는 위치가 아님
					num=num*10+str.charAt(j+1)-'0';
				}
				else {
					mul*=num;
					num=str.charAt(j+1)-'0';
				}
			}
			mul*=num; //마지막 조각을 곱함
			int cnt=0;
			if(memo.containsKey(mul)) { //메모에 값이 있는경우
				cnt=memo.get(mul);
				
			}
			else {//메모에 값이 없는 경우
				cnt=game(mul);
				memo.put(mul, cnt);
			}
			max=Math.max(max, cnt);
		}
		
		return max+1;
	}

}
