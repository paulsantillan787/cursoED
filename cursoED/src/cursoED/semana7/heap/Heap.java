package cursoED.semana7.heap;

import java.util.Comparator;

public class Heap<E> {
	static final int TAMINI = 10;
	private int numElem;
	private E[] v;
	private final Comparator<? super E> comparator;

	public Heap() {
		numElem = 0;
		v = (E[]) new Object[TAMINI];
		this.comparator = null;
	}
	
	public Heap(Comparator<? super E> comparator) {
		numElem = 0;
		v = (E[]) new Object[TAMINI];
		this.comparator = comparator;
	}

	public static int parent(int i) {
		return (i - 1) / 2;
	}

	public static int leftChild(int i) {
		return (2 * i + 1);
	}

	public static int rightChild(int i) {
		return (2 * i + 1) + 1;
	}

	private boolean isFull() {
		return (numElem == v.length);
	}

	public boolean isEmpty() {
		return (numElem == 0);
	}

	private void ampliar() {
		E[] oldV = v;
		v = (E[]) new Object[numElem + TAMINI];
		for (int j = 0; j < numElem; j++)
			v[j] = oldV[j];
	}

	private void flotarUsingComparable(int i) {
		E nuevaClave = v[i];
		Comparable<? super E> key = (Comparable<? super E>) v[parent(i)];
		while ((i > 0) && (key.compareTo(nuevaClave) > 0)) {
			v[i] = v[parent(i)]; // baja el padre al hueco
			i = parent(i); // sube un nivel en el arbol
			key = (Comparable<? super E>) v[parent(i)];
		}
		v[i] = nuevaClave; // situa la clave en su posicion
	}
	
	public void flotarUsingComparator(int i) {
		E nuevaClave = v[i];
		E key = v[parent(i)];
		while ((i > 0) && (comparator.compare(key,nuevaClave) > 0)) {
			v[i] = v[parent(i)]; // baja el padre al hueco
			i = parent(i); // sube un nivel en el arbol
			key = v[parent(i)];
		}
		v[i] = nuevaClave; // situa la clave en su posicion
	}

	public void insert(E e) {
		if (isFull()) {
			ampliar();
		}
		v[numElem] = e;
		if(comparator == null)
			flotarUsingComparable(numElem);
		else
			flotarUsingComparator(numElem);
		numElem++;
	}

	public E element() {
		if (isEmpty())
			throw new RuntimeException("Acceso a montículo vacío");
		return v[0];
	}

	public void cribaUsingComparable(int raiz) {
		boolean esMonticulo;
		int hijo;
		esMonticulo = false;
		while ((raiz < numElem / 2) && !esMonticulo) {
			// determina el indice del hijo menor
			if (leftChild(raiz) == (numElem - 1)) // unico descendiente
				hijo = leftChild(raiz);
			else {
				Comparable<? super E> key = (Comparable<? super E>) v[leftChild(raiz)];
				if (key.compareTo(v[rightChild(raiz)]) < 0)
					hijo = leftChild(raiz);
				else
					hijo = rightChild(raiz);
			}
			// compara raiz con el menor de los hijos
			Comparable<? super E> key = (Comparable<? super E>) v[hijo];
			if (key.compareTo(v[raiz]) < 0) {
				E t = v[raiz];
				v[raiz] = v[hijo];
				v[hijo] = t;
				raiz = hijo; /* continua por la rama de claves m�nimas */
			} else
				esMonticulo = true;
		}
	}
	
	public void cribaUsingComparator(int raiz) {
		boolean esMonticulo;
		int hijo;
		esMonticulo = false;
		while ((raiz < numElem / 2) && !esMonticulo) {
			// determina el indice del hijo menor
			if (leftChild(raiz) == (numElem - 1)) // unico descendiente
				hijo = leftChild(raiz);
			else {
				E key = v[leftChild(raiz)];
				if (comparator.compare(key,v[rightChild(raiz)]) < 0)
					hijo = leftChild(raiz);
				else
					hijo = rightChild(raiz);
			}
			// compara raiz con el menor de los hijos
			E key = v[hijo];
			if (comparator.compare(key,v[raiz]) < 0) {
				E t = v[raiz];
				v[raiz] = v[hijo];
				v[hijo] = t;
				raiz = hijo; /* continua por la rama de claves m�nimas */
			} else
				esMonticulo = true;
		}
	}

	public E remove() {
		if (isEmpty())
			throw new RuntimeException("Acceso a mont�culo vac�o");
		E menor;
		menor = v[0];
		v[0] = v[numElem - 1];
		if(comparator == null)
			cribaUsingComparable(0);
		else
			cribaUsingComparator(0);
		numElem--;
		return menor;
	}

	@Override
	public String toString() {
		String result = "[";
		int i = 0;
		for (i = 0; i < numElem - 1; i++) {
			result += v[i] + ", ";
		}
		if (i == numElem - 1)
			result += v[i];
		result += "]";
		return result;
	}
}
