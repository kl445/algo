package swea_0212;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_3052_나머지 {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		int array[]= new int[10];
		
		
		
		for (int i = 0; i < array.length; i++) {
			array[i]=sc.nextInt()%42;
			
		}
		Arrays.sort(array);
		int start=array[0];
		int cnt=1;
		for (int i = 1; i < array.length; i++) {
			if(start!=array[i]) {
			cnt++;
			start=array[i];
		}
		}
		System.out.println(cnt);

	}

}
