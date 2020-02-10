import java.util.Scanner;

public class BOJ_2563_색종이 {

	public static void main(String[] args) {
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
					cnt++;
				}
			}
		}
		System.out.printf("%d",cnt);
	}
}
