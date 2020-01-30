package algo_day4;


import java.util.Arrays;

public class PermutationTest {

	private static char[] str= {'A','B','C','D'};
	public static String src2="667767";
	public static String src3="054060";
	public static String src4="101123";
	public static String[] str_arr= {"667767","054060","101123"};
	public static int[] number_arr= {667767,444345,444456,101123,123123,666666,234};
	
	public static boolean flag=false;
	
	public static void main(String[] args) {
	//src의 원소 중 3개를 선택하는 순열 만들기	
//		makePermutation(3,0,new char[3],new boolean[src.length]);
//		babygin(src2);
//		System.out.println("**");
//		babygin(src3);
//		System.out.println("**");
//		babygin(src4);
		
		//완전탐색 베이비 진
		System.out.println("완전탐색");
		for(int i=0;i<str_arr.length;i++) {
			System.out.println(str_arr[i]+":");
			babygin(str_arr[i]);
		}
		
		
		//탐욕 베이비 진
		System.out.println("탐욕");
		for(int i=0;i<number_arr.length;i++) {
			System.out.println();
			System.out.println(number_arr[i]+":");
			greedBaby(number_arr[i]);
		}
	}
	//탐욕 베이비진 탐색
	//탐욕 베이비 진
	public static void greedBaby(int num) {
		
		int[] count=new int[10];
		int babygin_cnt=0;
		
		for(int i=100000;i>=1;i/=10) {
			count[num/i]++;
			num=num%i;
		}
		System.out.println("count"+Arrays.toString(count));
		
		
		for(int i=0;i<count.length;i++) {
			if(count[i]>=3) {
				babygin_cnt++;
				count[i] -=3;
				i--;
			}
		}
		for(int i=0;i<count.length-3;i++) {
				if((count[i+1]!=0)&&(count[i+2]!=0)&&(count[i]!=0)) {
					babygin_cnt++;
					count[i]--;
					count[i+1]--;
					count[i+2]--;
					i--;
				}
			}
		
		if(babygin_cnt==2) {
			System.out.println(" 베이비 진 O");
		}
		else {
			System.out.println(" 베이비 진 X");
		}
		
	}
	
	
	
	// 완전탐색
	//int r: 몇개를 선택하나요?
	//int current: 현재 진행되고 있는 depth
	//char[] temp: 선택된 요소들
	//boolean[] visited: 방문이력
	public static void makePermutation(int r, int current, int[] temp, boolean[] visited,int[] src) {
		
		if(current==r) {
//			System.out.println(Arrays.toString(temp));
			isBabygin(temp);
			return;
		}
		else {
			//사용가능요소가 있다면 다음 재귀 호출
			for(int i=0; i<src.length;i++) {
				if(!visited[i]) {			//방문체크
					visited[i]=true;		//방문처리
					temp[current]=src[i];	//사용
					makePermutation(r, current+1, temp, visited,src);
					visited[i]=false;
				}
			}
		}
		
	}
	
	//완전탐색 베이비 진
	public static boolean isBabygin(int[] num_array) {
		int[] arr1= {num_array[0],num_array[1],num_array[2]};
		int[] arr2= {num_array[3],num_array[4],num_array[5]};
		
		
		if((isRun(arr1)||isTriplet(arr1))&&(isRun(arr2)||isTriplet(arr2))) {
//			System.out.println("베이비진 O");
			flag=true;
			return true;
			
		}
		else {
//			System.out.println("베이비진 x");
			return false;
		}
		
		
		
	}
	public static boolean isRun(int[] array) {
		for(int i=0; i<array.length-1;i++) {
			if(array[i]+1!=array[i+1]) {
				return false;
			}
		}
		return true;
		
	}
	public static boolean isTriplet(int[] array) {
		for(int i=0; i<array.length-1;i++) {
			if(array[i]!=array[i+1]) {
				return false;
			}
		}
		return true;
		
	}
	public static void babygin(String str2) {
		int num_array[]=new int[6];
		flag=false;
		
		for(int i=0;i<6;i++) {
			num_array[i]=str2.charAt(i)-'0';
		}
		
		makePermutation(6,0, new int[6], new boolean[num_array.length],num_array);
		
		
		if(flag) {
			System.out.println("베이비진 O");
		}
		else {
			System.out.println("베이비진 x");
		}
		
	}

}
