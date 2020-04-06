package algo.hw0403;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9659_D4_다항식계산 {

	static int N, M;
	static int[] T, A,B,X;
	static long[] F;
	static long p=998244353L;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();

		for (int t = 0; t < tc; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t+1);
			
			N=sc.nextInt();
			T=new int[N+1];
			A=new int[N+1];
			B=new int[N+1];
		
			
			//입력
			for (int i = 2; i <= N; i++) {
					T[i]=sc.nextInt();
					A[i]=sc.nextInt();
					B[i]=sc.nextInt();
			}
			M=sc.nextInt();
			X=new int[M+1];
			
			
			//x를 받고 계산후 sb에 추가
			for (int j = 1; j <= M; j++) {
				int x =sc.nextInt();
				
				F=new long[N+1];
				Arrays.fill(F, -1);
				F[0]=1L;
				F[1]=x;
				//입력받은 x의 Fn(x)를 구하기 위해 F2(x)~Fn(x)실행
//				for (int i = 2; i <=N; i++) {
//					switch (T[i]) {
//					case 1:
//						type1(i);
//						break;
//					case 2:
//						type2(i);
//						break;
//					case 3:
//						type3(i);
//						break;
//
//					default:
//						break;
//					}
//				}
				long ans=type(N);
//				sb.append(" ").append(F[N]);
				sb.append(" ").append(ans%p);
			}
			System.out.println(sb.toString());
		}

	}
	
	static long type(int i) {
		if(i==0) {
			return F[0];
		}
		else if(i==1){
			return F[1];
		}
		else if(F[i]>=0L) {
			return F[i];
		}
		else {
			if(T[i]==1) {
				F[i]=type(A[i])%p+type(B[i])%p;
			}
			else if(T[i]==2) {
				F[i]=(A[i]%p*type(B[i])%p)%p;
			}
			else if(T[i]==3) {
				F[i]=((type(A[i])%p) *(type(B[i])%p))%p;
			}
		}
		return F[i]%p;
	}
	//ti 1일떄
	static void type1(int i){
		
		F[i]=(F[A[i]]%p+F[B[i]]%p);
		
	}//ti 2일떄
	static void type2(int i){
		
		F[i]=(A[i]%p*F[B[i]]%p);
		
	}//ti 3일때
	static void type3(int i){
		
		F[i]=(F[A[i]]%p*F[B[i]]%p);
		
	}

}
