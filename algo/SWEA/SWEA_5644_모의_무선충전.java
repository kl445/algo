package algo.hw0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 사용자 시뮬돌리기 0~M
 * 각 단계별 배터리 충전 비교 및 누적,
 * 각 단계별 현재 접근한 bc별 인원수 체크
 * 가능한 최대의 배터리량 충전
 * 겹치지 않는경우 각자의 bc량 충전
 * 두 사람 모두 하나의 bc에 겹치는 경우 -분할 충전
 * 두 사람 모두 하나의 bc에 겹치면서 한사람은 다른 bc에 겹치는경우 안겹치게 충전
 * 두사람 모두 하나의 bc에 겹치면서 둘다 다른 bc에 겹치는 경우 겹치는 bc중 최대값 충전
 */
public class SWEA_5644_모의_무선충전 {

	//전체 맵
	static int[][] map=new int[10][10];
	static int M,A;
	//사람들의 이동경로
	static int move[][];
	//충전소와 연결여부
	static boolean visited[][] ;
	
	//총 충전량
	static int charge;
	static BC[] bc;
	
	static class Player{
		int r;
		int c;
		public Player(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Player [r=" + r + ", c=" + c + "]";
		}
		
	}
	static class BC implements Comparable<BC>{
		int r;
		int c;
		int range;
		int power;
		@Override
		public String toString() {
			return "BC [r=" + r + ", c=" + c + ", range=" + range + ", power=" + power + "]";
		}
		
		public BC(int r, int c, int range, int power) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			
			return Integer.compare(this.power, o.power)*-1;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(input.readLine());
		
		int TC=Integer.parseInt(tk.nextToken());
		
		for (int tc = 0; tc < TC; tc++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(tc+1).append(" ");
			
			
			tk=new StringTokenizer(input.readLine());
			
			M=Integer.parseInt(tk.nextToken());
			A=Integer.parseInt(tk.nextToken());
			
			bc=new BC[A];
			move=new int[M][2];
			charge=0;
			visited=new boolean[A][2];
			tk=new StringTokenizer(input.readLine());
			for (int i = 0; i <M; i++) {
				move[i][0]=Integer.parseInt(tk.nextToken());
			}
			tk=new StringTokenizer(input.readLine());
			for (int i = 0; i <M; i++) {
				move[i][1]=Integer.parseInt(tk.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				tk=new StringTokenizer(input.readLine());
				
				int c=Integer.parseInt(tk.nextToken())-1;
				int r=Integer.parseInt(tk.nextToken())-1;
				int range=Integer.parseInt(tk.nextToken());
				int power=Integer.parseInt(tk.nextToken());
				
				bc[i]=new BC(r, c, range, power);
			}
			
			Player p1=new Player(0, 0);
			Player p2=new Player(9, 9);
			
			
//			System.out.println("step:0 ");
			getPower(p1, p2);
//			System.out.println("charge"+charge);
//			System.out.println("*******************");
			for (int i = 0; i < M; i++) {
			
				go(p1, move[i][0]);
				go(p2, move[i][1]);
//				System.out.println("step"+(i+1)+" p1:"+p1.r+","+p1.c+" p2:"+p2.r+","+p2.c);
				getPower(p1, p2);;
//				System.out.println("charge:"+charge);
//				System.out.println("*******************");
			
		
			}
			
			

			
			sb.append(charge);
			System.out.println(sb.toString());
			
		}
	
		

	}
	


	private static void getPower(Player p1, Player p2) {
		
		visited=getDistance(p1,p2);
//		visited=getDistance(p2);
		
		PriorityQueue<BC> pq1=new PriorityQueue<>();
		PriorityQueue<BC> pq2=new PriorityQueue<>();
		
		for (int i = 0; i < A; i++) {
			if(visited[i][0]) {
				pq1.offer(bc[i]);
			}
			if(visited[i][1]) {
				pq2.offer(bc[i]);
			}
			
		}
		
		BC temp1=pq1.poll();
		BC temp2=pq2.poll();
		
		
		if(temp1==null) {
			temp1=new BC(0, 0, 0, 0);
		}
		if(temp2==null) {
			temp2=new BC(0,0,0,0);
		}
		
//		System.out.print(" BC1 "+temp1);		
//		System.out.println(" BC2 "+temp2);
//		System.out.print(" BC1_2 "+pq1.peek());
//		System.out.println(" BC1_2 "+pq2.peek());
		if(!temp1.equals(temp2)) {
			if(temp1!=null) {
				charge+=temp1.power;
			}
			if(temp2!=null) {
				charge+=temp2.power;
			}
			
		}
		else {
			
			if(pq1.size()==0 && pq2.size()==0) {
				charge+=temp1.power;
			}
			else if(pq1.size()==0){
				charge+=temp1.power+pq2.peek().power;
			}
			else if(pq2.size()==0) {				
				charge+=temp2.power+pq1.peek().power;
			}
			else {
				charge+=temp1.power+Math.max(pq1.peek().power, pq2.peek().power);
				
			}
			
			
			
		}
		
		
		
	}



	private static boolean[][] getDistance(Player p1,Player p2) {
		boolean [][] v=new boolean[A][2];
		
		for (int j = 0; j < A; j++) {
			int d_r=bc[j].r-p1.r;
			int d_c=bc[j].c-p1.c;
			
			int dist=Math.abs(d_r)+Math.abs(d_c);
			if(dist<=bc[j].range) {
				v[j][0]=true;
			}
			else {
				v[j][0]=false;
			}
			 d_r=bc[j].r-p2.r;
			 d_c=bc[j].c-p2.c;
			
			 dist=Math.abs(d_r)+Math.abs(d_c);
			if(dist<=bc[j].range) {
				v[j][1]=true;
			}
			else {
				v[j][1]=false;
			}
		}
		return v;
		
	}



	static void go(Player player,int type) {
		switch (type) {
		
		case 0://정지
			return ;
		case 1://상
			player.r--;
			return;
		case 2://우
			player.c++;
			return;
		case 3://하
			player.r++;
			return;
		case 4://좌
			player.c--;
			return;
			
		default:
			break;
		}
	}

}
