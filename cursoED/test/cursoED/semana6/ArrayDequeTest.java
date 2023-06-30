package cursoED.semana6;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * 
 * Este test contiene test para isEmpty y toString, y no deben ser eliminados o
 * cambiados. Solamente deben agregar tests para el resto de los metodos
 * faltantes
 *
 */
class ArrayDequeTest {
	private static final int NUM_ELEM_INICIAL = 5;
	private Deque<Integer> deq;
	private Deque<Integer> deqElems;

	@BeforeEach
	void init() {
		deq = new ArrayDeque<>(NUM_ELEM_INICIAL);
		deqElems = new ArrayDeque<>(NUM_ELEM_INICIAL);
		for (int i = 0; i < NUM_ELEM_INICIAL; i++) {
			deqElems.offer(i + 1);
		}
	}
	
	@Test
	void testDefaultConstructor() {
		Deque<Integer> prueba = new ArrayDeque();
	}

	@Test
	void testAddFirstConValores() {
		deq.addFirst(1);
		assertEquals(1, deq.getFirst());
		deq.addFirst(2);
		assertEquals(2, deq.getFirst());
		deq.addFirst(3);
		assertEquals(3, deq.getFirst());

	}

	@Test
	void testAddFirstConAumento() {
		deq.addFirst(1);
		deq.addFirst(2);
		deq.addFirst(3);
		deq.addFirst(4);
		deq.addFirst(5);
		deq.addFirst(6);
		assertEquals(6, deq.getFirst());
		assertEquals(6, deq.getFirst());
		assertEquals(6, deq.getFirst());
	}

	@Test
	void testAddFirstNulo() {
		assertThrows(NullPointerException.class, () -> deq.addFirst(null));
	}

	@Test
	void testAddLastConValores() {
		deq.addLast(1);
		assertEquals(1, deq.getLast());
		deq.addLast(2);
		assertEquals(2, deq.getLast());
		deq.addLast(3);
		assertEquals(3, deq.getLast());
	}

	@Test
	void testAddLastConAumento() {
		deq.addLast(1);
		deq.addLast(2);
		deq.addLast(3);
		deq.addLast(4);
		deq.addLast(5);
		deq.addLast(6);
		assertEquals(6, deq.getLast());
		assertEquals(6, deq.getLast());
		assertEquals(6, deq.getLast());
	}

	@Test
	void testAddLastNulo() {
		assertThrows(NullPointerException.class, () -> deq.addLast(null));
	}

	@Test
	void testRemoveFirstVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.removeFirst());
	}

	@Test
	void testRemoveFirstConValores() {
		deq.addFirst(1);
		deq.add(2);
		deq.add(3);
		assertEquals(1, deq.removeFirst());
		assertEquals(2, deq.removeFirst());
		assertEquals(3, deq.removeFirst());
	}

	@Test
	void testRemoveLastVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.removeLast());
	}

	@Test
	void testRemoveLastConValores() {
		deq.addLast(1);
		deq.addLast(2);
		deq.addLast(3);
		assertEquals(3, deq.removeLast());
		assertEquals(2, deq.removeLast());
		assertEquals(1, deq.removeLast());
	}

	@Test
	void testGetFirstVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.getFirst());
	}

	@Test
	void testGetFirstConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(3);
		assertEquals(1, deq.getFirst());
		assertEquals(1, deq.getFirst());
		assertEquals(1, deq.getFirst());
	}

	@Test
	void testGetLastVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.getLast());
	}

	@Test
	void testGetLastConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(3);
		assertEquals(3, deq.getLast());
		assertEquals(3, deq.getLast());
		assertEquals(3, deq.getLast());
	}

	@Test
	void testOfferFirstConValores() {
		assertTrue(deq.offerFirst(1));
		assertTrue(deq.offerFirst(2));
		assertTrue(deq.offerFirst(3));
	}

	@Test
	void testOfferFirstConAumento() {
		assertTrue(deq.offerFirst(1));
		assertTrue(deq.offerFirst(2));
		assertTrue(deq.offerFirst(3));
		assertTrue(deq.offerFirst(4));
		assertTrue(deq.offerFirst(5));
		assertTrue(deq.offerFirst(6));
		assertTrue(deq.offerFirst(7));
	}

	@Test
	void testOfferLastConValores() {
		assertTrue(deq.offerLast(1));
		assertTrue(deq.offerLast(2));
		assertTrue(deq.offerLast(3));
	}

	@Test
	void testOfferLastConAumento() {
		assertTrue(deq.offerLast(1));
		assertTrue(deq.offerLast(2));
		assertTrue(deq.offerLast(3));
		assertTrue(deq.offerLast(4));
		assertTrue(deq.offerLast(5));
		assertTrue(deq.offerLast(6));
		assertTrue(deq.offerLast(7));
	}

	@Test
	void testPollFirstVacio() {
		assertEquals(null, deq.pollFirst());
	}

	@Test
	void testPollFirstConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(4);
		assertEquals(1, deq.pollFirst());
		assertEquals(2, deq.pollFirst());
		assertEquals(4, deq.pollFirst());
	}

	@Test
	void testPollLastVacio() {
		assertEquals(null, deq.pollLast());
	}

	@Test
	void testPollLastConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(4);
		assertEquals(4, deq.pollLast());
		assertEquals(2, deq.pollLast());
		assertEquals(1, deq.pollLast());
	}

	@Test
	void testPeekFirstVacio() {
		assertEquals(null, deq.peekFirst());
	}

	@Test
	void testPeekFirstConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(4);
		assertEquals(1, deq.peekFirst());
		assertEquals(1, deq.peekFirst());
		assertEquals(1, deq.peekFirst());
	}

	@Test
	void testPeekLastVacio() {
		assertEquals(null, deq.peekFirst());
	}

	@Test
	void testPeekLastConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(4);
		assertEquals(4, deq.peekLast());
		assertEquals(4, deq.peekLast());
		assertEquals(4, deq.peekLast());
	}

	@Test
	void testAddConValores() {
		assertTrue(deq.add(12));
		assertTrue(deq.add(11));
	}

	@Test
	void testAddConAumento() {
		assertTrue(deq.add(12));
		assertTrue(deq.add(24));
		assertTrue(deq.add(55));
		assertTrue(deq.add(1));
		assertTrue(deq.add(8));
		assertTrue(deq.add(4));
		assertTrue(deq.add(3));
		assertTrue(deq.add(5));
	}

	@Test
	void testAddNulo() {
		assertThrows(NullPointerException.class, () -> deq.add(null));
	}

	@Test
	void testRemoveVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.remove());
	}

	@Test
	void testRemoveConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(3);
		deq.add(4);
		deq.add(5);
		assertEquals(1, deq.remove());
		assertEquals(2, deq.remove());
	}

	@Test
	void testElementVacio() {
		assertThrows(NoSuchElementException.class, () -> deq.element());
	}

	@Test
	void testElementConValores() {
		deq.add(1);
		deq.add(2);
		deq.add(3);
		deq.add(4);
		deq.add(5);
		assertEquals(1, deq.element());
		assertEquals(1, deq.element());
		assertEquals(1, deq.element());
	}

	@Test
	void testOfferConValores() {
		assertTrue(deq.offer(2));
		assertTrue(deq.offer(5));
		assertTrue(deq.offer(8));
	}

	@Test
	void testOfferConAumento() {
		assertTrue(deq.offer(2));
		assertTrue(deq.offer(5));
		assertTrue(deq.offer(8));
		assertTrue(deq.offer(7));
		assertTrue(deq.offer(4));
		assertTrue(deq.offer(3));
		assertTrue(deq.offer(9));
	}

	@Test
	void testPollVacio() {
		assertEquals(null, deq.poll());
	}

	@Test
	void testPollConValores() {
		deq.add(1);
		deq.add(3);
		deq.add(5);
		deq.add(7);
		assertEquals(1, deq.poll());
		assertEquals(3, deq.poll());
		assertEquals(5, deq.poll());
		assertEquals(7, deq.poll());
	}
	
	@Test
	void testPeekVacio() {
		assertEquals(null, deq.peek());
	}

	@Test
	void testPeekConValores() {
		deq.add(1);
		deq.add(3);
		deq.add(5);
		deq.add(7);
		assertEquals(1, deq.peek());
		assertEquals(1, deq.peek());
		assertEquals(1, deq.peek());
	}

	@Test
	void testPushConValores() {
		deq.push(1);
		assertEquals(1, deq.peek());
		deq.push(4);
		assertEquals(4, deq.peek());
	}
	
	@Test
	void testPushNulo() {
		assertThrows(NullPointerException.class, () -> deq.push(null));
	}

	@Test
	void testPushConAumento() {
		deq.push(1);
		deq.push(3);
		deq.push(5);
		deq.push(7);
		assertEquals(7, deq.peek());
		assertEquals(7, deq.peek());
		assertEquals(7, deq.peek());
	}
	
	@Test
	void testPopConValores() {
		deq.push(1);
		deq.push(4);
		deq.push(5);
		assertEquals(5, deq.pop());
		assertEquals(4, deq.pop());
		assertEquals(1, deq.pop());
	}
	
	@Test
	void testPopNulo() {
		assertThrows(NoSuchElementException.class, () -> deq.pop());
	}
	
	@Test
	void testEmptyDeqInicialmenteEsEmpty() {
		assertTrue(deq.isEmpty());
		deq.offer(10);
		assertFalse(deq.isEmpty());
	}

	@Test
	void testEmptyDeqElemsInicialmenteNoEsEmpty() {
		assertFalse(deqElems.isEmpty());
		for (int i = 0; i < NUM_ELEM_INICIAL; i++) {
			deqElems.poll();
		}
		assertTrue(deqElems.isEmpty());
	}

	@Test
	void testTOStringConCeroUnoYDosElemento() {
		assertEquals("[]", deq.toString());
		deq.offer(10);
		assertEquals("[10]", deq.toString());
		deq.offer(20);
		assertEquals("[10, 20]", deq.toString());
	}

	@Test
	void testTOStringConNumeroElementosIgualYMayorAlNumeroElementoInicial() {
		assertEquals("[1, 2, 3, 4, 5]", deqElems.toString());
		deqElems.offer(6);
		deqElems.offer(7);
		assertEquals("[1, 2, 3, 4, 5, 6, 7]", deqElems.toString());
	}

	@Test
	void testTOStringConNumeroElementosMayorAlNumeroElementoInicialYConIncremento() {
		for (int i = 6; i <= 12; i++) {
			deqElems.offer(i);
		}
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]", deqElems.toString());
	}

}
