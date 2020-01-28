package com.maze;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class Maze {
	
	public static boolean isIn(int r, int c, int[][] array) {
		
		return(r>=0 && c>=0 && r<array.length && c<array.length );
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res\\solution4.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		for(int i=1; i<=tc; i++) {
			int n=sc.nextInt();
			
			int[][] maze= new int[n][n];
			
			int start_r=sc.nextInt()-1;
			int start_c=sc.nextInt()-1;
			
			
			int jump_n=sc.nextInt();
			for(int j=0; j<jump_n;j++) {
				int jump_x=sc.nextInt()-1;
				int jump_y=sc.nextInt()-1;
				maze[jump_x][jump_y]=-1;
			}
			
			int move_n=sc.nextInt();
			int[] move_array=new int[move_n];	//방향
			int[] run_array=new int[move_n];	//이동칸
			for(int j=0;j<move_n;j++) {
				move_array[j]=sc.nextInt();
				run_array[j]=sc.nextInt();
			}
			
			for(int j=0;j<move_n;j++) {
				switch(move_array[j]) {
					
				case 1:{
					if(isIn(start_r-run_array[j],start_c,maze)) {
						start_r=start_r-run_array[j];
						if(maze[start_r][start_c]==-1) {
							start_r=0;
							start_c=0;
						}
					}
					else {
						start_r=0;
						start_c=0;
					}
					break;
				}
				case 2:{
					if(isIn(start_c+run_array[j],start_c,maze)) {
						start_c=start_c+run_array[j];
						if(maze[start_r][start_c]==-1) {
							start_r=0;
							start_c=0;
						}
					}
					else {
						start_r=0;
						start_c=0;
					}
					break;
				}
				case 3:{
					if(isIn(start_r+run_array[j],start_c,maze)) {
						start_r=start_r+run_array[j];
						if(maze[start_r][start_c]==-1) {
							start_r=0;
							start_c=0;
						}
					}
					else {
						start_r=0;
						start_c=0;
					}
					break;
				}
				case 4:{
					if(isIn(start_c-run_array[j],start_c,maze)) {
						start_c=start_c-run_array[j];
						if(maze[start_r][start_c]==-1) {
							start_r=0;
							start_c=0;
						}
					}
					else {
						start_r=0;
						start_c=0;
					}
					break;
				}
				}
					
				
			}
			
			for (int k = 0; k < maze.length; k++) {
			System.out.println(Arrays.toString(maze[k]));
		}
			System.out.printf("#%d %d %d\n",i,start_r+1,start_c+1);
			
		}
		

	}

}
