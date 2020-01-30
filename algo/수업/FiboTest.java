package algo_day4;

public class FiboTest {

	public static void main(String[] args) {
		
		System.out.println(fibo1(10));
		
		memo[0]=0;
		memo[1]=1;
		System.out.println(fibo2(10));
	}
	private static int[] memo= new int[100];
	
	//재귀함수 피보나치
	public static int fibo1(int num) {
		
		if(num==0 ) {
			return 0;
		}
		else if(num==1) {
			return 1;
		}
		else {
			return fibo1(num-1)+fibo1(num-2);
		}
		
	}
	
	//스택 피보나치
	public static int fibo2(int num) {
		
		if (num>1 && memo[num]==0) {
			return memo[num]=fibo2(num-1)+fibo2(num-2);
		}
		
		return memo[num];
	}

}
