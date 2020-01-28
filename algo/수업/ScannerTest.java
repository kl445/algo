package algo_basic.day1.io;
import java.util.*;


public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		read0();
//		read1();
//		read2();
//		read3();
		read4();
		
	}
	
	public static void read0() {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			System.out.println(str);
		}
		
	}
	public static void read1() {
		//1+1 이라는 입력을 받아서 연산해보기
		Scanner sc= new Scanner(System.in);
		int num1, num2;
		
		num1= sc.nextInt();
		String oper= sc.next();
		num2= sc.nextInt();
		
		System.out.println(num1+num2);
		
	}
	public static void read2() {
		//1+1 이라는 입력을 받아서 연산해보기
		String src="110 + 200";
		Scanner sc= new Scanner(System.in);
		sc=new Scanner(src);
		int num1, num2;
		num1= sc.nextInt();
		String oper= sc.next();
		num2= sc.nextInt();
		
		System.out.println(num1+num2);
		
	}
	public static void read3() {
		//반복문을 이용하고 숫자가 아닌것이 들어오면 종료시키기
		String src="100 200 300 400 x";
		Scanner sc= new Scanner(System.in);
		sc=new Scanner(src);
		int num,sum;
		sum=0;
		
		while(sc.hasNextInt()) {
			num=sc.nextInt();
			sum+=num;
		}
		
		System.out.println(sum);
		
	}
	public static void read4() {
		//구분자의 활용
		String src="100, 200, 300, 400";
		Scanner sc= new Scanner(System.in);
		sc=new Scanner(src);
		sc.useDelimiter(", ");
		int num,sum;
		sum=0;
		
		while(sc.hasNextInt()) {
			num=sc.nextInt();
			sum+=num;
		}
		
		System.out.println(sum);
		
	}

}
