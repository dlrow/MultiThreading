package creatingThreads;

class MyThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
			System.out.println(i);
		}
	}
	
}
public class ExtendingThreadClass  {
	public static void main(String[] args) {
		Thread t1= new MyThread();
		Thread t2= new MyThread();
		t1.start();
		t2.start();
	}
}
