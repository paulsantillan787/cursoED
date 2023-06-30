package cursoED.semana6;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Desarrollar todos los metodos con el comentrio de "// TODO Auto-generated
 * method stub" son 8 en total
 */

public class ArrayDeque<E> implements Deque<E> {
	private E[] elements;
	private final int NUM_ELEMENT_INICIAL;
	private static final int DEFAULT_NUM_ELEMENT_INICIAL = 10;
	private static final int AUTO_INCREMENT_SIZE = 5;
	private int NUM_ELEMENT_AVAILABLE;
	private int head;
	private int tail;

	public ArrayDeque() {
		this(DEFAULT_NUM_ELEMENT_INICIAL);
	}

	public ArrayDeque(int numElements) {
		NUM_ELEMENT_INICIAL = numElements;
		NUM_ELEMENT_AVAILABLE = numElements;
		elements = (E[]) new Object[NUM_ELEMENT_INICIAL + 1];
		head = 0;
		tail = 0;
	}

	@Override
	public void addFirst(E e) {
		if (e == null)
			throw new NullPointerException();
		if ((tail + 1) % NUM_ELEMENT_AVAILABLE == head) {
			incrementar();
		}
		tail++;
		for (int i = tail; i > head; i--) {
			elements[i] = elements[i - 1];
		}
		elements[head] = e;
	}

	@Override
	public void addLast(E e) {
		if (e == null)
			throw new NullPointerException();
		if ((tail + 1) % NUM_ELEMENT_AVAILABLE == head) {
			incrementar();
		}
		elements[tail++] = e;
	}

	@Override
	public E removeFirst() {
		E e = pollFirst();
		if (e == null)
			throw new NoSuchElementException();
		return e;
	}

	@Override
	public E removeLast() {
		E e = pollLast();
		if (e == null)
			throw new NoSuchElementException();
		return e;
	}

	@Override
	public E getFirst() {
		E e = peekFirst();
		if (e == null)
			throw new NoSuchElementException();
		return e;
	}

	@Override
	public E getLast() {
		E e = peekLast();
		if (e == null)
			throw new NoSuchElementException();
		return e;
	}

	@Override
	public boolean offerFirst(E e) {
		addFirst(e);
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		addLast(e);
		return true;
	}

	@Override
	public E pollFirst() {
		E polleado = null;
		if (!isEmpty())
			polleado = elements[head++];
		return polleado;

	}

	@Override
	public E pollLast() {
		E polleado = null;
		if (!isEmpty()) {
			polleado = elements[--tail];
		}
		return polleado;
	}

	@Override
	public E peekFirst() {
		if (!isEmpty()) {
			return elements[head];
		}
		return null;
	}

	@Override
	public E peekLast() {
		if (!isEmpty()) {
			return elements[tail - 1];
		}
		return null;
	}

	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E element() {
		return getFirst();
	}

	//
	@Override
	public boolean offer(E e) {
		return offerLast(e);
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public void push(E e) {
		addFirst(e);
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public boolean isEmpty() {
		return tail == head;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		if (!isEmpty()) {
			for (int i = head; i < tail; i++) {
				if (i == head) {
					cadena.append(elements[i]);
				} else {
					cadena.append(", ");
					cadena.append(elements[i]);
				}
			}
		}
		cadena.append("]");
		return cadena.toString();
	}

	public void incrementar() {
		NUM_ELEMENT_AVAILABLE += AUTO_INCREMENT_SIZE;
		elements = Arrays.copyOf(elements, NUM_ELEMENT_AVAILABLE);
		// El metodo copyOf del paquete Arrays devuelve una copia del
		// vector y le aumenta el tamaño que coloques como parametro.
	}

}