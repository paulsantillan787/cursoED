package cursoED.semana9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbolBinarioTest {

	ArbolBinario<String> arbol;
	
	@BeforeEach
	void init() {
		Nodo<String> izdo, dcho, centro1, centro2, centro3;
		izdo = new Nodo<>(null, "Maria",null);
		dcho = new Nodo<>(null,"Rodrigo",null);
		centro1 = new Nodo<>(izdo, "Esperanza", dcho);
		izdo = new Nodo<>(null,"Anyora",null);
		dcho = new Nodo<>(null,"Abel",null);
		centro2 = new Nodo<>(izdo,"M Jesus",dcho);
		centro3 = new Nodo<>(centro1, "Esperanza", centro2);
		arbol = new ArbolBinario<>(centro3);
	}
	
	@Test
	void testPreOrden() {
		assertEquals("Esperanza Esperanza Maria Rodrigo M Jesus Anyora Abel ", arbol.preordenSTR());
	}
	
	@Test
	void testInOrden() {
		assertEquals("Maria Esperanza Rodrigo Esperanza Anyora M Jesus Abel ", arbol.inordenSTR());
	}
	
	@Test
	void testPostOrden() {
		assertEquals("Maria Rodrigo Esperanza Anyora Abel M Jesus Esperanza ", arbol.postordenSTR());
	}

}
