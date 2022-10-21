# Concurrency Exercise

This repository contains an implementation of the two problems presented below written in Java. 

## Dining Philosophers

5 philosophers are seated around a round table, with 5 chopsticks arranged so that each philosopher has a chopstick to his left and a chopstick to his right. Philosophers alternate between thinking and eating, both of which can take an arbitrary length of time. Each chopstick can only be used by one philosopher at a time (or the result would probably be terribly messy).

## Sleeping Barber

A barber shop has one barber, one barber chair for seating a customer currently getting a haircut, and N waiting chairs for waiting customers. If there are no customers, the barber goes to sleep in his chair. When a customer arrives, he must wake up the barber. If a customer arrives while the barber is cutting another customer's hair, he must wait in a waiting chair if any are available, and otherwise must leave the shop.