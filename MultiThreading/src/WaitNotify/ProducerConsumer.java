package WaitNotify;

class ProducerConsumerAndVolatile {
	volatile boolean producerstarted = false;
	
	Thread producer = new Thread(() -> {
		synchronized (this) {
			while (true) {
				try {	Thread.sleep(2000);	} catch (InterruptedException e) {	}
				System.out.println("produced");
				producerstarted = true;
				notify();
				try {	wait();	} catch (InterruptedException e) {}
			}
		}
	});

	Thread consumer = new Thread(() -> {
		synchronized (this) {
			while (true && producerstarted ) {
				try {	Thread.sleep(1000);	} catch (InterruptedException e) {		}
				System.out.println("consumed");
				notify();
				try {	wait();		} catch (InterruptedException e) {}
			}
		}
	});

}

public class ProducerConsumer {
	public static void main(String[] args) {
		ProducerConsumerAndVolatile pc = new ProducerConsumerAndVolatile();
		
		pc.producer.start();
		pc.consumer.start();
	}

}
