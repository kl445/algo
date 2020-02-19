package algo_ad.day1;

import java.util.Arrays;
import java.util.LinkedList;

public class Knapsack {

	static int[][] goods= {{5,50},{10,60},{20,140}};
	
	public static int maxMoney= Integer.MIN_VALUE;
	public static int maxKg=30;
	
	static class Good{
		int kg;
		int money;
		public Good(int kg, int money) {
			this.kg = kg;
			this.money = money;
		}
		@Override
		public String toString() {
			return "Good [kg=" + kg + ", money=" + money + "]";
		}
		
	}
	public static void knapsack(LinkedList<Good> list) {
		
		int kg=0;
		int money=0;
		
		
		for (int i = 0; i < list.size(); i++) {
			kg+=list.get(i).kg;
			money+=list.get(i).money;
		}
		
		if(kg<=maxKg) {
			maxMoney=Math.max(maxMoney, money);
		}
		System.out.println(list.toString()+" "+money);
		
		
		
		
	}
	
	public static void set(int r, int c, boolean[] check, boolean visited[]) {
		
		if(r==c) {
			LinkedList<Good> list=new LinkedList<>();
			
			for (int i = 0; i <visited.length; i++) {
				if(visited[i]) {
					Good good=new Good(goods[i][0],goods[i][1]);
					list.add(good);
				}
			}
			
			knapsack(list);
			
			
			
			
			return;
		}else {
			for (int i = 0; i < check.length; i++) {
				visited[c]=check[i];
				set(r, c+1, check, visited);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean[] check= {true,false};
		set(goods.length, 0,check, new boolean[goods.length]);
		
		System.out.println("maxmoney: "+maxMoney);
	}

}
