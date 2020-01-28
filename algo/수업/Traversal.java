package algo_basic.day2;

public class Traversal {
	
	public static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	
	//4방향 좌표
	public static int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
	public static int[][] dirsx={{-1,-1},{1,1},{1,-1},{-1,1}};
	
	
	public static void main(String[] args) {
//		traversal4C(dirs);
		traversal4C(dirsx);
		
		
		
		
		

	}
	
	//어떤 점을 중심으로 4방향에 있는 요소들의총합은
	public static void traversal4C(int[][] dirs) {
		for(int i=0; i<arr.length;i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int sum=0;
				for (int d = 0; d < dirs.length; d++) {
					//방향에 따른 새로운 row, col 결정
					int ni =i+dirs[d][0];
					int nj =j+dirs[d][1];
					if(isIn(ni,nj)) {
						sum+=arr[ni][nj];
						
					}
					
				}
				System.out.printf("%d, %d 주변 요소의 합은 %d\n",i,j,sum);
			}
			
		}
	}
	//점들이 배열에 들어 있는지 확인
	public static boolean isIn(int row, int col) {
		return 0<=row && 0<=col && row<arr.length && col < arr[0].length;
	}

}
