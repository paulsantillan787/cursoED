package cursoED.semana5;

public class ArrayStack<E> implements Stack<E> {
	private static final int DEFAULT_MAX_SIZE = 10000;
	private final int MAX_SIZE;
	private int head;
	private Object[] data;

	public ArrayStack(final int maxSize) {
		MAX_SIZE = maxSize;
		head = -1;
		data = new Object[MAX_SIZE];
	}

	public ArrayStack() {
		this(DEFAULT_MAX_SIZE);
	}

	@Override
	public void push(E e) {
		if (head >= MAX_SIZE - 1)
			throw new RuntimeException("Desbordamiento de pila");
		head++;
		data[head] = e;

	}

	@Override
	public E pop() {
		if (empty())
			throw new RuntimeException("Pila vacia");
		E popeado = (E) data[head];
		data[head] = null;
		head--;
		return popeado;
	}

	@Override
	public E peek() {
		if (empty())
			throw new RuntimeException("Pila vacia");
		E peekeado = (E) data[head];
		return peekeado;
	}

	@Override
	public boolean empty() {
		return head == -1;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = head; i >= 0; i--) {
			if (i == head) {
				cadena.append(data[i]);
			} else {
				cadena.append(", ");
				cadena.append(data[i]);
			}
		}
		cadena.append("]");
		return cadena.toString();
	}

}
