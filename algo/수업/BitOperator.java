package algo_basic.day2;

public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		int status=0;
		int student1=1;
		
		System.out.println((status & student1)>0 ? "참석":"불참");
		//참석처리
		status=status|student1;
		System.out.println((status & student1)>0 ? "참석":"불참");
		
		int student2=0b10;
		
		status=status | student2;
		System.out.println((status & student1)>0 ? "참석":"불참");
		System.out.println(Integer.toBinaryString(status));
		
		int i=3;
		int j=0b01;
		if((i & j)==1) {
			System.out.println("홀수");
		}
		else
			System.out.println("짝수");

	}

}
