package cursoED.semana5;

import cursoED.semana4.*;

public class LinkedListStack<E> implements Stack<E> {
	private Lista<E> data;

	public LinkedListStack() {
		data = new ListaEnlazadaSimple<>();
	}

	@Override
	public void push(E e) {
		data.agregar(0, e);
	}

	@Override
	public E pop() {
		if (data.esVacio())
			throw new RuntimeException("Pila vacia");
		E popeado = data.remover(0);
		return popeado;

	}

	@Override
	public E peek() {
		if (data.esVacio())
			throw new RuntimeException("Pila vacia");
		E peekeado = data.get(0);
		return peekeado;
	}

	@Override
	public boolean empty() {
		return data.esVacio();
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < data.tamanyo(); i++) {
			if (i == 0) {
				cadena.append(data.get(i));
			} else {
				cadena.append(", ");
				cadena.append(data.get(i));
			}
		}
		cadena.append("]");
		return cadena.toString();
	}

}
