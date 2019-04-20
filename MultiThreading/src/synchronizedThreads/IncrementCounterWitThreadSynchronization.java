package synchronizedThreads;

public class IncrementCounterWitThreadSynchronization {
	static int ct = 0;
	
	//thread takes class intrinsic lock
	private synchronized static void increment() {
		ct++;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				increment();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				increment();
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(ct);
	}

}
