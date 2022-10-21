package diningPhilosophers;

import java.util.concurrent.Semaphore;

public class Chopstick { // this is the shared resource that is scarce
	
	Semaphore mutex = new Semaphore(1);
	
	public void grab() { // aquire mutex
		try {
			
			mutex.acquire();
		
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void release() { // release mutex
		
		mutex.release();
	}

}
