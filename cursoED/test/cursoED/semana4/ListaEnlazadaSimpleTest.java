package cursoED.semana4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ListaEnlazadaSimpleTest {
	Lista<Integer> lista = new ListaEnlazadaSimple<>();

	@Test
	void testTamanyoLaListaInicialmenteTieneTamanyo0() {
		assertEquals(0, lista.tamanyo());
	}

	@Test
	void testTamanyoConAlgunosElementos() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(3, lista.tamanyo());
	}

	@Test
	void testEsVacioInicialmenteEsVacia() {
		assertTrue(lista.esVacio());
	}

	@Test
	void testEsVacioConAlgunosElementosNoEsVacia() {
		lista.agregar(1);
		assertFalse(lista.esVacio());
	}

	@Test
	void testContiene() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertTrue(lista.contiene(1));
		assertTrue(lista.contiene(2));
		assertTrue(lista.contiene(3));
		assertFalse(lista.contiene(4));

	}

	@Test
	void testAgregarE() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
		assertEquals(3, lista.tamanyo());
	}

	@Test
	void testAgregarIntEAlPrincipio() {
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(0, 1);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));

		assertEquals(3, lista.tamanyo());
	}

	@Test
	void testAgregarIntEAlFinal() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(2, 3);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));

		assertEquals(3, lista.tamanyo());
	}

	@Test
	void testAgregarIntEAlMedio() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(4);
		lista.agregar(2, 3);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
		assertEquals(4, lista.get(3));

		assertEquals(4, lista.tamanyo());
	}

	@Test
	void testAgregarIntEAlmedio2() {
		lista.agregar(1);
		lista.agregar(3);
		lista.agregar(1, 2);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
	}
	
	@Test
	void testAgregarConIndiceFueraDeRango() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertThrows(IndexOutOfBoundsException.class, () -> lista.agregar(4,1));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.agregar(-2,1));
	}

	@Test
	void testRemoverObjectAlPrincipio() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertTrue(lista.remover(Integer.valueOf(1)));
		assertEquals(2, lista.get(0));
		assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverObjectAlFinal() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertTrue(lista.remover(Integer.valueOf(3)));
		assertEquals(2, lista.get(1));
		assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverObjectAlMedio() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertTrue(lista.remover(Integer.valueOf(2)));
		assertEquals(1, lista.get(0));
		assertEquals(3, lista.get(1));
		assertEquals(2, lista.tamanyo());
	}
	
	@Test
	void testRemoverObjectNull() {
		lista.agregar(null);
		assertTrue(lista.remover(null));
	}
	
	@Test
	void testRemoverObjectNull2() {
		lista.agregar(1);
		assertFalse(lista.remover(null));
	}
	
	@Test
	void testRemoverObjectNoNull() {
		lista.agregar(null);
		assertFalse(lista.remover(Integer.valueOf(1)));
	}

	@Test
	void testRemoverIntAlPrincipio() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(1, lista.remover(0));
		assertEquals(2, lista.get(0));
		assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverIntAlFinal() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(3, lista.remover(2));
		assertEquals(2, lista.get(1));
		assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverIntAlMedio() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(2, lista.remover(1));
		assertEquals(1, lista.get(0));
		assertEquals(3, lista.get(1));

		assertEquals(2, lista.tamanyo());
	}

	@Test
	void testLimpiar() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.limpiar();
		assertEquals(0, lista.tamanyo());
	}

	@Test
	void testGet() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
	}

	@Test
	void testGetConIndiceFueraDeRango() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(7));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
	}

	@Test
	void testSet() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);

		assertEquals(1, lista.set(0, 11));
		assertEquals(2, lista.set(1, 12));
		assertEquals(3, lista.set(2, 13));

		assertEquals(11, lista.get(0));
		assertEquals(12, lista.get(1));
		assertEquals(13, lista.get(2));
	}

	@Test
	void testIndiceDe() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(0, lista.indiceDe(1));
		assertEquals(1, lista.indiceDe(2));
		assertEquals(2, lista.indiceDe(3));
	}

	@Test
	void testIndiceDeConValoresNulos() {
		lista.agregar(1);
		lista.agregar(null);
		lista.agregar(3);
		assertEquals(1, lista.indiceDe(null));
	}

	@Test
	void testIndiceDeNullConValoresNoNulos() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		assertEquals(-1, lista.indiceDe(null));
	}

	@Test
	void testToArray() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		Object[] arreglo = {(Object)1,(Object)2,(Object)3};
		assertTrue(Arrays.equals(arreglo, lista.toArray()));
	}

	@Test
	void testToString() {
		assertEquals("Lista()", lista.toString());
		lista.agregar(1);
		assertEquals("Lista(1)", lista.toString());
		lista.agregar(2);
		lista.agregar(3);
		assertEquals("Lista(1, 2, 3)", lista.toString());
	}

}