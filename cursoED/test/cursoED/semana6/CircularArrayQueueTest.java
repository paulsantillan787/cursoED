package cursoED.semana6;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularArrayQueueTest {
	CircularArrayQueue<Integer> colaCircular = new CircularArrayQueue<Integer>(5);

	@Test
	void testCircularArrayQueue() {
		CircularArrayQueue<Integer> prueba = new CircularArrayQueue<Integer>();
	}

	@Test
	void testOfferNoLleno() {
		assertTrue(colaCircular.offer(1));
		assertTrue(colaCircular.offer(2));
		assertTrue(colaCircular.offer(3));
	}

	@Test
	void testOfferLleno() {
		assertTrue(colaCircular.offer(1));
		assertTrue(colaCircular.offer(2));
		assertTrue(colaCircular.offer(3));
		assertTrue(colaCircular.offer(2));
		assertTrue(colaCircular.offer(3));
		assertFalse(colaCircular.offer(5));
	}

	@Test
	void testOfferNulo() {
		assertThrows(NullPointerException.class, () -> colaCircular.offer(null));
	}

	@Test
	void testPollNoVacio() {
		colaCircular.offer(1);
		colaCircular.offer(2);
		assertEquals(Integer.valueOf(1), colaCircular.poll());
		assertEquals(Integer.valueOf(2), colaCircular.poll());
	}

	@Test
	void testPollVacio() {
		assertEquals(null, colaCircular.poll());
	}

	@Test
	void testPeekNoVacio() {
		colaCircular.offer(1);
		colaCircular.offer(2);
		colaCircular.offer(3);
		assertEquals(Integer.valueOf(1), colaCircular.peek());
		assertEquals(Integer.valueOf(1), colaCircular.peek());
		assertEquals(Integer.valueOf(1), colaCircular.peek());
	}

	@Test
	void testPeekVacio() {
		assertEquals(null, colaCircular.peek());
	}

	@Test
	void testIsEmptyNoVacio() {
		colaCircular.offer(1);
		assertFalse(colaCircular.isEmpty());
	}

	@Test
	void testIsEmptyVacio() {
		assertTrue(colaCircular.isEmpty());
	}

	@Test
	void testIsFullNoLleno() {
		colaCircular.offer(1);
		colaCircular.offer(2);
		colaCircular.offer(4);
		assertFalse(colaCircular.isFull());
	}

	@Test
	void testIsFullLleno() {
		colaCircular.offer(1);
		colaCircular.offer(2);
		colaCircular.offer(3);
		colaCircular.offer(4);
		colaCircular.offer(5);
		colaCircular.offer(6);
		assertTrue(colaCircular.isFull());
	}

	@Test
	void testToString() {
		assertEquals("[]", colaCircular.toString());
		colaCircular.offer(1);
		assertEquals("[1]", colaCircular.toString());
		colaCircular.offer(2);
		assertEquals("[1, 2]", colaCircular.toString());
	}

}
