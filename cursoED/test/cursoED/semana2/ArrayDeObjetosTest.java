package cursoED.semana2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cursoED.util.Complejo;

class ArrayDeObjetosTest {

	@Test
	void testContarRepeticionConMaximaRepeticion() {
		assertEquals(3, ArrayDeObjetos.contarRepeticion(new Complejo[] {new Complejo(1, 2), new Complejo(1, 2), new Complejo(1, 2)}, new Complejo(1,2)));
	}
	
	@Test
	void testContarRepeticionConCeroRepeticion() {
		assertEquals(0, ArrayDeObjetos.contarRepeticion(new Complejo[] {new Complejo(2, 3), new Complejo(3, 4), new Complejo(4, 5)}, new Complejo(1,2)));
	}
	
	@Test
	void testContarRepeticionConRepeticionAlInicio() {
		assertEquals(1, ArrayDeObjetos.contarRepeticion(new Complejo[] {new Complejo(2, 3), new Complejo(3, 4), new Complejo(4, 5)}, new Complejo(2,3)));
	}

	@Test
	void testContarRepeticionConRepeticionAlFinal() {
		assertEquals(1, ArrayDeObjetos.contarRepeticion(new Complejo[] {new Complejo(2, 3), new Complejo(3, 4), new Complejo(4, 5)}, new Complejo(4,5)));
	}
}
