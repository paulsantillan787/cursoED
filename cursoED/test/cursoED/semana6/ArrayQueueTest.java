package cursoED.semana6;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {
	ArrayQueue<Integer> cola = new ArrayQueue<Integer>(5);

	@Test
	void testArrayQueue() {
		ArrayQueue<Integer> prueba = new ArrayQueue<Integer>();
	}

	@Test
	void testOfferNoLleno() {
		assertTrue(cola.offer(1));
		assertTrue(cola.offer(2));
		assertTrue(cola.offer(3));
	}

	@Test
	void testOfferLleno() {
		assertTrue(cola.offer(1));
		assertTrue(cola.offer(2));
		assertTrue(cola.offer(3));
		assertTrue(cola.offer(2));
		assertTrue(cola.offer(3));
		assertFalse(cola.offer(4));
	}

	@Test
	void testOfferNulo() {
		assertThrows(NullPointerException.class, () -> cola.offer(null));
	}

	@Test
	void testPollNoVacio() {
		cola.offer(1);
		cola.offer(2);
		cola.offer(3);
		assertEquals(Integer.valueOf(1), cola.poll());
		assertEquals(Integer.valueOf(2), cola.poll());
	}

	@Test
	void testPollVacio() {
		assertEquals(null, cola.poll());
	}

	@Test
	void testPeekNoVacio() {
		cola.offer(1);
		cola.offer(2);
		cola.offer(3);
		assertEquals(Integer.valueOf(1), cola.peek());
		assertEquals(Integer.valueOf(1), cola.peek());
		assertEquals(Integer.valueOf(1), cola.peek());
	}

	@Test
	void testPeekVacio() {
		assertEquals(null, cola.peek());
	}

	@Test
	void testIsEmptyNoVacio() {
		cola.offer(1);
		assertFalse(cola.isEmpty());
	}

	@Test
	void testIsEmptyVacio() {
		assertTrue(cola.isEmpty());
	}

	@Test
	void testIsFullNoLleno() {
		cola.offer(1);
		cola.offer(2);
		cola.offer(4);
		assertFalse(cola.isFull());
	}

	@Test
	void testIsFullLleno() {
		cola.offer(1);
		cola.offer(2);
		cola.offer(4);
		cola.offer(2);
		cola.offer(4);
		assertTrue(cola.isFull());
	}

	@Test
	void testToString() {
		assertEquals("[]", cola.toString());
		cola.offer(1);
		assertEquals("[1]", cola.toString());
		cola.offer(2);
		assertEquals("[1, 2]", cola.toString());
	}

}
