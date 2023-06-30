package cursoED.semana2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MCDTest {
	@Test
	void testMcdCon48y60DebeDar12() {
		assertEquals(12, MCD.mcd(48,60));
	}

	@Test
	void testMcdCon42y56DebeDar14() {
		assertEquals(14, MCD.mcd(42,56));
	}

	@Test
	void testMcdConNumerosCoprimosDebeDar1() {
		assertEquals(1, MCD.mcd(6,7));
		assertEquals(1, MCD.mcd(14,15));
		assertEquals(1, MCD.mcd(3,5));
		assertEquals(1, MCD.mcd(6,19));
	}
}