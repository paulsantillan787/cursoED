package cursoED.semana2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cursoED.util.Complejo;

class ComplejoTest {
	
	Complejo com = new Complejo(2,3);
	
	@Test
	void igualarComplejos() {
		assertTrue(com.equals(com));
	}
}
