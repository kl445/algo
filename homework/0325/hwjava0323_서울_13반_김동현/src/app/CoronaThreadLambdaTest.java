package app;

public class CoronaThreadLambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Anonymous Thread 생성");
			}
			
			
		}).start();
		new Thread( ()->System.out.println("Lambda Thread 생성")).start();
	}

}
