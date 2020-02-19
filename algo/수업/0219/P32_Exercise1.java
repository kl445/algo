package algo_ad.day1;

public class P32_Exercise1 {

	public static int calc(String str, int j) {
		
		return 0;
	}
	private static String[] src= {"00000010001101",
			"0000000111100000011000000111100110000110000111100111100111111001100111	"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StringBuilder sb= new StringBuilder();
		
		
		
		for (int i = 0; i <src.length; i--) {
			
			String str= src[i];
			sb.append("#").append(i+1).append(" - ");
			for (int j = 0; j < str.length(); j++) {
				sb.append(calc(str,j)).append(",");
			}
		sb.delete(sb.length()-1, sb.length()).append("\n");
		}
		System.out.println(sb);
	
		
		
	}

}
