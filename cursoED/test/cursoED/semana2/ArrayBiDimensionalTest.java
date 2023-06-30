package cursoED.semana2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayBiDimensionalTest {

	@Test
	void testContarRepeticionConMaximaRepeticion() {
		assertEquals(6, ArrayBiDimensional.contarRepeticion(new int[][] {{1, 1, 1},{1,1,1}}, 1));
	}
	
	@Test
	void testContarRepeticionConCeroRepeticion() {
		assertEquals(0, ArrayBiDimensional.contarRepeticion(new int[][] {{1, 1, 1},{1,1,1}}, 2));
	}
	
	@Test
	void testContarRepeticionConRepeticionAlInicio() {
		assertEquals(1, ArrayBiDimensional.contarRepeticion(new int[][] {{1, 4, 5},{6,7,8}}, 1));
	}

	@Test
	void testContarRepeticionConRepeticionAlFinal() {
		assertEquals(1, ArrayBiDimensional.contarRepeticion(new int[][] {{1, 2, 6},{5,3,4}}, 4));
	}
	
	@Test
	void testContarNumerosPrimos() {
		assertEquals(3, ArrayBiDimensional.contarNumerosPrimos(new int[][] {{2, 5, 4},{7,8,9}}));
		assertEquals(4, ArrayBiDimensional.contarNumerosPrimos(new int[][] {{2, 6, 4},{7,11,13}}));
	}
	
	@Test
	void testContarNumerosPrimosConNingunNumeroPrimo() {
		assertEquals(0, ArrayBiDimensional.contarNumerosPrimos(new int[][] {{4, 10, 6},{6,9,8}}));
	}

}
