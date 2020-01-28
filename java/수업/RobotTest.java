package com.robot;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class RobotTest {

	
	public static int moveA(int x, int y, char[][] arr) {
		int ans=0;
		for(int i=y+1;i<arr.length;i++) {
			if(arr[x][i]=='S') {
				ans++;
			}
			else {
				break;
			}
		}
		return ans;
		
	}
	
	public static int moveB(int x, int y, char[][] arr) {
		int ans=moveA(x,y,arr);
		
		for(int i=y-1;i>-1;i--){
			if(arr[x][i]=='S') {
				ans++;
			}
			else {
				break;
			}

		}
		return ans;
		
	}
	public static int moveC(int x, int y, char[][] arr) {
		int ans=moveB(x,y,arr);
			
		for(int i=x+1;i<arr.length;i++) {
			if(arr[i][y]=='S') {
				ans++;
			}
			else {
				break;
			}
		}
		for(int i=x-1;i>-1;i--) {
			if(arr[i][y]=='S') {
				ans++;
			}
			else {
				break;		
			}
		}
		return ans;
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\solution1.txt"));
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int n= sc.nextInt();
			char[][] map=new char[n][n];
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					map[j][k]=sc.next().charAt(0);
					
				}
			}
//			System.out.println(Arrays.deepToString(map));
			
			int ans=0;
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(map[j][k]=='A') {
						ans=ans+moveA(j,k,map);
					}
					else if(map[j][k]=='B') {
						ans+=moveB(j,k,map);
					}
					else if(map[j][k]=='C') {
						ans+=moveC(j,k,map);
					}
										
				}
			}
			
			System.err.printf("#%d %d\n",i+1,ans);
		}
		
		
	}

}
