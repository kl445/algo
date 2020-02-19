		package algo_ad.day1;
		
		import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.StringReader;
	import java.util.Scanner;
	import java.util.StringTokenizer;
		
		public class BOJ_10972_다음순열 {
		
			public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub
				
				
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				
				int tc= Integer.parseInt(br.readLine());
				
				StringTokenizer tk= new StringTokenizer(br.readLine());
				
				
	//			Scanner sc =new Scanner(System.in);
				
	//			int tc= sc.nextInt();
				
				
				int[] array=new int[tc];
				for (int i = 0; i < tc; i++) {
	//				array[i]=sc.nextInt();
					
					array[i]=Integer.parseInt(tk.nextToken());
				}
				
				array=nextPerm(array);
				
				if(array[0]==-1) {
					System.out.println("-1");
				}
				
				else {
					for (int i = 0; i < array.length; i++) {
						System.out.print(array[i]+" ");
					}
				}
				
			
		
			}
			public static void swap(int[] array,int a, int b) {
				int temp=array[a];
				array[a]=array[b];
				array[b]=temp;
			}
			public static int[] nextPerm(int[] array) {
				
				int[] res= new int[array.length];
				res[0]=-1;
				
				int i;
				for (i = array.length-2	; i >=0; i--) {
					if(array[i]<array[i+1]) {
						break;
					}
				}
				if(i<0){
					return res;
				}
				int j;
				for ( j = array.length-1; j >=0; j--) {
					if(array[j]>array[i]) {
						break;
					}
				}
				
				swap(array,i,j);
				
				for (int a = i+1,b=array.length-1; a <b; a++,b--) {
					swap(array,a,b);
					
				}
				
				res=array;
				return res;
				
			}
			
			
		
		}
