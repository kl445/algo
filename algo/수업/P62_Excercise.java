package algo_basic.day2;

public class P62_Excercise {

	public static int arr[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	public static int dirs[][]= {{0,-1},{0,1},{1,0},{-1,0}};
	
	public static void main(String[] args) {
		
		test();

		
		
		// TODO Auto-generated method stub

	}
	
	public static void test() {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int sum_temp=0;
				for (int d = 0; d < dirs.length; d++) {
					int ni=dirs[d][0]+i;
					int nj=dirs[d][1]+j;

					if(isIn(ni,nj)) {
						sum_temp+=Math.abs(arr[ni][nj]-arr[i][j]);
					}
				}
				sum+=sum_temp;
			}
		}
		System.out.println(sum);
	}
	public static boolean isIn(int x, int y) {
		return(x>0 && y>0 && x<arr.length && y<arr[0].length);
	}

}
