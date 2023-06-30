package cursoED.semana10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbolAvlTest {
	ArbolAvl<Integer> arbol;

	@BeforeEach
	void testArbolAvl() {
		arbol = new ArbolAvl<>();
	}

	@Test
	void testInsertarArbolVacio() {
		arbol.insertar(1);
		/*
		 *		(1)
		 */
		assertEquals(1, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
	}

	@Test
	void testInsertArbolNoVacio() {
		arbol.insertar(1);
		arbol.insertar(2);
		/*
		 *		(1)	
		 * 		   \
		 * 	       (2)
		 */
		assertEquals(1, arbol.getRaiz().getDato());
		assertEquals(1, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
	}
	
	@Test
	void testInsertDatoRepetido() {
		arbol.insertar(1);
		arbol.insertar(2);
		assertThrows(RuntimeException.class, () -> arbol.insertar(1));
	}
	
	@Test
	void testInsertEnEquilibrio() {
		arbol.insertar(4);
		arbol.insertar(6);
		arbol.insertar(3);
		arbol.insertar(2);
		arbol.insertar(5);
		/*
		 * 		 (4)
		 *      /   \
		 * 	  (3)   (6)
		 *    /     /
		 *  (2)    (5)
		 */
		assertEquals(4, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDato());
		assertEquals(-1, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getDato());
		assertEquals(-1, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(5, arbol.getRaiz().getDcho().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getIzdo()).fe);
	}
	
	@Test
	void testInsertRotacionII() {
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(1);
		/*
		 * 		(4)	                    (2)
		 *       /                     /   \
		 * 	   (2)        -->        (1)   (4)
		 *     /
		 *   (1)
		 */
		assertEquals(2, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(4, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
	}
	
	@Test
	void testInsertRotacionID() {
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(3);
		arbol.insertar(1);
		/*
		 * 		(3)
		 *      /  \
		 *    (2)   (4)
		 *    /
		 *  (1) 
		 */
		assertEquals(3, arbol.getRaiz().getDato());
		assertEquals(-1, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getDato());
		assertEquals(-1, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(4, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
	}
	
	@Test
	void testInsertRotacionDD() {
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(7);
		/*
		 * 		(6)
		 *     /   \
		 *   (5)   (7)
		 */
		assertEquals(6, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(5, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(7, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
	}
	
	@Test
	void testInsertRotacionDI() {
		arbol.insertar(3);
		arbol.insertar(6);
		arbol.insertar(5);
		arbol.insertar(7);
		/*
		 * 		(5)
		 *     /  \ 
		 *    (3)  (6)
		 *          \
		 *          (7)
		 */
		assertEquals(5, arbol.getRaiz().getDato());
		assertEquals(1, arbol.getRaiz().fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDato());
		assertEquals(1, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(7, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
	}
	
	@Test
	void testInsertIDeII() {
		arbol.insertar(10);
		arbol.insertar(9);
		arbol.insertar(8);
		arbol.insertar(7);
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(3);
		/*
		 * 		 (7)
		 *      /   \
		 *    (5)    (9)
		 *    / \    /  \
		 *  (3) (6) (8) (10)
		 */
		assertEquals(7, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(5, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(9, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getIzdo().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getDcho()).fe);
		assertEquals(10, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(8, arbol.getRaiz().getDcho().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getIzdo()).fe);
	}
	
	@Test
	void testInsertDIyDD() {
		arbol.insertar(2);
		arbol.insertar(1);
		arbol.insertar(3);
		arbol.insertar(4);
		arbol.insertar(6);
		arbol.insertar(5);
		arbol.insertar(7);
		/*
		 * 		 (4)
		 *      /   \
		 *    (2)    (6)
		 *    / \    /  \
		 *  (1) (3) (5) (7)
		 */
		assertEquals(4, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getDcho()).fe);
		assertEquals(7, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(5, arbol.getRaiz().getDcho().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getIzdo()).fe);
	}
	
	@Test
	void testInsertRotacionDIelseMas1() {
		arbol.insertar(2);
		arbol.insertar(1);
		arbol.insertar(3);
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(4);
		/*
		 *            (3)
		 *            / \
		 *          (2)  (5)
		 *          /    /  \
		 *        (1)  (4)  (6)
		 */
		assertEquals(3, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getDato());
		assertEquals(-1, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(5, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(4, arbol.getRaiz().getDcho().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getIzdo()).fe);
	}
	
	@Test
	void testInsertRotacionDIelseMenos1() {
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(4);
		arbol.insertar(2);
		arbol.insertar(1);
		arbol.insertar(3);
		/*
		 *            (4)
		 *            / \
		 *          (2)  (5)
		 *          / \    \
		 *        (1)  (3)  (6)
		 */
		assertEquals(4, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(5, arbol.getRaiz().getDcho().getDato());
		assertEquals(1, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getDcho()).fe);
	}
	
	@Test
	void testInsertRotacionIDelseMenos1() {
		arbol.insertar(3);
		arbol.insertar(2);
		arbol.insertar(6); 
		arbol.insertar(5);
		arbol.insertar(7);
		arbol.insertar(4);
		/*
		 *             (5)
		 *            /   \
		 *          (3)    (6)
		 *          / \      \
		 *        (2) (4)    (7)
		 */
		assertEquals(5, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(3, arbol.getRaiz().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo()).fe);
		assertEquals(6, arbol.getRaiz().getDcho().getDato());
		assertEquals(1, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(7, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(4, arbol.getRaiz().getIzdo().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getDcho()).fe);
	}
	
	@Test
	void testInsertRotacionIDelseMas1() {
		arbol.insertar(7);
		arbol.insertar(2);
		arbol.insertar(8); 
		arbol.insertar(1);
		arbol.insertar(4);
		arbol.insertar(5);
		/*
		 *            (4)
		 *            / \
		 *          (2)  (7)
		 *          /    /  \
		 *        (1)  (5)  (8)
		 */
		assertEquals(4, arbol.getRaiz().getDato());
		assertEquals(0, arbol.getRaiz().fe);
		assertEquals(2, arbol.getRaiz().getIzdo().getDato());
		assertEquals(-1, ((NodoAvl<Integer>) arbol.getRaiz().getIzdo()).fe);
		assertEquals(7, arbol.getRaiz().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho()).fe);
		assertEquals(1, arbol.getRaiz().getIzdo().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getIzdo().getIzdo()).fe);
		assertEquals(8, arbol.getRaiz().getDcho().getDcho().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getDcho()).fe);
		assertEquals(5, arbol.getRaiz().getDcho().getIzdo().getDato());
		assertEquals(0, ((NodoAvl<Integer>)arbol.getRaiz().getDcho().getIzdo()).fe);
	}
}
