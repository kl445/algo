package algo_day7;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		useSet(new HashSet<>());
//		useSet(new LinkedHashSet<>());
//		useSet(new TreeSet<>());
		
		
		useMap(new HashMap<>());
		useMap(new LinkedHashMap<>());
		useMap(new TreeMap<>());
	}
	
	//Map 테스트
	public static void useMap(Map<Integer, String> map) {
		int[] arr= {-1, -1, 0, 2, -2, 1};
		
		for (int i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		//hash map: 키 값 중복 불가능 순서 없음
		//linked hash map: 키값 중복 불가능 넣은 순서대로 나옴
		//tree hash map: 키값 중복 불가능 키 값으로 순서 정렬됨
		System.out.println(map.getClass().getName()+" : " +map);
		
		Set<Integer> keys= map.keySet();
		for (Integer key : keys) {
			System.out.println("for key: "+key+" :"+map.get(key));
		}
		
		Collection<String> vals= map.values();
		
		Set<Entry<Integer, String>> entrys=map.entrySet();
		
		for (Entry<Integer, String> ent : entrys) {
			System.out.println("entry;"+ent.getKey()+" : "+ent.getValue());
		}
		
		
		if(map instanceof TreeMap) {
			TreeMap<Integer, String> tmap=(TreeMap<Integer, String>)map;
			
			//key값 기준으로 하는 다양한 검색기능
			
			System.out.println("head: "+tmap.headMap(0));
			System.out.println("tail: "+tmap.tailMap(0));
			System.out.println("syb: "+tmap.subMap(-1, 1));
		}
		
	}
	
	//Set 테스트
	public static void useSet(Set<String> set) {
		//add
		set.add("my");
		set.addAll(Arrays.asList("my","dream","hello","come","true"));
		
		//hash set은 중복 불가능 , 순서가 없다.
		//linked hash set은 중복 불가능, 넣은 순서로 출력
		//tree set은 중복 불가능 알파벳 오름차순 정렬하여 출력
		System.out.println(set.getClass().getName()+" : "+set);
		
		for (String string : set) {
			System.out.println("for: "+string);
		}
		
	
		System.out.println(set.size()+" : "+set.contains("hello")+" : "+set.isEmpty()+" : "+set.remove("hello"));
		Object[] arr= set.toArray();
		
		
		if(set instanceof TreeSet) {
			TreeSet<String> test=(TreeSet) set;
			System.out.println("Test 보다 앞에 있는 녀석들"+test.headSet("Test"));
			System.out.println("Test 보다 뒤에 있는 녀석들"+test.tailSet("Test"));
			
			System.out.println(test.subSet("aplle", "test"));
			
			System.out.println(test.first()+" : "+test.pollFirst());
			System.out.println(test.last()+" : "+test.pollLast());
			System.out.println(test);
			
		}
	
	}

}
