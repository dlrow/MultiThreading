package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockk {
	Lock lock = new ReentrantLock();
	int ct = 0;

	public void increment() {
		ct++;
	}

	// always use try finially to unclock the lock as in case of exception in
	// increment() the lock will never get unclocked
	Thread t1 = new Thread(() -> {
		for (int i = 0; i < 10000; i++) {
			lock.lock();
			increment();
			lock.unlock();
		}
	});

	Thread t2 = new Thread(() -> {
		for (int i = 0; i < 10000; i++) {
			lock.lock();
			increment();
			lock.unlock();
		}
	});

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockk r = new ReentrantLockk();
		r.t1.start();
		r.t2.start();
		r.t1.join();
		r.t2.join();

		System.out.println(r.ct);
	}

}
