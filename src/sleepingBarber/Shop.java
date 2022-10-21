package sleepingBarber;

public class Shop { // this is where the produced customers is buffering up

	private int customerSeated = 0;	
	private int customerServed = 0;

	private String[] customers = new String[4];

	public synchronized boolean enterCustomer(String customer) {

		if (hasEmptyChair()) {
			int chair = ++customerSeated % customers.length;
			customers[chair] = customer;
			return true;
		}
		return false;
	}

	public synchronized String nextCustomer() {

		if (hasWaitingCustomers()) {
			int chair = customerServed++ % customers.length;
			String nextCustomer = customers[chair];
			customers[chair] = null;
			return nextCustomer;
		}
		return null;
	}

	private boolean hasWaitingCustomers() {

		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				return true;
			}
		}
		return false;
	}

	private boolean hasEmptyChair() {

		for (int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				return true;
			}
		}
		return false;
	}
}