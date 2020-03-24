package app;

import virus.CoronaRunnable;

public class CoronaThreadTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			CoronaRunnable cr= new CoronaRunnable(i);
			Thread t= new Thread(cr);
			t.start();
		}
	}
}
