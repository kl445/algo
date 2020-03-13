package algo.hw0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3378_D4_스타일리쉬들여쓰기 {

	private static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int tc = Integer.parseInt(tk.nextToken());

		for (int t = 1; t <= tc; t++) {
			StringBuilder sb = new StringBuilder();
			tk = new StringTokenizer(br.readLine());

			int yourN = Integer.parseInt(tk.nextToken());
			int myN = Integer.parseInt(tk.nextToken());

			m = new int[yourN][4]; // .의 갯수, 괄호갯수

			for (int i = 0; i < yourN; i++) {
				// 한 줄을 입력받아
				String line = br.readLine();
				// .의 갯수
				int index = 0;
				while (line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;
				// 괄호의 개수(누적)
				if (i > 0) {
					m[i][1] = m[i - 1][1];// 소괄호 개수
					m[i][2] = m[i - 1][2];// 소괄호 개수
					m[i][3] = m[i - 1][3];// 소괄호 개수
				}

				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						m[i][1]++;
						break;
					case ')':
						m[i][1]--;
						break;
					case '{':
						m[i][2]++;
						break;
					case '}':
						m[i][2]--;
						break;
					case '[':
						m[i][3]++;
						break;
					case ']':
						m[i][3]--;
						break;

					default:
						break;
					}

				}
			} // 마스터의 스타일fltnl 코드 분석for

			dap = new int[myN][4]; // .의 갯수, 괄호갯수

			for (int i = 0; i < myN; i++) {
				// 한 줄을 입력받아
				String line = br.readLine();
				// .의 갯수
				int index = 0;
				// 괄호의 개수(누적)
				if (i > 0) {
					dap[i][1] = dap[i - 1][1];// 소괄호 개수
					dap[i][2] = dap[i - 1][2];// 소괄호 개수
					dap[i][3] = dap[i - 1][3];// 소괄호 개수
				}

				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						dap[i][1]++;
						break;
					case ')':
						dap[i][1]--;
						break;
					case '{':
						dap[i][2]++;
						break;
					case '}':
						dap[i][2]--;
						break;
					case '[':
						dap[i][3]++;
						break;
					case ']':
						dap[i][3]--;
						break;

					default:
						break;
					}

				}
			} // 내 코드 분석

			//dap[i][0]: 초기값 0 .의 갯수를 몇개 들여쓰기 해야하는지 저장 
			for (int i = 0; i < myN; i++) {
				dap[i][0]=-2;	 //안쓰는 값으로 초기화
			}
			
			//중복순열 생성
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if(check(r,c,s)) {
							//마스터 코드에 해당 되는가?
							cal(r,c,s);
						}
					}
				}
			}
			sb.append("#").append(t).append(" 0");
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
				
			}
			sb.append("\n");
			
			System.out.print(sb);
		}
	}

	//내 코드에서 들여쓰기를 얼마나 해야하는가?
	private static void cal(int r, int c, int s) {
		// TODO Auto-generated method stub
		for (int i = 1; i < dap.length; i++) {
			int x= dap[i-1][1]*r+dap[i-1][2]*c+dap[i-1][3]*s;
			
			if(dap[i][0]==-2) { //답을 구한적 없으면
				dap[i][0]=x;
			}
			else if(dap[i][0]!=x) { //기존 값과 다르다면
				dap[i][0]=-1;
			}
		}
		
	}

	//마스터 코드에서 해가 되는지 체크해서 리턴하는 함수
	private static boolean check(int r, int c, int s) {
		for (int i = 1; i < m.length; i++) {
			if(m[i][0]!=m[i-1][1]*r+m[i-1][2]*c+m[i-1][3]*s) {
				return false;
			}
		}
			
		return true;
	}

}
