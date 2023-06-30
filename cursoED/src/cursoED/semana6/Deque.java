package cursoED.semana6;

public interface Deque<E> extends Queue<E> {
	void addFirst(E e);

	void addLast(E e);

	E removeFirst(); // pollFirst

	E removeLast(); // pollLast

	E getFirst(); // peekFirst

	E getLast(); // peekLast

	boolean offerFirst(E e);// addFirst(e)

	boolean offerLast(E e); // addLast(e)

	E pollFirst();

	E pollLast();

	E peekFirst();

	E peekLast();

	boolean add(E e); // addLast

	E remove(); // removeFirst

	E element(); // getFirst

	boolean offer(E e); // offerLast

	E poll(); // pollFirst

	E peek(); // peekFirst

	void push(E e); // addFirst

	E pop(); // removeFirst

	boolean isEmpty();
}