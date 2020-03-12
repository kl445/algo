package algo.hw0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_7701_D4_염라대왕의이름정렬 {

	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine());
		
		
		
		int tc =Integer.parseInt(tk.nextToken());
		for (int t = 0; t < tc; t++) {
			StringBuilder sb= new StringBuilder();
			
			sb.append("#").append(t+1).append("\n");
			
			tk=new StringTokenizer(br.readLine());
			N=Integer.parseInt(tk.nextToken());
			PriorityQueue<String> pq= new PriorityQueue<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Integer range1=o1.length();
					Integer range2=o2.length();
					if(range1.equals(range2)) {
						return o1.compareTo(o2);
					}
					return range1.compareTo(range2);
				}
			});
			
			TreeSet<String> set= new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Integer range1=o1.length();
					Integer range2=o2.length();
					if(range1==range2) {
						return o1.compareTo(o2);
					}
					return range1.compareTo(range2);
				}
			});
			
			//입력
			for (int i = 0; i < N; i++) {
				tk=new StringTokenizer(br.readLine());
				String str= tk.nextToken();
				
				pq.add(str);
			}
			
			//set 내용을 우선순위 큐에 삽입 
//			Iterator<String> it = set.iterator();
//			while(it.hasNext() ) {
////				pq.add(it.next());
//				sb.append(it.next()).append("\n");
//
//			}
			String str2 = "";
			 while(!pq.isEmpty()) {
				 String str3=pq.poll();
				 if(str2.equals(str3)) {
					 continue;
				 }
	                sb.append(str3).append("\n");
	                str2=str3;
	            }
			
			System.out.print(sb.toString());

		}
		
	}

}
