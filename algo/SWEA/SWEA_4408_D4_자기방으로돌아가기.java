package swea_0210;


import java.util.Arrays;
import java.util.Scanner;


public class SWEA_4408_D4_자기방으로돌아가기 {

	
	public static int maxArray(int tmep[]) {
		int max=0;
		for (int i = 0; i < tmep.length; i++) {
			max=Math.max(max, tmep[i]);
		}
		return max;
	}
	
	
	
	// 홀짝 세팅
	public static int isEvenOrOdd(int num) {
		int ans = 0;

		if (num % 2 == 0) {
			ans = ((num / 2) - 1);
		} else {
			ans = (num / 2);
		}
		return ans;

	}

	// num 더하기 세팅
	public static void isSet(int[] tem, int start, int end, int num) {
		for (int i = start; i <= end; i++) {
			tem[i] += num;
		}
	}

	// 길이 비어있는지
	public static boolean isEmpty(int[] tem, int start, int end) {

		for (int i = start; i <= end; i++) {
			if (tem[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			
			int s_room[] = new int[n];
			int e_room[] = new int[n];

			int t_room[] = new int[200];
			int temp[]= new int[n];
			for (int j = 0; j < n; j++) {
				s_room[j] = sc.nextInt();
				e_room[j] = sc.nextInt();
			}

			int cnt = 0;	
			
			while (true) {

				for (int j = 0; j < s_room.length; j++) {

					int start = 0;
					int end = 0;
					if (e_room[j] <= s_room[j]) {

						start = isEvenOrOdd(e_room[j]);
						end = isEvenOrOdd(s_room[j]);

						if (s_room[j] != 0) {
								isSet(t_room, start, end, 1);
								s_room[j] = 0;
								e_room[j] = 0;
						}

					}

					else {
						start = isEvenOrOdd(s_room[j]);
						end = isEvenOrOdd(e_room[j]);

						if (s_room[j] != 0) {
								isSet(t_room, start, end, 1);
								s_room[j] = 0;
								e_room[j] = 0;
						}

					}
				}
				cnt++;

				if (isEmpty(s_room, 0, s_room.length - 1)) {
					break;
				} else {
					
				}

			}

			
			cnt=maxArray(t_room);
			System.out.printf("#%d %d \n", i, cnt);

		}

	}

}
