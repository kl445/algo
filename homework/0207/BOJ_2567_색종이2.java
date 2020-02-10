import java.util.Scanner;

public class BOJ_2567_색종이2 {

	public static void main(String[] args) {
		int [] dr = {1,-1,0,0};
		int [] dc = {0,0,-1,1};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean [][]arr = new boolean[100][100];
		for(int tc=1;tc<=T;tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int r=a;r<a+10;r++) {
				for(int c=b;c<b+10;c++) {
					arr[r][c] = true;
				}
			}
		}
		int cnt=0;
		for(int r=0;r<100;r++) {
			for(int c=0;c<100;c++) {
				if(arr[r][c]) {
					int four =0;
					for(int d=0;d<4;d++) {
						int newr= r+dr[d];
						int newc= c+dc[d];
						if( newr >=0 && newc>=0 && newr<100 && newc<100) {
							if(arr[newr][newc]) four++;
						}
					}
					if(four == 2) cnt+=2;
					else if(four == 3) cnt+=1;
				}
			}
		}
		System.out.printf("%d",cnt);
	}

}
