package cursoED.semana13;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiGrafoMatrizCostoTest {
	
	Ciudad[] base = new Ciudad[4];
	DiGrafoMatrizCosto<Ciudad> prueba;
	
	@BeforeEach
	void beforeEach() {
		base[0] = new Ciudad("Lima");
		base[1] = new Ciudad("Quito");
		base[2] = new Ciudad("Huancavelica");
		base[3] = new Ciudad("Cuzco");
		
		prueba = new DiGrafoMatrizCosto<>(base);
	}

	@Test
	void agregarArco1Test() {
		prueba.agregarArco(0, 1, 12);
		assertEquals(12, prueba.adyacencia[0][1]);
		prueba.agregarArco(1,0,12);
		assertEquals(12, prueba.adyacencia[1][0]);
		prueba.agregarArco(3,1,32);
		assertEquals(32, prueba.adyacencia[3][1]);
	}
	
	@Test
	void agregarArco2Test() {
		prueba.agregarArco(new Ciudad("Lima"), new Ciudad("Quito"), 12);
		assertEquals(12, prueba.adyacencia[0][1]);
		prueba.agregarArco(new Ciudad("Quito"),new Ciudad("Lima"),12);
		assertEquals(12, prueba.adyacencia[1][0]);
		prueba.agregarArco(new Ciudad("Cuzco"),new Ciudad("Quito"),32);
		assertEquals(32, prueba.adyacencia[3][1]);
	}
	
	@Test
	void esAdyacente1Test() {
		assertFalse(prueba.esAdyacente(0, 1));
		prueba.agregarArco(0, 1, 12);
		assertTrue(prueba.esAdyacente(0, 1));
		assertFalse(prueba.esAdyacente(1, 0));
		prueba.agregarArco(1,0,12);
		assertTrue(prueba.esAdyacente(1, 0));
		assertFalse(prueba.esAdyacente(3, 1));
		prueba.agregarArco(3,1,32);
		assertTrue(prueba.esAdyacente(3, 1));
		assertFalse(prueba.esAdyacente(3, 3));
	}
	
	@Test
	void esAdyacente2Test() {
		assertFalse(prueba.esAdyacente(new Ciudad("Lima"), new Ciudad("Quito")));
		prueba.agregarArco(0, 1, 12);
		assertTrue(prueba.esAdyacente(new Ciudad("Lima"), new Ciudad("Quito")));
		assertFalse(prueba.esAdyacente(new Ciudad("Quito"),new Ciudad("Lima")));
		prueba.agregarArco(1,0,12);
		assertTrue(prueba.esAdyacente(new Ciudad("Quito"),new Ciudad("Lima")));
		assertFalse(prueba.esAdyacente(new Ciudad("Cuzco"),new Ciudad("Quito")));
		prueba.agregarArco(3,1,32);
		assertTrue(prueba.esAdyacente(new Ciudad("Cuzco"),new Ciudad("Quito")));
		assertFalse(prueba.esAdyacente(new Ciudad("Cuzco"),new Ciudad("Cuzco")));
	}
	
	@Test
	void getFilaAdyacencia1Test() {
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(0));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(1));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(2));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(3));
		prueba.agregarArco(0, 1, 12);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(0));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(1));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(2));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(3));
		prueba.agregarArco(1,0,12);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(0));
		assertArrayEquals(new int[] {12 ,0, 0, 0}, prueba.getFilaAdyacencia(1));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(2));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(3));
		prueba.agregarArco(3,1,32);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(0));
		assertArrayEquals(new int[] {12 ,0, 0, 0}, prueba.getFilaAdyacencia(1));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(2));
		assertArrayEquals(new int[] {0 ,32, 0, 0}, prueba.getFilaAdyacencia(3));
		prueba.agregarArco(0,3,29);
		prueba.agregarArco(1,3,32);
		prueba.agregarArco(1,2,10);
		prueba.agregarArco(2,3,17);
		prueba.agregarArco(0,2,24);
		assertArrayEquals(new int[] {0 ,12, 24, 29}, prueba.getFilaAdyacencia(0));
		assertArrayEquals(new int[] {12 ,0, 10, 32}, prueba.getFilaAdyacencia(1));
		assertArrayEquals(new int[] {0 ,0, 0, 17}, prueba.getFilaAdyacencia(2));
		assertArrayEquals(new int[] {0 ,32, 0, 0}, prueba.getFilaAdyacencia(3));
	}
	
	@Test
	void getFilaAdyacencia2Test() {
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Lima")));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Quito")));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Huancavelica")));
		assertArrayEquals(new int[] {0, 0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Cuzco")));
		prueba.agregarArco(0, 1, 12);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Lima")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Quito")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Huancavelica")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Cuzco")));
		prueba.agregarArco(1,0,12);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Lima")));
		assertArrayEquals(new int[] {12 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Quito")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Huancavelica")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(3));
		prueba.agregarArco(3,1,32);
		assertArrayEquals(new int[] {0 ,12, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Lima")));
		assertArrayEquals(new int[] {12 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Quito")));
		assertArrayEquals(new int[] {0 ,0, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Huancavelica")));
		assertArrayEquals(new int[] {0 ,32, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Cuzco")));
		prueba.agregarArco(0,3,29);
		prueba.agregarArco(1,3,32);
		prueba.agregarArco(1,2,10);
		prueba.agregarArco(2,3,17);
		prueba.agregarArco(0,2,24);
		assertArrayEquals(new int[] {0 ,12, 24, 29}, prueba.getFilaAdyacencia(new Ciudad("Lima")));
		assertArrayEquals(new int[] {12 ,0, 10, 32}, prueba.getFilaAdyacencia(new Ciudad("Quito")));
		assertArrayEquals(new int[] {0 ,0, 0, 17}, prueba.getFilaAdyacencia(new Ciudad("Huancavelica")));
		assertArrayEquals(new int[] {0 ,32, 0, 0}, prueba.getFilaAdyacencia(new Ciudad("Cuzco")));
	}

}
