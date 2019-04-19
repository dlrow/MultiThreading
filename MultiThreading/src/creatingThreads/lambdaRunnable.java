package creatingThreads;

public class lambdaRunnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				System.out.println(i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				System.out.println(i);
			}
		});
		
		t1.start();
		t2.start();
	}

}
