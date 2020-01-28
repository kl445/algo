package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class BuildingBuild {
	
	public static int dirs[][]= {{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
	
	
	public static boolean isIn(int r, int c, char[][] array) {
		
		return(r>=0 && c>=0 && r<array.length && c<array.length );
	}

	public static boolean nearG(int r, int c, char[][] array) {
		
		for(int d=0; d<dirs.length;d++) {
			int nr=dirs[d][0]+r;
			int nc=dirs[d][1]+c;
			
			if(isIn(nr,nc,array)){
				if(array[nr][nc]=='G') {
					return true;
				}
			}
		}
		
		return false;
	}
	public static int build(int r, int c, char array[][]) {
		int ans=0;
		
		if(nearG(r,c,array)) {
			return 2;
		}
		else {
			for(int i=0;i<array.length;i++) {
				if(array[r][i]=='B') {
						ans++;
				}
			}
			for(int i=0;i<array.length;i++) {
				if(array[i][c]=='B') {
					ans++;
				}
			}
			
			return ans-1;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\solution6.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int n=sc.nextInt();
			char[][] b_array= new char[n][n];
			
			for(int j=0;j<n;j++) {
				for (int k = 0; k < n; k++) {
					b_array[j][k]=sc.next().charAt(0);
				}
			}
			int max=0;
			
			for(int j=0;j<n;j++) {
				for (int k = 0; k < n; k++) {
					if(b_array[j][k]=='B') {
						max=Math.max(max,build(j,k,b_array));
					}
				}
			}
			System.out.printf("#%d %d\n",i,max);
			
			
		}
		
	}

}
