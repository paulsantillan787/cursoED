package cursoED.semana5;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	Stack<Integer> listStack = new LinkedListStack<>();

	@Test
	void testPush() {
		listStack.push(1);
		listStack.push(2);
		listStack.push(3);
		listStack.push(4);
		assertFalse(listStack.empty());
	}

	@Test
	void testPopNoVacio() {
		listStack.push(1);
		listStack.push(2);
		listStack.push(3);
		assertEquals(3, listStack.pop());
	}

	@Test
	void testPopVacio() {
		assertThrows(RuntimeException.class, () -> listStack.pop());
	}

	@Test
	void testPeekNoVacio() {
		listStack.push(1);
		listStack.push(2);
		listStack.push(3);
		assertEquals(3, listStack.peek()); //por lo menos 2 veces
		assertEquals(3, listStack.peek());
		assertEquals(3, listStack.peek());
	}

	@Test
	void testPeekVacio() {
		assertThrows(RuntimeException.class, () -> listStack.peek());
	}

	@Test
	void testEmptyVacio() {
		assertTrue(listStack.empty());
	}

	@Test
	void testEmptyNoVacio() {
		listStack.push(1);
		assertFalse(listStack.empty());
	}

	@Test
	void testToString() {
		assertEquals("[]", listStack.toString());
		listStack.push(1);
		assertEquals("[1]", listStack.toString());
		listStack.push(2);
		assertEquals("[2, 1]", listStack.toString());
	}

}
