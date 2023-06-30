package cursoED.semana2;

import cursoED.util.Complejo;

public class ArrayDeObjetos {
	
	private static void buscarDemo() {
		Complejo [] datos = {new Complejo(1, 2), new Complejo(5, 7), new Complejo(6, 3)};
		Complejo dato = new Complejo(1, 2);
		long veces = contarRepeticion(datos, dato);
		System.out.printf("%s se encuentra %d veces%n", dato, veces);
	}
	
	public static long contarRepeticion(Complejo[] datos, Complejo dato) {
		int cuenta = 0;
		for(int i = 0;i<datos.length;i++) {
			if(datos[i].equals(dato)) {
				cuenta++;
			}
		}
		return cuenta;
	}

	public static void main(String[] args) {
		buscarDemo();
	}
}
