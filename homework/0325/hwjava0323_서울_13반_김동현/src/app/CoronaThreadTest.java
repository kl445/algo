package app;

import virus.CoronaThread;

public class CoronaThreadTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			CoronaThread ct= new CoronaThread(i);
			ct.start();
		}
	}
}
