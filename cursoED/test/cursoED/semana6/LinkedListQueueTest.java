package cursoED.semana6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cursoED.semana5.LinkedListStack;
import cursoED.semana5.Stack;

class LinkedListQueueTest {
	Queue<Integer> listQueue = new LinkedListQueue<>();

	@Test
	void testOffer() {
		assertTrue(listQueue.offer(1));
		assertTrue(listQueue.offer(2));
		assertTrue(listQueue.offer(3));
	}

	@Test
	void testOfferNulo() {
		assertThrows(NullPointerException.class, () -> listQueue.offer(null));
	}

	@Test
	void testPollNoVacio() {
		listQueue.offer(1);
		listQueue.offer(2);
		listQueue.offer(3);
		assertEquals(Integer.valueOf(1), listQueue.poll());
		assertEquals(Integer.valueOf(2), listQueue.poll());
	}

	@Test
	void testPollVacio() {
		assertEquals(null, listQueue.poll());
	}

	@Test
	void testPeekNoVacio() {
		listQueue.offer(1);
		listQueue.offer(2);
		listQueue.offer(3);
		assertEquals(Integer.valueOf(1), listQueue.peek());
		assertEquals(Integer.valueOf(1), listQueue.peek());
		assertEquals(Integer.valueOf(1), listQueue.peek());
	}

	@Test
	void testPeekVacio() {
		assertEquals(null, listQueue.peek());
	}

	@Test
	void testIsEmptyNoVacio() {
		listQueue.offer(1);
		assertFalse(listQueue.isEmpty());
	}

	@Test
	void testIsEmptyVacio() {
		assertTrue(listQueue.isEmpty());
	}

	@Test
	void testToString() {
		assertEquals("[]", listQueue.toString());
		listQueue.offer(1);
		assertEquals("[1]", listQueue.toString());
		listQueue.offer(2);
		assertEquals("[1, 2]", listQueue.toString());
	}

}
