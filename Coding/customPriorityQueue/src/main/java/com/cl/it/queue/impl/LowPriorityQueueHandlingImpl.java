package com.cl.it.queue.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

import com.cl.it.queue.model.QueueItem;

/**
A scenario where lower priority items may never exit the queue is if the throttle rate is set too high. 
For example, if the throttle rate is such that only 2 items with priority x can be dequeued before an item with priority x + 1 is dequeued, 
and if there are more items with priority x than the throttle rate allows, then the lower priority items may never exit the queue.

One solution to this issue is to dynamically adjust the throttle rate based on the number of items in each priority class. 
This can be achieved by keeping track of the number of items that have been dequeued from each priority class, and adjusting the throttle rate accordingly.

For example, in the custom priority queue implementation, you can add a Map to store the number of items dequeued from each priority class, and adjust the throttle rate based on that count. The map would look something like this:


Map<Integer, Integer> priorityCounts = new HashMap<>();
And in the dequeue method, you would update the count for each priority class and adjust the throttle rate accordingly:


T item = queue.take();
int count = priorityCounts.getOrDefault(priority, 0) + 1;
priorityCounts.put(priority, count);

if (count == throttleRate) {
 // move on to the next priority class
 priorityCounts.remove(priority);
 priority++;
}
With this solution, the throttle rate would automatically adjust based on the number of items in each priority class, ensuring that all items have a chance to be dequeued in a timely manner.
*/
public class LowPriorityQueueHandlingImpl<T> {

	private PriorityQueue<QueueItem<T>> priorityQueue;
	private Semaphore queueSemaphore;
	private Map<Integer, Integer> priorityCounts;
	private int throttleRate;
	private int priority;

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
	public Map<Integer, Integer> getPriorityCounts() {
		return priorityCounts;
	}

	/**
	 * 
	 * @param size
	 */
	public LowPriorityQueueHandlingImpl(int size, int throttleRate) {
		this.priorityQueue = new PriorityQueue<>((p1, p2) -> p1.getPriority() - p2.getPriority());
		this.priorityCounts = new HashMap<>();
		this.queueSemaphore = new Semaphore(size);
		this.throttleRate = throttleRate;
		this.priority = 0;
	}

	/**
	 * 
	 * The enqueue method acquires the queueSemaphore to block the producer if the
	 * queue is full. It then adds the item to the priority queue.
	 * 
	 * @param item
	 * @param priority
	 * @throws InterruptedException
	 */
	public void enqueue(T item, int priority) throws InterruptedException {
		queueSemaphore.acquire();
		priorityQueue.offer(new QueueItem<>(item, priority));
		printQueue("After enqueue");
	}

	/**
	 * The dequeue method retrieves the highest priority item from the priority
	 * queue. It then updates the count for each priority class and adjusts the
	 * throttle rate accordingly. It also releases the queueSemaphore to allow more
	 * items to be added to the queue.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public T dequeue() throws InterruptedException {
		if (priorityQueue.size() != 0) {
			T item = priorityQueue.poll().getItem();
			int count = priorityCounts.getOrDefault(priority, 0) + 1;
			priorityCounts.put(priority, count);

			if (count == throttleRate) {
				priorityCounts.remove(priority);
				priority++;
			}
			queueSemaphore.release();
			printQueue("After deque");
			return item;
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
			System.out.println(operation + "--> " + "Item: " + queueItem.getItem() + ", Priority: " + queueItem.getPriority());
		}
	}
}
