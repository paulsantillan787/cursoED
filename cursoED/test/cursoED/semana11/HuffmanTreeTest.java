package cursoED.semana11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuffmanTreeTest {
	char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int[] charfreq = { 45, 13, 12, 16, 9, 5 };
	HuffmanTree h = new HuffmanTree(charArray, charfreq);
	
	@Test
	void testGetCodificadoExistentes() {
		assertEquals("0", h.getCodificado('a'));
		assertEquals("100", h.getCodificado('c'));
		assertEquals("101", h.getCodificado('b'));
		assertEquals("1100", h.getCodificado('f'));
		assertEquals("1101", h.getCodificado('e'));
		assertEquals("111", h.getCodificado('d'));
	}

	@Test
	void testGetCodificadoNoExistentes() {
		assertNull(h.getCodificado('z'));
	}

	@Test
	void testGetDesCodificadoExistentesBasicos() {
		assertEquals("a", h.getDesCodificado("0"));
		assertEquals("c", h.getDesCodificado("100"));
		assertEquals("b", h.getDesCodificado("101"));
		assertEquals("f", h.getDesCodificado("1100"));
		assertEquals("e", h.getDesCodificado("1101"));
		assertEquals("d", h.getDesCodificado("111"));
	}

	@Test
	void testGetDesCodificadoExistentesCombinados() {
		assertEquals("ac", h.getDesCodificado("0100"));
		assertEquals("acbfed", h.getDesCodificado("010010111001101111"));
	}
	@Test
	void testGetDesCodificadoNoExistentes() {
		assertThrows(RuntimeException.class, () -> h.getDesCodificado("1") );
		assertThrows(RuntimeException.class, () -> h.getDesCodificado("01001"));
	}

}
