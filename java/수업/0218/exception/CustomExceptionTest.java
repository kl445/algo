package com.exception;

// 사용자 정의 예외 클래스는 Exception을 상속받아야한다
class YourException extends Exception{
	String message;

	public YourException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "YourException [message=" + message + "]";
	}
}

class MyException extends Exception{ 
	String message;

	public MyException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
}


public class CustomExceptionTest {
	
	public void check(int num) throws MyException {
		if(num>0) {
			System.out.println("result: "+ ++num);	//정상
		}
		else {	//비정상, 예외
			throw new MyException("파라미터는 양의 정수로 입력");
		}
	}
	
	public int work(int num1, int num2) throws YourException {
		//mnum1이  num2보다 크면 정상 
		if(num1>num2) {
			System.out.println("num1 is big");
			return num1-num2;
		}else {
			throw new YourException("num1이 num2보다 커야 합니다.");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomExceptionTest c= new CustomExceptionTest();
		try {
			
			c.check(-8);
			
		}catch (MyException e) {
			System.out.println(e);
		}
		
		try{
			System.out.println(c.work(1, 3));
		}catch (YourException n) {
		
			System.out.println(n);
		}
		
		

		System.out.println("End");
	}

}
