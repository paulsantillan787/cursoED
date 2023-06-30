package cursoED.semana3;

import java.util.List;
import java.util.ArrayList;

public class OrdenacionBurbuja {
	
	public static <T extends Comparable<T>> void burbuja(List<T> lista) {
		boolean interruptor = true;
		int pasada, j;
		int n = lista.size();
		// bucle externo controla la cantidad de pasadas
		for (pasada = 0; pasada < n - 1 && interruptor; pasada++) {
			interruptor = false;
			for (j = 0; j < n - pasada - 1; j++) {
				T elem = lista.get(j);
				if (elem.compareTo(lista.get(j + 1)) > 0) {
					// elementos desordenados, se intercambian
					interruptor = true;
					intercambiar(lista, j, j + 1);
				}
			}
		}
	}
	
	//cambiar la funcion intercambiar
	private static <T extends Comparable<T>> void intercambiar(List<T> lista, int i, int j) {
		T aux = lista.get(i);
		lista.set(i, lista.get(j));
		lista.set(j, aux);
	}
	
	private static <T extends Comparable<T>> void demo(){
		List<Racional> lista = new ArrayList<>();
		lista.add(new Racional(1,2));
		lista.add(new Racional(3,2));
		lista.add(new Racional(7,5));
		lista.add(new Racional(5,8));
		
		mostrarLista(lista);
		burbuja(lista);
		System.out.println("\n");
		mostrarLista(lista);
	}
	
	private static <T extends Comparable<T>> void mostrarLista(List<T> lista) {
		for(int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		demo();
	}
}
