package swea_0210;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1258_D4_행렬찾기 {

	static class SubM{
		int r, c, size;

		public SubM(int r, int c,int size) {
			this.r = r;
			this.c = c;
			this.size=size;
		}
		
		
	}
	
	public static void setZero(int[][] map, int start_r,int start_c, int end_r, int end_c) {
		
		
		for(int i=start_r;i<=end_r;i++) {
			for (int j = start_c; j <=end_c; j++) {
				map[i][j]=0;
			}
		}
			
	}
	
	
	public static ArrayList<SubM> find(int[][] map) {
		
		ArrayList<SubM> st= new ArrayList<>();
		
		int  start_r=0,start_c=0;
		int  end_r=0,end_c=0;
		int r, c;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]!=0) {
					start_r=i;
					start_c=j;
					int temp_r=start_r;
					while(true) {
						if(temp_r==map.length||map[temp_r][j]==0) {
							end_r=temp_r-1;
							break;
						}
						temp_r++;
					}
					int temp_c=start_c;
					while(true) {
						if(temp_c==map.length||map[i][temp_c]==0) {
							end_c=temp_c-1;
							break;
						}
						temp_c++;
					}
					
					setZero(map,start_r,start_c,end_r,end_c);
					r=(end_r-start_r)+1;
					c=(end_c-start_c)+1;
					
					st.add(new SubM(r, c,r*c));

				}
				
	
			}
		}
		
		return st;
	}
	public static void main(String[] args) {


		Scanner sc =new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			int map[][]=new int[n][n];
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
			ArrayList<SubM> st= find(map);
			
			st.sort(new Comparator<SubM>() {
		
				@Override
				public int compare(SubM o1, SubM o2) {
					// TODO Auto-generated method stub
					Integer res1=o1.size;
					Integer res2=o2.size;
					
					if(o1.size==o2.size) {
						res1=o1.r;
						res2=o2.r;
					}
					
					return res1.compareTo(res2);
				}
			});
			
			
			
			System.out.printf("#%d %d ",i,st.size());
			
			for (int j = 0; j < st.size(); j++) {
//				int size= st.get(i).size;
				int r= st.get(j).r;
				int c= st.get(j).c;
				
				System.out.print(r+" "+c+" ");
			}
			
			
			
			
			System.out.println();
		}

	}

}
