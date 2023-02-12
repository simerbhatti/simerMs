package com.cl.it.queue.impl;

/**
 * 
 * @author simerdeep.singh
 *
 */

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cl.it.queue.model.QueueItem;

/**
 * 
 * @author simerdeep.singh
 *
 * @param <T>
 */
class CustomPriorityQueueTest<T> {
  
  @Test
  void testCustomPriorityQueue() {
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
  
  @Test
  void testEnqueue() throws InterruptedException {
    CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
    customPriorityQueue.enqueue(1, 1);
    
    assertEquals(1, customPriorityQueue.getPriorityQueue().size());
    assertEquals(9, customPriorityQueue.getQueueSemaphore().availablePermits());
    assertEquals(1, customPriorityQueue.getThrottleMap().size());
  }
  
  @Test
  void testDequeue() throws InterruptedException {
    CustomPriorityQueue<Integer> customPriorityQueue = new CustomPriorityQueue<>(10);
    customPriorityQueue.enqueue(1, 1);
    int item = customPriorityQueue.dequeue();
    
    assertEquals(1, item);
    assertEquals(0, customPriorityQueue.getPriorityQueue().size());
    assertEquals(10, customPriorityQueue.getQueueSemaphore().availablePermits());
    assertEquals(0, customPriorityQueue.getThrottleMap().size());
  }
}

