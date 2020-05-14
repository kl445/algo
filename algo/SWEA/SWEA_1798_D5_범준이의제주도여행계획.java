package algo.hw0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1798_D5_범준이의제주도여행계획 {

	static int N,M;

	//정점 연결 그래프
	static int[][] graph;
	static StringBuilder sb=new StringBuilder();
	
	//관리할 지점들..
	static Point airport;
	static List<Point> hotels;
	static List<Point> tourSpots;
	
	//최대 만족도
	static int maxSatis;
	static List<Integer> maxSatisPath;
	
	//탐색에 사용할 임시 경로
	static Stack<Integer> tempPath;
	
	static class Point{
		String type; //A H  P
		int idx;
		int playTime;
		int satis;
		Point nearH;
		
		public Point(String type, int idx) {
			this(type,idx,0,0);
		}

		public Point(String type, int idx, int playTime, int satis) {
			super();
			this.type = type;
			this.idx = idx;
			this.playTime = playTime;
			this.satis = satis;
		}

		@Override
		public String toString() {
			return "Point [type=" + type + ", idx=" + idx + ", playTime=" + playTime + ", satis=" + satis + "]";
		}
		
		
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in) );
		StringTokenizer tk=null;
		
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			sb.append("#").append(t+1);
			
			tk=new StringTokenizer(br.readLine());
			N=Integer.parseInt(tk.nextToken());
			M=Integer.parseInt(tk.nextToken());
			
			graph=new int[N+1][N+1];
			
			//1. 그래프 소요 시간 입력
			for (int i =1; i < N; i++) {
				
				tk=new StringTokenizer(br.readLine());
				for (int j = i+1; j < N+1; j++) {
					graph[i][j]=Integer.parseInt(tk.nextToken());
					graph[j][i]=graph[i][j];
				}
				
			}
			
			
			//2. 지점 정보 가져오기
			tourSpots=new ArrayList<>();
			hotels=new ArrayList<>();
			
			for (int i = 1; i < N+1; i++) {
				tk=new StringTokenizer(br.readLine());
				String token=tk.nextToken();
				
				if(token.equals("A")) {
					airport=new Point(token, i);
				}
				else if(token.equals("H")) {
					hotels.add(new Point(token, i));
				}
				else {
					int playTime=Integer.parseInt(tk.nextToken());
					int satis=Integer.parseInt(tk.nextToken());
					
					tourSpots.add(new Point(token, i,playTime,satis));
					
				}
				
			}
			
			
//			for (int i = 0; i < N; i++) {
//					System.out.println(Arrays.toString(graph[i]));
//			}
//			System.out.println();

			
			
			//3.관광지에 가장 가까운 호텔정보 설정- grpah
			for(Point p:tourSpots) {
				
				int min=Integer.MAX_VALUE;
				for (Point h : hotels) {
					if((graph[p.idx][h.idx]<min)) {
						min=graph[p.idx][h.idx];
						p.nearH=h;
					}
				}
			}
//			System.out.println("니어 호텔");
//			for (Point p : tourSpots) {
//				System.out.println(p+": "+p.nearH);
//			}
			
			//4. 여행준비
			maxSatis=Integer.MIN_VALUE;
			tempPath=new Stack<>();
			
			//sol(); 솔루션
			sol(0,airport,0,0,new boolean[N+1]);
			
			
			//5.결과 출력
			sb.append(" ");
			if(maxSatis==Integer.MIN_VALUE) {
				sb.append(0);
			}
			else {
				sb.append(maxSatis).append(" ");
				for (int i : maxSatisPath) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		
			
			
			
			
		}
		System.out.println(sb);
	}

	private static void sol(int day,Point start, int satis,int time,boolean[] visited) {
		
		//종료조건?
		if(day==M) {
			
			if(satis>maxSatis) {
				maxSatis=satis;
				
				//최대만족도에서의 경로
				maxSatisPath=new ArrayList<>(tempPath);
			}
			return;
		}
		
		//일반 탐색.
		boolean canGoNext=false;
		
		for (Point point : tourSpots) {
			//갈 수 있는 지점들을 찾아서 계속 돌아다닌다.
			if(!visited[point.idx]) {
				//미방문이라면 해당 지점을 방문할 수 있는지 계산
				int tempTime=time + graph[start.idx][point.idx]+point.playTime;
				if(day==M-1) {
					tempTime+=graph[point.idx][airport.idx];
				}
				else {
					tempTime+=graph[point.idx][point.nearH.idx];
					
				}
				
				if(tempTime>540) {
					continue;
				}
				else {
					canGoNext=true;
					visited[point.idx]=true;
					tempPath.push(point.idx);
					sol(day, point, satis+point.satis, time + graph[start.idx][point.idx]+point.playTime, visited);
					
					//백하는경우
					tempPath.pop();
					visited[point.idx]=false;
				}
			}
		}
		
		//관광지로 못가면 날자에 따라 호텔/공항으로 이동
		if(!canGoNext) {
			if(day==M-1) {
				tempPath.push(airport.idx);
				sol(day+1, airport, satis, 0, visited);
				tempPath.pop();
				
			}
			else {
				for (Point hotel : hotels) {
					if(time+graph[start.idx][hotel.idx]<=540) {
						tempPath.push(hotel.idx);
						sol(day+1, hotel, satis, 0, visited);
						tempPath.pop();
					}
				}
			}
		}
		
	}

}
