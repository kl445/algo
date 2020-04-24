package algo.hw0416;

public class BOJ_4673_셀프넘버 {

	//메모이제이션
	static boolean[] isTrue=new boolean[10001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for (int i =1; i < 10001; i++) {
			nextNumber(i);
			if(isTrue[i]) continue;
			
			else {
				System.out.println(i);
			}
		}
		
		
	}
	
	static void nextNumber(Integer num) {
		
		String temp=num.toString();
		int res=num;
		for (int i = 0; i < temp.length(); i++) {
			res+=temp.charAt(i)-'0';
		}
		if(res<=10000) {
			isTrue[res]=true;
		}
	}

}
