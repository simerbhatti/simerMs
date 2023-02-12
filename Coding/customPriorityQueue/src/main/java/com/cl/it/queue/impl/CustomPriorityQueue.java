package com.cl.it.queue.impl;


import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import com.cl.it.queue.model.QueueItem;

/**
 * 
 * The CustomPriorityQueue class has a PriorityQueue that stores the items in the queue.
 * The ConcurrentHashMap throttleMap stores the throttle rate of each priority class.
 * The queueSemaphore is used to control the size of the queue.
 * 
 * @author simerdeep.singh
 *
 * @param <T>
 */
public class CustomPriorityQueue<T> {
	
	private PriorityQueue<QueueItem<T>> priorityQueue;
	private Semaphore queueSemaphore;
	private ConcurrentHashMap<Integer, Semaphore> throttleMap;
	private int size;
	
	/**
	 * 
	 * @return
	 */
	public PriorityQueue<QueueItem<T>> getPriorityQueue() {
		return priorityQueue;
	}

	/**
	 * 
	 * @return
	 */
	public Semaphore getQueueSemaphore() {
		return queueSemaphore;
	}

	/**
	 * 
	 * @return
	 */
	public ConcurrentHashMap<Integer, Semaphore> getThrottleMap() {
		return throttleMap;
	}
	
	/**
	 * 
	 * @param size
	 */
	public CustomPriorityQueue(int size) {
		this.priorityQueue = new PriorityQueue<>((p1, p2) -> p1.getPriority() - p2.getPriority());
		this.throttleMap = new ConcurrentHashMap<>();
		this.queueSemaphore = new Semaphore(size);
		this.size =size;
	}

	/**
	 * 
	 * The enqueue method acquires the queueSemaphore to block the producer if the queue is full. 
	 * It then adds the item to the priority queue and creates a new semaphore for the priority class if it doesn't already exist.
	 * @param item
	 * @param priority
	 * @throws InterruptedException
	 */
	public void enqueue(T item, int priority) throws InterruptedException {
		if(queueSemaphore.availablePermits()!=0) {
		queueSemaphore.acquire();
		priorityQueue.offer(new QueueItem<>(item, priority));
		if (!throttleMap.containsKey(priority)) {
			throttleMap.put(priority, new Semaphore(2));
		}
		}
		printQueue("After enqueue");
	}

	/**
	 * The dequeue method retrieves the highest priority item from the priority queue and acquires the semaphore for the priority class. 
	 * It then releases the queueSemaphore to allow more items to be added to the queue.
	 * @return
	 * @throws InterruptedException
	 */
	public T dequeue() throws InterruptedException {
		if (priorityQueue.size() != 0) {
			int currentPriority = priorityQueue.peek().getPriority();
			if (throttleMap.get(currentPriority).availablePermits() != 0 && queueSemaphore.availablePermits() < size) {
				throttleMap.get(currentPriority).acquire();
				queueSemaphore.release();
				T item = priorityQueue.poll().getItem();
				printQueue("After deque");
				return item;
			}
		}
		printQueue("After deque");
		return null;

	}
	
	/**
	 * 
	 * @param operation
	 */
	public void printQueue(String operation) {
		System.out.println("Priority Queue:");
		for (QueueItem<T> queueItem : priorityQueue) {
			System.out.println(operation + "--> "+ "Item: " + queueItem.getItem() + ", Priority: " + queueItem.getPriority());
		}
	}

}
