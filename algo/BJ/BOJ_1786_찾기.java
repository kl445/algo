package algo.hw0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1786_찾기 {

	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String origin = br.readLine();
		String pattern = br.readLine();
		kmp(origin, pattern);
		System.out.println(cnt);
		System.out.println(sb.toString());

	}

	// pi획득
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];

		// j 인덱스
		int j = 0;

		// i 인덱스는 1부터
		for (int i = 1; i < pi.length; i++) {
			// j가 0이상일때 and j와 i의 문자 값이 다를때
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = pi[j - 1]; // j보다 1작은 pi의값을 j에 리턴
			}
			// i와 j의 문자가 같을때
			if (pattern.charAt(j) == pattern.charAt(i)) {
				pi[i] = ++j;
			}
		}

		return pi;

	}

	static void kmp(String origin, String pattern) {
		int[] pi = getPi(pattern);

		int j = 0;
		// 원래 문자열을 다 돌때까지
		for (int i = 0; i < origin.length(); i++) {

			// j가 0이상일때 and j와 i의 문자 값이 다를때
			while (j > 0 && pattern.charAt(j) != origin.charAt(i)) {
				j = pi[j - 1]; // j보다 1작은 pi의값을 j에 리턴
			}
			
			//서로 문자열이 같다면
			if(origin.charAt(i)==pattern.charAt(j)) {
				
				//j가 패턴의 끝에 도달한 경우 패턴이 존재
				if(j==pattern.length()-1) {
					cnt++;
					sb.append(i-pattern.length()+2);
					sb.append(" ");
					
					//현재의 패턴지점으로 돌아감
					j = pi[j];
				}
				//아니라면 다음 index 증가
				else {
					j++;
				}
			}

		}

	}

}
