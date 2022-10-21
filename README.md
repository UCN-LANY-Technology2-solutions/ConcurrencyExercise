# Concurrency Exercise

This repository contains an indicative solution to the two problems presented below. The implementation is written in Java and is demonstrating the use of threads and synchronization between them. 

## Dining Philosophers

5 philosophers are seated around a round table, with 5 chopsticks arranged so that each philosopher has a chopstick to his left and a chopstick to his right. Philosophers alternate between thinking and eating, both of which can take an arbitrary length of time. Each chopstick can only be used by one philosopher at a time (or the result would probably be terribly messy).

Basically, the philosopher routine can be implemented like this:
```java
while (true) {
	
	think();

	leftChopstick.grab();
	rightChopstick.grab();
	
	eat();

	leftChopstick.release();
	rightChopstick.release();
}
```

Here, a philosopher starts by thinking and after some time doing that, he wants to eat and grabs the left chopstick and the right chopstick. When he has both, he can start eating. Once he is full he puts the chopsticks down, which makes them available to his neighbors.

The shared resource here are the chopsticks, so a *semaphore* with the capacity of one is used to maintain mutual exclusion, so when a filosopher picks up a chopstick, the philosophers to either side cannot. However, the use of mutual exclusion introduces the risk of getting a deadlock, so we need to deal with that.

### Deadlock 

If you run the sample as it is written above it seems like it works fine, and it probably will for a long time, if the time the philosophers spend thinking and eating are arbitrary. But imagine if everybody wants to eat at the exact same time. Everybody picks up the chopstick to the left, and then cannot pick up the one to the right because that is already picked up by another. This situation is commonly known as the *circular wait* and is one of the conditions that results in a deadlock. 

The solution is actually quite simple. When the reason for the deadlock is a circular wait, the way to avoid that is to break that circle by changing the behavior of one link. In practice that means that since all the philosophers reach for the left chopstick first, we change that so one of them reach for the right one. You can see the implementation of this in the *Program.java* file on line 28 to 32.

## Sleeping Barber

A barber shop has one barber, one barber chair for seating a customer currently getting a haircut, and N waiting chairs for waiting customers. If there are no customers, the barber goes to sleep in his chair. When a customer arrives, he sits in the next available chair and waits for the barber to either wake up or finish serving the customers that arrived before him. If there are no available chairs he must leave the shop.

This implementation uses a circular buffer to seat the customers in the shop. When the *Customer* class, that implements the Runnable interface, is started, it is _producing_ customers and sends them into the shop. The likewise runnable *Barber* class _consumes_ the customers by cutting their hair.