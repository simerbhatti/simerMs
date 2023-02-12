package com.cl.it.queue.impl;

public class PriorityQueueImplFixture {

	/**
	 * Just a utility to try to create queue more than its size .
	 * This should return till size only and does not grow more than its size.
	 * @return
	 * @throws InterruptedException
	 */
	public static CustomPriorityQueue<Integer> createQueuewithMaxSize() throws InterruptedException {
		CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
		customPriorityQueue.enqueue(11, 1);
		customPriorityQueue.enqueue(111, 1);
		customPriorityQueue.enqueue(112, 2);
		customPriorityQueue.enqueue(113, 3);
		customPriorityQueue.enqueue(114, 4);
		customPriorityQueue.enqueue(115, 1);
		customPriorityQueue.enqueue(116, 2);
		customPriorityQueue.enqueue(117, 3);
		customPriorityQueue.enqueue(118, 9);
		customPriorityQueue.enqueue(119, 7);
		customPriorityQueue.enqueue(120, 6);
		customPriorityQueue.enqueue(123, 4);
		customPriorityQueue.enqueue(124, 3);
		customPriorityQueue.enqueue(125, 4);
		return customPriorityQueue;
	}
}
