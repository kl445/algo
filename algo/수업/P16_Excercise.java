package algo_basic.day1;

import org.omg.CORBA.PRIVATE_MEMBER;

public class P16_Excercise {

	private static int[] src= {7,4,2,0,0,6,0,7,0};
	
	public static void main(String[] args) {
		
		
		int max=0;
		for (int i = 1; i < src.length; i++) {
			int count=0;
			for (int j = 0; j < src.length; j++) {
				if(src[i]>src[j])
					count++;	
			}
			if(max<count)
				max=count;
			
		}
		System.out.println(max);
		
		
	}

}
