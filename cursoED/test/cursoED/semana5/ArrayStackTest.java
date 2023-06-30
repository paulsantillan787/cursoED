package cursoED.semana5;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {
	ArrayStack<Integer> stack = new ArrayStack<>(5);

	@Test
	void testArray() {
		ArrayStack<Integer> prueba = new ArrayStack<>();
	}

	@Test
	void testPushDentroDelRango() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertFalse(stack.empty());
	}

	@Test
	void testPushFueraDelRango() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(8);
		assertThrows(RuntimeException.class, () -> stack.push(12));
	}

	@Test
	void testPopNoVacio() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.pop());
	}

	@Test
	void testPopVacio() {
		assertThrows(RuntimeException.class, () -> stack.pop());
	}

	@Test
	void testPeekNoVacio() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.peek());
	}

	@Test
	void testPeekVacio() {
		assertThrows(RuntimeException.class, () -> stack.peek());
	}

	@Test
	void testEmptyVacio() {
		assertTrue(stack.empty());
	}

	@Test
	void testEmptyNoVacio() {
		stack.push(1);
		assertFalse(stack.empty());
	}

	@Test
	void testToString() {
		assertEquals("[]", stack.toString());
		stack.push(1);
		assertEquals("[1]", stack.toString());
		stack.push(2);
		assertEquals("[2, 1]", stack.toString());
	}

}
