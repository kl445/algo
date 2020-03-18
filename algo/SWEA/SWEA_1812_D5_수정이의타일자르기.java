package com.ssafy.step06.prioriqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1812_D5_수정이의타일자르기 {

	static class Rectangle implements Comparable<Rectangle>{
		
		int min, max;
		public Rectangle(int x, int y) {
			if(x<y) {
				min=x;
				max=y;
			}else {
				min=y;
				max=x;
			}
		}
		@Override
		public int compareTo(Rectangle o) {
			// TODO Auto-generated method stub
			return o.min-this.min;
		}
		
	}
	static int N,M, size[],cnt;
	static PriorityQueue<Rectangle> que;
	public static void main(String[] args) throws Exception{

		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			size=new int[N];
			
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				size[i]=Integer.parseInt(st.nextToken());
			} //만들고자 하는 정사각형의 크기 입력 (k);
			cnt=0;
			cut();
			sb.append(cnt);
			System.out.println(sb.toString());
		}
	}
	
	private static void cut() {
		//가장 큰 크기의 정사각형 부터 만들기
		Arrays.sort(size);
		que= new PriorityQueue<Rectangle>();
		que.offer(new Rectangle(M, M));
		++cnt;
		
		for (int i =N-1; i >=0; i--) {
			go(1<<size[i]);
		}
	}
	
	private static void go(int size) {
		//queue에서 poll(): min값이 최대인 직사각형이 뽑아짐
		//직사각형의 최소변의 길이가 size보다 같거나 크면 : 원하는 크기의 정사각형을 만들 수  있음
		Rectangle r= que.poll();
		if(r.min>=size) {
			que.offer(new Rectangle(r.min-size, size));
			que.offer(new Rectangle(r.min, r.max-size));
		}
		else{//아니면: 원하는 크기의 정사각형을 만들 수 없음
			que.offer(r);
			que.offer(new Rectangle(M-size, size));
			que.offer(new Rectangle(M, M-size));
			++cnt;
		}
	}

}
