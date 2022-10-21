package sleepingBarber;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Customer implements Runnable { // this is the producer of customers

	private String[] customerNames = { "Jaiden Hoffman", "Belen Stafford", "Whitney Nixon", "Yosef Simmons",
			"Nathaniel Fitzpatrick", "Averi Pearson", "Darrell Frazier", "Delilah Strong", "Aryan Cole",
			"Adrian Calhoun", "Issac Bright", "Sarahi Figueroa", "Logan Contreras", "Jazmine Rios", "Gunnar Bond",
			"Carson Gallegos", "Lauryn Bonilla", "Madalyn Steele", "Diana Braun", "Jessica Sherman", "Kennedi Hancock",
			"Emilee Ritter", "Jeffery Wade", "Edwin Lopez", "Hadassah Henderson", "Abdiel Phelps", "Dania Choi",
			"Margaret Martinez", "Rudy Archer", "Mareli Montoya", "Darwin Williamson", "Edith Frost",
			"Mitchell Mitchell", "Patrick Henry", "Melvin Miranda", "Janet Santiago", "Jillian Dickerson",
			"Dulce Wells", "James Park", "Briley Ross", "Lillianna Jackson", "Andres Martin", "Georgia Holmes",
			"Marco Garner", "Cierra Barrera", "Karissa Riddle", "Lorelei Thomas", "Rylee Stephens", "Marlene Rice",
			"Averie Craig", "Gracie Townsend", "Franco Silva", "Felicity Forbes", "Valerie Colon", "Curtis Jarvis",
			"Regina Bowen", "Ashtyn Hatfield", "Niko Miranda", "Braiden Anthony", "Graham Doyle", "Charlize Pace",
			"Alexzander Fischer", "Sullivan Patton", "Adam Malone", "Pierre Pugh", "Cael Meadows", "Leon Huffman",
			"Aryana Chang", "Josh Warren", "Freddy Obrien", "Azaria Boyer", "Johnny Singh", "Sergio Armstrong",
			"Alison Brandt", "Macey Rubio", "Asa Sparks", "Allen Adkins", "Jace Mccall", "Austin Ryan", "River Simon",
			"Humberto Marks", "Haylee Thomas", "Catalina Aguilar", "Taniya Goodwin", "Zachary Hood", "Fabian Braun",
			"Ali Potts", "Savion Snow", "Roselyn Mcneil", "Precious Hodge", "Fletcher Hampton", "Bria Gregory",
			"Brody Mcgrath", "Alessandro Blackburn", "Jaden Villegas", "Jagger Calhoun", "Alejandra Kirby",
			"Maeve Moss", "Kaitlin Pollard" };

	private Shop shop;

	public Customer(Shop shop) {

		this.shop = shop;

	}

	@Override
	public void run() {

		// producing customers
		while (true) {
			String nextCustomer = getRandomCustomer();
			if (!shop.enterCustomer(nextCustomer)) {
				System.out.println(nextCustomer + " left because there was no available seat");
			}
		}
	}

	public String getRandomCustomer() {
		try {

			Thread.sleep(ThreadLocalRandom.current().nextInt(0, 3000));
			int nextCustomerIndex = ThreadLocalRandom.current().nextInt(0, customerNames.length - 1);
			String nextCustomer = customerNames[nextCustomerIndex];
			return nextCustomer;

		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

}
