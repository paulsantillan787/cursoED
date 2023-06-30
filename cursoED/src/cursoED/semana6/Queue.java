package cursoED.semana6;

public interface Queue<E> {
	boolean offer(E e); // add, agregar, encolar, insertar

	E poll(); // remove, eliminar, quitar

	E peek(); // element

	boolean isEmpty();
}
