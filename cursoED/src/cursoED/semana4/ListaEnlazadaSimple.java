package cursoED.semana4;


public class ListaEnlazadaSimple<E> implements Lista<E> {
	private int tamanyo = 0;
	private Nodo<E> primero;
	private Nodo<E> ultimo;

	private class Nodo<E> {
		E item;
		Nodo<E> sgte;

		Nodo(E element, Nodo<E> sgte) {
			this.item = element;
			this.sgte = sgte;
		}
	}

	@Override
	public int tamanyo() {
		return tamanyo;
	}

	@Override
	public boolean esVacio() {
		return tamanyo == 0;
	}

	@Override
	public boolean contiene(Object o) {
		return indiceDe(o) >= 0;
	}

	@Override
	public void agregar(E e) {
		final Nodo<E> u = ultimo;
		final Nodo<E> nuevoNodo = new Nodo<>(e, null);
		ultimo = nuevoNodo;
		if (u == null)
			primero = nuevoNodo;
		else
			u.sgte = nuevoNodo;
		tamanyo++;
	}

	@Override
	public void agregar(int index, E element) {
		validarAgregarIndice(index);
		if (index == tamanyo)
			agregar(element);
		else if (index == 0)
			linkearPrimero(element);
		else
			linkearMedio(element, index);
	}

	public void linkearPrimero(E element) {
		Nodo<E> nuevo = new Nodo<>(element, primero);
		primero = nuevo;
		tamanyo++;
	}

	public void linkearMedio(E element, int index) {
		Nodo<E> x = primero;
		Nodo<E> previo = null;
		for (int i = 0; i < index; i++) {
			previo = x;
			x = x.sgte;
		}
		final Nodo<E> nuevo = new Nodo<>(element, x);
		previo.sgte = nuevo;
		tamanyo++;
	}

	private void validarAgregarIndice(int index) {
		if (!(index >= 0 && index <= tamanyo))
			throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);
	}

	@Override
	public boolean remover(Object o) {
		Nodo<E> previo = null;
		if (o == null) {
			for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
				if (x.item == null) {
					desligar(previo, x);
					return true;
				}
			}
		} else {
			for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
				if (o.equals(x.item)) {
					desligar(previo, x);
					return true;
				}
			}
		}
		return false;
	}

	private E desligar(Nodo<E> previo, Nodo<E> x) {
		E desligado = x.item;
		if(x.sgte==null)
			ultimo = previo;
		if(previo!=null)
			previo.sgte=x.sgte;
		else
			primero = primero.sgte;
		tamanyo--;
		return desligado;
	}

	@Override
	public E remover(int index) {
		validarElementoIndice(index);
		Nodo<E> x = primero;
		Nodo<E> previo = null;
		for (int i = 0; i < index; i++) {
			previo = x;
			x = x.sgte;
		}
		return desligar(previo, x);
	}

	@Override
	public void limpiar() {
		for (Nodo<E> x = primero; x != null;) {
			Nodo<E> sgte = x.sgte;
			x.item = null;
			x.sgte = null;
			x = sgte;
		}
		primero = ultimo = null;
		tamanyo = 0;
	}

	@Override
	public E get(int index) {
		validarElementoIndice(index);
		return nodo(index).item;
	}

	private void validarElementoIndice(int index) {
		if (!(index >= 0 && index < tamanyo))
			throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);
	}

	private Nodo<E> nodo(int index) {
		Nodo<E> u = primero;
		for (int i = 0; i < index; i++) {
			u = u.sgte;
		}
		return u;
	}

	@Override
	public E set(int index, E element) {
		validarElementoIndice(index);
		Nodo<E> x = nodo(index);
		E oldVal = x.item;
		x.item = element;
		return oldVal;
	}

	@Override
	public int indiceDe(Object o) {
		int index = 0;
		if (o == null) {
			for (Nodo<E> x = primero; x != null; x = x.sgte) {
				if (x.item == null)
					return index;
				index++;
			}
		} else {
			for (Nodo<E> x = primero; x != null; x = x.sgte) {
				if (o.equals(x.item))
					return index;
				index++;
			}
		}
		return -1;
	}
	
	@Override
	public Object[] toArray() {
		Nodo<E> u;
		Object[] vector = new Object[tamanyo];
		for (int i = 0; i < tamanyo; i++) {
			u = nodo(i);
			vector[i] = u.item;
		}
		return vector;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("Lista(");
		for (int i = 0; i < tamanyo; i++) {
			if (i == 0) {
				cadena.append(get(i));
			} else {
				cadena.append(", ");
				cadena.append(get(i));
			}
		}
		cadena.append(")");
		return cadena.toString();
	}
}
