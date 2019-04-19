package creatingThreads;

class MyThreadRunnable implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
			System.out.println(i);
		}
	}

}
public class ImplementRunnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThreadRunnable());
		Thread t2 = new Thread(new MyThreadRunnable());
		t1.start();
		t2.start();
		
	}

}
