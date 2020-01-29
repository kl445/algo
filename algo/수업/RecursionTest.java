package algo_day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.StringCharacterIterator;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RecursionTest {

	public static void main(String[] args) {
		recur2(8);
	}
	
	public static void recur2(int k) {
		
		if(k==0) {
			System.out.println("재귀종료");
			return;
		}
		else {
			System.out.println("before: "+k);
			recur2(k-1);
			System.out.println("after: "+k);
		}
	}
	
	public void recur3(int k, int n, int[] arr) {
		if(k==n) {
			return;
		}
		arr[0]=k;
		System.out.println(k+" : "+arr[0]);
		recur3(k+1,n,arr);
		
		arr[0]=k;
		System.out.println(k+" : "+arr[0]);
	}
	
	@Test
	public void recur3Test() {
		int[] arr= new int[1];
		recur3(0,3,arr);
	}
	
	public int getMult(int n, int m) {
		if(n==m) {
			return m;
		}
		else {
			return n*getMult(n+1,m);
		}
	}
	
	@Test
	public void getMultTest() {
		System.out.println(getMult(1, 4));
//		assertEquals(getMult(3, 4), 10);
	}
	
	//재귀 제곱
	public int getMult2(int n, int m) {
		if(n==1) {
			return m;
		}
		else {
			return m*getMult2(n-1,m);
		}
	}
	
	@Test
	public void getMult2Test() {
		System.out.println(getMult2(4, 2));
//		assertEquals(getMult(3, 4), 10);
	}
	
	//재귀 10진수 자리 더하기
	public void getDigitSum(int n, int sum) {
		if(n<=0) {
			System.out.println(sum);
		}
		else {
			getDigitSum(n/10,sum+n%10);
		}
	}
	
	@Test
	public void getDigitSum() {
		getDigitSum(52155,0);
	}
	
	//재귀 10진수 자리 더하기
	public int getLen(String str) {
		
		
		if(str.equals("")) {
			return 0;
		}
		else {
			return 1+getLen(str.substring(1));
		}
	}
	
	@Test
	public void getLenTest() {
		System.out.println(getLen("strike"));
	}
	
	//문자열 거꾸로 출력하기
	public void reverseStr(String str) {
		
		
		if(str.substring(1).equals("")) {
			System.out.print(str.charAt(0));
		}
		else {
			reverseStr(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	
	@Test
	public void reverseStrTest() {
		reverseStr("pop");
	}
	
	//문자열 거꾸로 출력하기
	public void tenTotwo(int num) {
		
		
		if(num/2==0) {
			System.out.print(num%2);
		}
		else {
			tenTotwo(num/2);
			System.out.print(num%2);
		}
	}
	
	@Test
	public void tenTotwoTest() {
		tenTotwo(13);
	}
	
	//합 구하기
	public int sumArray(int array[],int n) {
	
		if(n==0) {
			return array[n];
		}
		else {
			return array[n]+sumArray(array, n-1);
		}
	}
	
	@Test
	public void sumArrayTest() {
		int[] array= {2,5,8,9,1};
//		int[] array= {2,5,9,1,8,3,7,6};
		System.out.println(sumArray(array,array.length-1));
	}
	
	//최대값 구하기
	public int maxArray(int array[],int n) {
		
		if(n==0) {
			return array[n];
		}
		else {
			return Math.max(array[n],maxArray(array, n-1));
		}
	}
	
	@Test
	public void maxArrayTest() {
//		int[] array= {2,5,8,9,5568,1,88898};
		int[] array= {2,5,9,1,8,3,7,6,10,22};
		System.out.println(maxArray(array,array.length-1));
	}
	
	//바이너리서치
	public int binarySearch(int array[],int start,int end,int target) {
		
//		Arrays.sort(array);
		int mid=(start+end)/2;
		if(start>end) {
			return -1;
		}
		else {
			if(array[mid]==target) {
				return mid;
			}
			else if(array[mid]>target) {
				return binarySearch(array, start, mid-1, target);
			}
			else {
				return binarySearch(array, mid+1, end, target);
			}
		}
	}
	
	@Test
	public void binarySearchTest() {
//		int[] array= {2,5,8,9,5568,1,88898};
		int[] array= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(array,0,array.length-1,10));
	}
	
	//팰린드롬
	public boolean palindrome(String str,int from,int to) {
		
		if(from==to) {
			return true;
		}
		else if(from+1==to) {
			return str.charAt(from)==str.charAt(to);
		}
		else {
			return str.charAt(from)==str.charAt(to) &&palindrome(str, from+1,to-1);
		}
	}
	
	@Test
	public void palindromeTest() {
		String str="소주주소";
		String str2="소주만병만주소";
		String str3="가나다라마바사";
		System.out.println(palindrome(str,0,str.length()-1));
		System.out.println(palindrome(str2,0,str2.length()-1));
		System.out.println(palindrome(str3,0,str3.length()-1));
	}
	

}
