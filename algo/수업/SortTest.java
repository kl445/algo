package algo_basic.day2;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	
	public static void sort0() {
		String [] strs= {"Now", "Hello","Java","World"};
		
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		
	}

	public static void main(String[] args) {
//		sort0();
//		sort1();
		sort2();

	}
	
	public static void sort1() {
		Hero[] heros= {
				new Hero(100,"Hulk"),
				new Hero(80,"SpiderMan"),
				new Hero(90,"IronMan"),
		};
		
		Arrays.sort(heros);
		System.out.println(Arrays.toString(heros));
	}
	
	
	
	
	static class Hero implements Comparable<Hero>{
		Integer power;
		String name;
		public Hero(int power, String name) {
			super();
			this.power = power;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Hero [power=" + power + ", name=" + name + "]";
		}
		@Override
//		public int compareTo(Hero o) {
//			// TODO Auto-generated method stub
//			return this.name.compareTo(o.name);
//		}
		public int compareTo(Hero o) {
			// TODO Auto-generated method stub
			return this.power.compareTo(o.power);
		}
		
//		public int compareTo(Hero o) {
//			// TODO 오버플로우 조심
//			if(this.power>o.power)
//				return 1;
//			else if(this.power==o.power)
//				return 0;
//			else
//				return -1;
//		}
	
		
		
	}
	static class Hero2 {
		Integer power;
		String name;
		public Hero2(int power, String name) {
			super();
			this.power = power;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Hero [power=" + power + ", name=" + name + "]";
		}
	
	}
	public static void sort2() {
		Hero2[] heros= {
				new Hero2(100,"Hulk"),
				new Hero2(80,"SpiderMan"),
				new Hero2(90,"IronMan"),
		};
		
		
		// 익명의 inner class 이용해 comparator 타입 공급
		Arrays.sort(heros,new Comparator<Hero2>() {

			@Override
			public int compare(Hero2 o1, Hero2 o2) {
			
				return o1.name.compareTo(o2.name); 
			}
		});
		System.out.println(Arrays.toString(heros));
	}
		
		
	

}
