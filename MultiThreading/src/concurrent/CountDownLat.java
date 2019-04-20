package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLat {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Thread battingAvgCalcThread = new BattingAvgCalculator(latch);
		Thread bowlingAvgCalcThread = new BowlingAvgCalculator(latch);
		Thread fieldingAvgCalcThread = new FieldingAvgCalculator(latch);
		Thread publishResultThread = new PublishResult(latch);
		battingAvgCalcThread.start();
		bowlingAvgCalcThread.start();
		fieldingAvgCalcThread.start();
		latch.await();
		publishResultThread.start();
	}

}

class BattingAvgCalculator extends Thread {
	CountDownLatch latch;

	public BattingAvgCalculator(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Batting Avg calculated");
		latch.countDown();
	}
}

class BowlingAvgCalculator extends Thread {
	CountDownLatch latch;

	public BowlingAvgCalculator(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Bowling Avg calculated");
		latch.countDown();
	}
}

class FieldingAvgCalculator extends Thread {
	CountDownLatch latch;

	public FieldingAvgCalculator(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Fielding Avg calculated");
		latch.countDown();
	}
}

class PublishResult extends Thread {
	CountDownLatch latch;

	public PublishResult(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Published result after calculating batting bowling and fielding avg");
	}
}
