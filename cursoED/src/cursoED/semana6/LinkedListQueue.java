package cursoED.semana6;

import cursoED.semana4.*;

public class LinkedListQueue<E> implements Queue<E> {
	private Lista<E> elements;

	public LinkedListQueue() {
		elements = new ListaEnlazadaSimple<>();
	}

	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		elements.agregar(e);
		return true;
	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			return (E) elements.remover(0);
		}
		return null;
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			return (E) elements.get(0);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return elements.esVacio();
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < elements.tamanyo(); i++) {
			if (i == 0) {
				cadena.append(elements.get(i));
			} else {
				cadena.append(", ");
				cadena.append(elements.get(i));
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
}
