package algo_basic.day1.io;

public class OutputTest {
	
	public static void main(String[] args) {
		
//		printGugu5();
		printGugu5_2();
		
	}
	
	public static void printGugu5() {
		for (int i = 1; i < 10; i++) {
			System.out.println(i*5);
		}
	}
	
	public static void printGugu5_2() {
		//String 은 추가/수정/삭제 연산하지 않는다.
		StringBuilder sb= new StringBuilder(); 
		
		for (int i = 1; i < 10; i++) {
//			System.out.println(i*5);
			sb.append(i*5).append("\t");
		}
		
		System.out.println(sb);
	}
	
	
}
