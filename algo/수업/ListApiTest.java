package algo_day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApiTest {

	public static void main(String[] args) {
		// C/R/U/D

		addTest();
		System.out.println();
		updateTest();
		System.out.println();
		search();
		System.out.println();
		delete();
		System.out.println();
		sequenciaAdd(new ArrayList<>(),1);
	System.out.println();
		sequenciaAdd(new LinkedList<>(), 1);
		sequenciaAdd(new ArrayList<>(),2);
		System.out.println();
		sequenciaAdd(new LinkedList<>(), 2);
	}

//	static List<Integer> list = new ArrayList<>();
	static List<Integer> list = new LinkedList<>();
	
	public static void addTest() {
		//순차적 데이터 추가
		list.add(1);
		list.add(2);
		
		list.add(2);
		System.out.println(list);
		
		list.add(0,-1);
		list.add(0,-2);
		
		System.out.println(list);
	}
	
	public static void updateTest() {
		//지정 인덱스 데이터 수정
		list.set(0, -100);
		System.out.println("수정 결과:"+list);
		
	}
	
	public static void search() {
		//리스트출력기능
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		Integer num=list.get(1);
		System.out.println(num);
		System.out.println(list.contains(1));
	}
	public static void delete() {
		//삭제 오브젝트와 인덱스 구별 주의 ex) int, integer
		System.out.println("삭제 전"+list);
		list.remove(0);
		System.out.println("삭제 후"+list);

		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("i: "+i);
			list.remove(i);
			
			//앞에 리스트가 지워지면 다음 리스트가 앞쪽으로 이동하여 인덱스가 변경됨
		}
		System.out.println("모두 지움"+list);
		
		//초기화
		list.clear();
		System.out.println("모두 지움2"+list);
		
		
		list.add(0);
		list.add(1);
		list.add(2);
		System.out.println("추가"+list);
		
		while(!list.isEmpty()) {
			list.remove(0);
		}
		System.out.println("모두 지움3"+list);
		
	}
	
	public static void sequenciaAdd(List<Integer> list,int type) {
		long start= System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			if(type==1) {
			list.add(i);
			}else {
				list.add(0, i);
			}
		}
		long end= System.currentTimeMillis();
		System.out.println(list.getClass().getName()+" : "+(end-start));
		
	}
}
