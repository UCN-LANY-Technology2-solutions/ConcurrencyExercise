import java.awt.desktop.ScreenSleepEvent;

import diningPhilosophers.Chopstick;
import diningPhilosophers.Philosopher;
import sleepingBarber.Barber;
import sleepingBarber.Customer;
import sleepingBarber.Shop;

public class Program {

	public static void main(String[] args) {

//		diningPhilosophers();
		sleepingBarber();
	}
	
	public static void diningPhilosophers() {
		
		String[] philosophers = { "Socrates", "Nietzsche", "Kant", "Rousseau", "Marx" };
		Chopstick[] chopsticks = { new Chopstick(), new Chopstick(), new Chopstick(), new Chopstick(), new Chopstick() };

		for (int i = 0; i < philosophers.length; i++) {

			Thread diningPhilosopher = new Thread(new Philosopher(philosophers[i], chopsticks[i], chopsticks[(i + 1) % 5]));
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
