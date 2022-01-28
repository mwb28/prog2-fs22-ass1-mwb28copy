package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class QueueTest {
	Queue q;
	
	@BeforeEach
	public void setup() {
		q = createQueue(4);
	}
	
	private Queue createQueue(int size) {
		return new Queue(size);
	}

	@Test
	public void testEmpty() {
		assertTrue(q.isEmpty(), "a new queue must be empty");
		assertTrue(!q.isFull(), "a new queue must not be full");
		assertEquals(0, q.size(), "a new queue has size 0");
	}
	
	@Test
	public void testFull() {
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertTrue(!q.isEmpty(), "queue must not be empty");
		assertTrue(q.isFull(), "queue must be full");
		assertEquals(4, q.size(), "excepted size of queue is 4");
	}

	@Test
	public void testDequeuOnEmpty() {
		int res = q.dequeue();
		assertEquals(-1, res, "dequeue on an empty queue should return -1");
	}
	
	@Test
	public void testEnqueue1() {
		q.enqueue(1);
		int res = q.dequeue();
		assertEquals(1, res, "enqueue followed by dequeue should return the same element");
	}
	
	@Test
	public void testEnqueue2() {
		boolean b1 = q.enqueue(1);
		boolean b2 = q.enqueue(2);
		int res1 = q.dequeue();
		int res2 = q.dequeue();
		assertTrue(b1, "enqueue must return true if element could be added");
		assertTrue(b2, "enqueue must return true if element could be added");
		
		assertEquals(1, res1, "first element returned by dequeue should be the first element added to the queue");
		assertEquals(2, res2, "second element returned by dequeue should be the second element added to the queue");
	}
	
	@Test
	public void testEnqueueOnFullQueue() {
		q = createQueue(1);
		boolean b1 = q.enqueue(1);
		boolean b2 = q.enqueue(2);
		int res1 = q.dequeue();
		int res2 = q.dequeue();
		assertTrue(b1, "enqueue must return true if element could be added");
		assertFalse(b2, "enqueue must return false if queue is full");
		assertEquals(1, res1, "first element returned by dequeue should be the first element added to the queue");
		assertEquals(-1, res2, "element retunred by empty queue should be -1");
	}

}
