package sleepingBarber;

import java.util.concurrent.ThreadLocalRandom;

public class Barber implements Runnable { // this is the consumer

	private Shop shop;

	public Barber(Shop shop) {

		this.shop = shop;
	}

	@Override
	public void run() {

		while (true) {
			sleep();
			work();
		}
	}

	private void sleep() {

		try {

			// determines a pseudorandom number between 0 to 1000 that represents the
			// sleeping time in milliseconds

			int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
			System.out.println("Barber sleeps for " + sleepTime + "ms");

			Thread.sleep(sleepTime);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void work() {

		while (true) {
			try {
				String customer = shop.nextCustomer();
				
				if(customer == null)
					break;

				// determines a pseudorandom number between 0 to 1000 that represents the
				// working time in milliseconds

				int workTime = ThreadLocalRandom.current().nextInt(0, 3000);
				System.out.println("Barber cuts "+ customer +" for " + workTime + "ms");

				Thread.sleep(workTime);

			} catch (Exception e) {
				e.printStackTrace(System.out);
			}

		}
		System.out.println("No customers in line");
	}
}
