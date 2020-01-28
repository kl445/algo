package algo_basic.day1.io;

import sun.print.resources.serviceui;

public class StringSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		split1();
//		split2();
//		split3();
		split4();
	}
	
	public static void split1() {
		String src= "10,20,30";
		String [] splited = src.split(",");
		int sum=0;
		for (int i = 0; i < splited.length; i++) {
			sum+=Integer.parseInt(splited[i]);

		}
		System.out.println(sum);
	}
	public static void split2() {
		String src= "10.20.30";
//		String [] splited = src.split("."); //정규표현식에서 .는 어떤 문자 하나를 나타냄 ->예외처리 필요
		String [] splited = src.split("\\."); //예외처리 필요
		int sum=0;
		for (int i = 0; i < splited.length; i++) {
			sum+=Integer.parseInt(splited[i]);
			
		}
		System.out.println(sum);
	}
	
	public static void split3() {
		//이름과 총점을 출력하세요
		
		String src= "이름:홍길동,java:100,HTML:80,Script:85";
		
		String temp[];
		String name;
		int score = 0;
		
		temp=src.split(",");
		name=temp[0].split(":")[1];
		
		for (int i = 1; i < temp.length; i++) {
//			System.out.println(Integer.parseInt(temp[i].split(":")[1]));
			score +=(Integer.parseInt(temp[i].split(":")[1]));
		}
		
		System.out.println(name+":"+score);
		
	}
	public static void split4() {
		//이름과 총점을 출력하세요
		
		String src= "이름:홍길동,java:100,HTML:80,Script:85";
		
		String temp[];
		String name;
		int score = 0;
		
		temp=src.split(",|:");
		name=temp[1];	
		for (int i = 3; i < temp.length; i+=2) {
//			System.out.println(Integer.parseInt(temp[i].split(":")[1]));
			score +=(Integer.parseInt(temp[i]));	
		}
		System.out.println(name+":"+score);
		
	}

}
