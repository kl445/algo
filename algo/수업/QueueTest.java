package algo_day6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<Integer> queue =new LinkedList<>();

		// 데이터 넣기
		
		queue.offer(1);
		queue.add(2);
		
		queue.offer(1);
		queue.add(2);
		
		//확인
		System.out.println(queue.peek()+" : "+queue.size());
		System.out.println(queue.element()+" : "+queue.size());
		
		//삭제
		System.out.println(queue.poll()+" : "+queue.size());
		System.out.println(queue.remove()+" : "+queue.size());
		
		//큐가 비어있는가
		System.out.println(queue.isEmpty());
		queue.clear();
		System.out.println(queue.isEmpty());
	}

}
