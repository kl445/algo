package virus;

public class CoronaRunnable implements Runnable {
	int num;
	
	public CoronaRunnable(int num) {
		this.num=num;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			
		}
		System.out.println(num);
	}
	
	
	
}
