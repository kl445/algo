package algo_ad.day1;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String src= "이름:홍길동,Java:100,HTML:80,Script:85";
		
		
		//src를 쪼갤 delimiter: 구분자는 문자열이 아니라 문자단위
		StringTokenizer tokens= new StringTokenizer(src,":,");
		
		
		
		System.out.println("토큰 개수 " +tokens.countTokens());
		
		tokens.nextToken();
		String name=tokens.nextToken();
		
		
		
		int sum=0;
		while(tokens.hasMoreTokens()){
			tokens.nextToken();
			sum+=Integer.parseInt(tokens.nextToken());
		}
		String jaba= tokens.nextToken();
		
		String html =tokens.nextToken();
		
		
	}

}
