package creatingThreads;

public class RunnableAnnonymousInnerClass {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<5;i++) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
					System.out.println(i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<5;i++) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
					System.out.println(i);
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
