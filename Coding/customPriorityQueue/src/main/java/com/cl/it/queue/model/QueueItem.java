package com.cl.it.queue.model;

/**
 * 
 * @author simerdeep.singh
 *
 * Class representing an item in a custom priority queue
 *
 * @param <T> The type of the item stored in the queue
 */

public class QueueItem<T> implements Comparable<QueueItem<T>> {
	private T item;
	private int priority;

	/**
	 * Constructor for QueueItem class
	 * 
	 * @param item     The item to be stored in the queue
	 * @param priority The priority of the item in the queue
	 */
	public QueueItem(T item, int priority) {
		this.item = item;
		this.priority = priority;
	}

	/**
	 * Getter method for the item stored in the queue
	 * 
	 * @return The item stored in the queue
	 */
	public T getItem() {
		return item;
	}

	/**
	 * Getter method for the priority of the item in the queue
	 * 
	 * @return The priority of the item in the queue
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Compare this QueueItem with another QueueItem based on their priorities
	 * 
	 * @param other The other QueueItem to be compared with
	 * @return The comparison result (-1, 0, or 1) based on their priorities
	 */
	@Override
	public int compareTo(QueueItem<T> other) {
		return Integer.compare(this.priority, other.priority);
	}
}