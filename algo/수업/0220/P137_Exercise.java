package algo_ad.day2;

import org.omg.Messaging.SyncScopeHelper;

public class P137_Exercise {

	public static void main(String[] args) {

		
		//분할정복을 이용해서 빠른 거듭 제곱을 구현하자
		
		long start= System.nanoTime();
		double result=Math.pow(2, 50);
		System.out.println(result);
		long mid= System.nanoTime();
		result=getPower(2, 50);
		System.out.println(result);
		long end= System.nanoTime();
		System.out.printf("api: %d, dnc: %d\n",mid-start,end-mid);
		
		
		

	}
	
	
	public static double getPower(int x, int r) {
		if(r==1){
			return x;
		}
		else if(r%2==0) {
			double y= getPower(x, r/2);
			return y*y;
			
		}
		else {
			double y=getPower(x, r/2);
			return y*y*x;
			
		}
	}

}
