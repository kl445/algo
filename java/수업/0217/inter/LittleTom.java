package com.inter;

class Bill{}
class Tom{
	int age=50;
}
interface Hillary{
	
	//인터페이스안의 필드 -> static public final		
	int age=46;
}

public class LittleTom extends Tom implements Hillary{
	int age=20;
	
	public void test() {
		System.out.println(age);		//리틀톰
		System.out.println(this.age);	//리틀톰
		System.out.println(super.age);	//톰
		System.out.println(Hillary.age);			//힐러리
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LittleTom little =new LittleTom();
		
		
		//instanceof 활용법 : 범위가 작은 클래스를 먼저 물어보고  else if 사용
		
		//instaancof 생성한 객체가 클래스에 포함되어 있는지 판단
		if(little instanceof Tom) {
			System.out.println("instance of Tom");
		}
		if(little instanceof Hillary) {
			System.out.println("instace of Hillary");
		}
		
		if(little instanceof LittleTom) {
			System.out.println("instacne of LittleTome");
			
		}
		if(little instanceof Object) {
			System.out.println("instacne of Object");
			
		}
//		if(little instanceof Bill) {
//			System.out.println("instacne of Bill");
//			
//		}
		
		little.test();
		
	}

}
