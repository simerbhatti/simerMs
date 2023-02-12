package com.cl.it.queue.impl;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class LowPriorityQueueHandlingImplTest {
	
	private final int QUEUE_SIZE = 10;
	private final int THROTTLE_RATE = 2;
	private final int NUM_PRODUCERS = 5;
	private final int NUM_CONSUMERS = 3;
	
	@Test
	public void testLowPriorityQueue() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(NUM_PRODUCERS + NUM_CONSUMERS);
		LowPriorityQueueHandlingImpl<Integer> lowPriorityQueue = new LowPriorityQueueHandlingImpl<>(QUEUE_SIZE, THROTTLE_RATE);
		// Add producers to the executor
		for (int i = 0; i < NUM_PRODUCERS; i++) {
			executor.submit(() -> {
				try {
					int item = (int) (Math.random() * 100);
					int priority = (int) (Math.random() * 5);
					lowPriorityQueue.enqueue(item, priority);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		// Add consumers to the executor
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			executor.submit(() -> {
				try {
					lowPriorityQueue.dequeue();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		executor.shutdown();
		executor.awaitTermination(15, TimeUnit.SECONDS);
		// Assert that the low priority items are eventually dequeued
		assertTrue(lowPriorityQueue.getPriorityQueue().size() == 0);
	}
}

