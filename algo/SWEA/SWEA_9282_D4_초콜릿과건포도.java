package algo.hw0227;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9282_D4_초콜릿과건포도 {

	private static int n,m,min,res;
	private static int map[][];
	private static int[][][][] dp; //r,c,h,w
	
	public static int[][] arrayCopy( int array2[][]) {
		
		int array1[][]=new int[array2.length][array2[0].length];
		
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				array1[i][j]=array2[i][j];
			}
			
		}
		return array1;
	}
	
	public static int dfs(int r, int c,int h, int w) {	
		
		//종료
		if(w==1 && h==1) {
			return 0;
		}
		if(dp[r][c][h][w]!=Integer.MAX_VALUE) {
			return dp[r][c][h][w];
		}
		//실행
		//기존의 건포도 개수
		int sum=0;
		for (int i = r; i < r+h; i++) {
			for (int j = c; j < c+w; j++) {
				sum +=map[i][j];
			}
		}
		//가로로 나누어서 최소비용 구하기
		for(int i= 1;i<h;i++) {
			//위쪽 비용 
			int sumUp=dfs(r, c, i, w);
			//아래쪽 비용
			int sumDown=dfs(r+i,c,h-i,w);
			//합산
			int sumAll=sum+sumUp+sumDown;
			dp[r][c][h][w]=Math.min(dp[r][c][h][w], sumAll);
			//합산후 최소값 구하기
			
		}
		
		//세로로 나누어서 최소비용 구하기
		for(int i= 1;i<w;i++) {
			//왼쪽 비용 
			int sumLeft=dfs(r, c, h, i);
			//오른쪽 비용
			int sumRight=dfs(r,c+i,h,w-i);
			//합산
			int sumAll=sum+sumLeft+sumRight;
			dp[r][c][h][w]=Math.min(dp[r][c][h][w], sumAll);
			//합산후 최소값 구하기
			
		}
		return dp[r][c][h][w];
		//재귀호출
		
		
		
		
		
		
		
		
		
		
//		if(temp.length==1 && temp[0].length==1) {
//			
//			return;
//		}
//		
//		else {
//			for (int i = 0; i < array.length; i++) {
//				
//				if(array[i].type=='r') {
//					int[][] array1=new int[temp.length-array[i].i+1][temp[0].length];
//					array1=arrayCopy(array2);
//					
//					dfs(temp);					
//					dfs(temp);
//					
//				}
//				else if(array[i].type=='c') {
//					
//					dfs(temp);					
//					dfs(temp);
//				}
//				
//				
//			}
//			
//		}
		
	}
	
	static class Next {
		char type;
		int i;
		
		public Next(char type, int i) {
			this.type = type;
			this.i = i;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			
			n=sc.nextInt();
			m=sc.nextInt();
//			min=Integer.MAX_VALUE;
			
			map=new int[n][m];
			dp=new int[n+1][m+1][n+1][m+1];
			for (int[][][] d1:dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
			//사이즈가 정해져 있으면
			res=dfs(0,0,n,m); //0,0에서 n,m까지
			
//			Next[] array=new Next[n+m];
//			for (int j = 0; j < n; j++) {
//				array[j]=new Next('r',j);
//			}
//			for (int j = 0; j < m; j++) {
//				array[j]=new Next('c',j);
//			}
//			
//			
//			
//			
//			
//			
//		
			System.out.printf("#%d %d\n",i,res);
			
		}
		
	}

}
