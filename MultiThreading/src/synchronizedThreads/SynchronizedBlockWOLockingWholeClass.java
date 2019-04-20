package synchronizedThreads;

public class SynchronizedBlockWOLockingWholeClass {
	static int ct1 = 0;
	static int ct2 = 0;
	static Object lock1=new Object();
	static Object lock2=new Object();;
	
	// no need of thread taking class intrinsic lock as both threads are
	// incrementing their own variables so use synchronized blocks
	private static void incrementCt1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			ct1++;
		}
	}

	private static void incrementCt2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			ct2++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				incrementCt1();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				incrementCt2();
		});

		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(ct1);
		System.out.println(ct2);
		System.out.println("Time taken : " + totalTime);
	}

}
