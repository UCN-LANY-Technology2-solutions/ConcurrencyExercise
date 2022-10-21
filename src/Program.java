import java.awt.desktop.ScreenSleepEvent;

import diningPhilosophers.Chopstick;
import diningPhilosophers.Philosopher;
import sleepingBarber.Barber;
import sleepingBarber.Customer;
import sleepingBarber.Shop;

public class Program {

	public static void main(String[] args) {

		diningPhilosophers();
//		sleepingBarber();
	}

	public static void diningPhilosophers() {

		String[] philosophers = { "Socrates", "Nietzsche", "Kant", "Rousseau", "Marx" };
		Chopstick[] chopsticks = { new Chopstick(), new Chopstick(), new Chopstick(), new Chopstick(),
				new Chopstick() };

		for (int i = 0; i < philosophers.length; i++) {
			Chopstick left = chopsticks[i];
			Chopstick right = chopsticks[(i + 1) % 5];
			Thread diningPhilosopher;

			if (i == philosophers.length - 1) {
				diningPhilosopher = new Thread(new Philosopher(philosophers[i], right, left));
			} else {
				diningPhilosopher = new Thread(new Philosopher(philosophers[i], left, right));
			}

			diningPhilosopher.start();
		}
	}

	public static void sleepingBarber() {

		Shop shop = new Shop();

		Thread t = new Thread(new Barber(shop));
		Thread c = new Thread(new Customer(shop));

		t.start();
		c.start();
	}

}
