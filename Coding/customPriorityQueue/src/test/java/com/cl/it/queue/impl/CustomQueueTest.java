package com.cl.it.queue.impl;

import static com.cl.it.queue.impl.PriorityQueueImplFixture.createQueuewithMaxSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import org.junit.Test;

import com.cl.it.queue.model.QueueItem;

/**
 * 
 * @author simerdeep.singh
 *
 * @param <T>
 */
public class CustomQueueTest<T> {

	/**
	 * This test basic class state variables for Custompriority queue
	 */
	@Test
	public void testCustomPriorityQueue() {
		int size = 10;
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(size);

		PriorityQueue<QueueItem<Integer>> priorityQueue = customPriorityQueue.getPriorityQueue();
		Semaphore queueSemaphore = customPriorityQueue.getQueueSemaphore();
		ConcurrentHashMap<Integer, Semaphore> throttleMap = customPriorityQueue.getThrottleMap();

		assertNotNull(priorityQueue);
		assertNotNull(queueSemaphore);
		assertNotNull(throttleMap);
		assertEquals(size, queueSemaphore.availablePermits());
	}

	/**
	 * test the enqueue method
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testEnqueue() throws InterruptedException {
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
		customPriorityQueue.enqueue(1, 1);

		assertEquals(1, customPriorityQueue.getPriorityQueue().size());
		assertEquals(9, customPriorityQueue.getQueueSemaphore().availablePermits());
		assertEquals(1, customPriorityQueue.getThrottleMap().size());
	}

	/**
	 * test the dequeue method
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testDequeue() throws InterruptedException {
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
		customPriorityQueue.enqueue(1, 1);
		int item = customPriorityQueue.dequeue();

		assertEquals(1, item);
		assertEquals(0, customPriorityQueue.getPriorityQueue().size());
		assertEquals(10, customPriorityQueue.getQueueSemaphore().availablePermits());
		assertEquals(1, customPriorityQueue.getThrottleMap().size());
	}

	/**
	 * This test that queue size gets restricted to size initialised
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testQueueSize() throws InterruptedException {
		CustomPriorityQueue<Integer> customPriorityQueue = createQueuewithMaxSize();
		assertEquals(10, customPriorityQueue.getPriorityQueue().size());
		assertEquals(0, customPriorityQueue.getQueueSemaphore().availablePermits());
		assertEquals(6, customPriorityQueue.getThrottleMap().size());
	}

	/**
	 * This test that all elements removed and fail safe if we try to remove an
	 * empty queue
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testDequeueLimit() throws InterruptedException {
		int queueSize = 10;
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(queueSize);
		createQueuewithMaxSize();
		for (int i = 0; i <= 20; i++) {
			customPriorityQueue.dequeue();
		}
		assertEquals(0, customPriorityQueue.getPriorityQueue().size());
		assertEquals(10, customPriorityQueue.getQueueSemaphore().availablePermits());
		assertEquals(0, customPriorityQueue.getThrottleMap().size());
	}

	/**
	 * This test that elements are added and removed with correct throttle and
	 * dequeue in correct order
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testDequeueWithElements() throws InterruptedException {
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
		customPriorityQueue.enqueue(11, 1);
		customPriorityQueue.enqueue(111, 1);
		customPriorityQueue.enqueue(112, 2);
		customPriorityQueue.enqueue(113, 3);
		customPriorityQueue.dequeue();
		customPriorityQueue.dequeue();
		Integer item = customPriorityQueue.dequeue();
		assertEquals(112, item.intValue());
		assertEquals(1, customPriorityQueue.getPriorityQueue().size());
		assertEquals(9, customPriorityQueue.getQueueSemaphore().availablePermits());
		assertEquals(3, customPriorityQueue.getThrottleMap().size());
	}
}
