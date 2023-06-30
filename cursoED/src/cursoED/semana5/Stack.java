package cursoED.semana5;

public interface Stack<E> {
	void push(E e);  // Apilar, insertar
	E pop();         //desapilar, quitar
	E peek();        //cima
	boolean empty(); //Vacio
	String toString();
}
