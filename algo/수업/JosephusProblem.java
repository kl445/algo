package algo_day7;

import java.util.ArrayList;
import java.util.LinkedList;

public class JosephusProblem {
	
	private static int n=24;  //n명
	private static int k= 3; //몇번 건너 뛰는지

	static class Sor {
		int num;
		
		public Sor(int num) {
			this.num=num;
		}

		@Override
		public String toString() {
			return "Sor [" + num + "]";
		}
		
	}
	public static void main(String[] args) {
		
		
		
		LinkedList<Sor>	list= new LinkedList<>();
		
		
		for (int i = 0; i <n; i++) {
			list.add(new Sor(i));
		}
		
		
		System.out.println(list.toString());
		
		list.remove(0);
		int index=0;
		while(list.size()>2) {
			index=(index+2) %list.size();
			
//			System.out.println("rem "+list.get(index));
			list.remove(index);
		
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
