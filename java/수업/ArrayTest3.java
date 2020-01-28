package com.array;

public class ArrayTest3 {

	public static void main(String[] args) {
		
		int[][] a= {
				{1,3,5},
				{2,5,6,4},
				{7,2,9,5,5}
		
		};
		
		for(int[] value:a) {
			for(int value2:value) {
				System.out.printf("%3d ",value2);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				System.out.printf("%3d ",a[i][j]);
			}
			System.out.println();
		}		
		
		
		
		
		int[][] sc= new int[3][3];
		
		sc[0][1]=100;
		sc[1][2]=200;
		sc[2][0]=77;

		for(int[] value:sc) {
			for(int value2:value) {
				System.out.printf("%3d ",value2);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<sc.length;i++) {
			for(int j=0; j<sc[i].length;j++) {
				System.out.printf("%3d ",sc[i][j]);
			}
			System.out.println();
		}
	}

}
