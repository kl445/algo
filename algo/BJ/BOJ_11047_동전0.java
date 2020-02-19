package algo_ad.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_11047_동전0 {

	
	public static void mapset(Map<Integer, Integer> map,int key,int val) {
		
		if(map.containsKey(key)) {
			map.put(key, map.get(key)+val);
		}
		else {
			map.put(key, val);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc =new Scanner(System.in);
		
		int tc=sc.nextInt();
		int money= sc.nextInt();
		
		int[] coins=new int[tc];
		
		for (int i = coins.length-1; i >= 0; i--) {
			coins[i]=sc.nextInt();
		}
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		
		
		
		int change=0;
		int total=0;
		for (int i = 0; i < coins.length; i++) {
			
			change+=coins[i];
			mapset(map,coins[i],1);
			total++;
			if(change>money) {
				change-=coins[i];
				mapset(map,coins[i],-1);
				total--;
			}
			else if(change==money) {
				break;
			}
			else {
				i--;
			}
		}
		
		int total2=0;
		
		for (Integer in : map.values()) {
			total2+=in;
		}
		
	
		System.out.println(total2);
		
		
		
		
		
		

	}

}
