package diningPhilosophers;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

	private String name;
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;

	public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {

		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

	@Override
	public void run() {

		while (true) {
			
			think();

			leftChopstick.grab();
			rightChopstick.grab();
			
			eat();

			leftChopstick.release();
			rightChopstick.release();
		}
	}

	private void think() {
		try {

			// determines a pseudorandom number between 0 to 1000 that represents the
			// thinking time in milliseconds

			int thinkTime = ThreadLocalRandom.current().nextInt(0, 1000);
			System.out.println(name + " thinks for " + thinkTime + "ms");

			Thread.sleep(thinkTime);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void eat() {
		try {

			// determines a pseudorandom number between 0 to 1000 that represents the
			// eating time in milliseconds

			int eatTime = ThreadLocalRandom.current().nextInt(0, 1000);
			System.out.println(name + " eats for " + eatTime + "ms");

			Thread.sleep(eatTime);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
