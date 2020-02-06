package algo_day6;

import java.util.LinkedList;
import java.util.Queue;

public class Mychu {

	static int CHU=20;
	static class customer {
		int pre;
		int sum;
		int num;

		public customer(int pre, int sum,int num) {
			this.pre = pre;
			this.sum = sum;
			this.num = num;
		}

		@Override
		public String toString() {
			return "[  num=" + num +" pre=" + pre + "]";
		}
	}

	public static void main(String[] args) {

		Queue<customer> qu = new LinkedList<>() ;
		
		int chu=CHU;
		int num=1;
		int chu_total=0;
		int chu_else=0;
		
		while(true) {
			qu.offer(new customer(0, 0,num++));
			
			System.out.println("현재 큐 상태 : "+qu);
			customer cus=qu.poll();
			cus.pre++;
			chu-=cus.pre;
			chu_total+=cus.pre;
			cus.sum +=cus.pre;
			
			if(chu<=0){
				System.out.println(cus.num+"번 손님 "+(CHU-chu_else)+"개 총"+cus.sum+"개 전체 마이쮸:"+ CHU+"개");				
				System.out.println("마지막 마이쮸를 가져간 사람:"+cus.num);
				break;
			}
			System.out.println(cus.num+"번 손님 "+cus.pre+"개 총"+cus.sum+"개 전체 마이쮸:"+ chu_total+"개"+"남은 사람 "+qu.size()+"명");
			System.out.println();
			chu_else=chu_total;
			qu.offer(cus);
			 
		}

	}

}
