package algo.hw0224;

public class SWEA_3131_D3_100만이하의모든소수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.print("2");
		for (int i = 3; i <= 1000000; i++) {
			boolean flag=true;
			for (int j =2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.print(" "+i);
			}
		}
		
	}

}
