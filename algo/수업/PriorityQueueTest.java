package algo_day6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<String> pq= new PriorityQueue<>();
		pq= new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer num1=o1.length();
				Integer num2=o2.length();
				if(num1==num2) {
					return o1.compareTo(o2);
				}
				return num1.compareTo(num2);
			}
		});
		
		pq.offer("true");
		pq.offer("my");
		pq.offer("dream");
		pq.offer("is");
		pq.offer("come");

		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
