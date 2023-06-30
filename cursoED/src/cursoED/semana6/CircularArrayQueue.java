package cursoED.semana6;

public class CircularArrayQueue<E> implements Queue<E> {
	private static final int DEFAULT_MAX_SIZE = 100;
	private final int MAX_SIZE;
	private int head;
	private int tail;
	private Object[] elements;

	public CircularArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}

	public CircularArrayQueue(int maxSize) {
		MAX_SIZE = maxSize + 1;
		head = 0;
		tail = MAX_SIZE - 1;
		elements = new Object[MAX_SIZE];
	}

	private int nextIndex(int currentIndex) {
		return (currentIndex + 1) % MAX_SIZE;
	}

	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		if (!isFull()) {
			tail = nextIndex(tail);
			elements[tail] = e;
			return true;
		} else
			return false;

	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			E polleado = (E) elements[head];
			head = (head+1)%MAX_SIZE;
			return polleado;
		}
		return null;
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			return (E) elements[head];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == nextIndex(tail);
	}

	public boolean isFull() {
		return head == nextIndex(nextIndex(tail));
	}
	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		if(!isEmpty()) {
			for (int i = head; i <= tail; i++) {
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

}
