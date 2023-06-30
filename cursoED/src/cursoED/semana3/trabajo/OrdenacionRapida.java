package cursoED.semana3.trabajo;

import java.util.List;
import java.util.ArrayList;

import cursoED.semana3.*;

public class OrdenacionRapida {

	public static <T extends Comparable<T>> void quickSort(List<T> lista) {
		quickSort(lista, 0, lista.size()-1);
	}

	public static <T extends Comparable<T>> void quickSort(List<T> lista, int primero, int ultimo) {
		int i,j,central;
		central = (primero + ultimo)/2;
		T pivote = lista.get(central);	
		i = primero;
		j = ultimo;
		do {
			while(lista.get(i).compareTo(pivote)<0)
				i++;
			while(lista.get(j).compareTo(pivote)>0)
				j--;
			if(i<=j) {
				intercambiar(lista, i, j);
				i++;
				j--;
			}
		}while(i<=j);
		if(primero < j)
			quickSort(lista, primero, j);
		if(i < ultimo)
			quickSort(lista, i, ultimo);
	}
	
	private static <T extends Comparable<T>> void intercambiar(List<T> lista, int i, int j) {
		T aux = lista.get(i);
		lista.set(i, lista.get(j));
		lista.set(j, aux);
	}

	private static void demo() {
		List<Racional> lista = new ArrayList<>();
		lista.add(new Racional(2,3));
		lista.add(new Racional(1,2));
		lista.add(new Racional(1,8));
		lista.add(new Racional(4,5));
		
		mostrarLista(lista);
		quickSort(lista);
		System.out.println();
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
