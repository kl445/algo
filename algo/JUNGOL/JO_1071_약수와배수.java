package swea_0212;

import java.util.Scanner;

public class JO_1071_약수와배수 {

	public static void main(String[] args) {


		 Scanner sc = new Scanner(System.in);
		 
		 int tc= sc.nextInt();
		 
		 int arr[]=new int[tc];
		 
		 for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		 
		 int m=sc.nextInt();
		 
		 int num1=0;
		 int num2=0;
		 
		 for (int i = 0; i < arr.length; i++) {
			if(m%arr[i]==0) {
				num1+=arr[i];
			}
			if(arr[i]%m==0) {
				num2+=arr[i];
			}
		}
		 
		 System.out.println(num1);
		 System.out.println(num2);
		 
	

	}

}
