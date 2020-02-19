package algo_ad.day1;

import java.math.BigDecimal;

public class ChangeNotatipon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=341;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
		System.out.println();
		
		int numbit=0b101010101;
		System.out.println(Integer.toString(numbit,10));
		System.out.println(Integer.toString(numbit,8));
		System.out.println(Integer.toString(numbit,16));
		
		double d1= 2.0;
		double d2= 1.1;
		System.out.println((d1*10-d2*10)/10);
		
		BigDecimal bd1=new BigDecimal(d1+"");
		BigDecimal bd2=new BigDecimal(d2+"");
		System.out.println(bd1.subtract(bd2));
		
	}

}
