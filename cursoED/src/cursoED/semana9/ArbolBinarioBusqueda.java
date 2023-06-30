package cursoED.semana9;

public class ArbolBinarioBusqueda<T> extends ArbolBinario<T> {
	public ArbolBinarioBusqueda(Nodo<T> raiz) {
		super(raiz);
	}

	public ArbolBinarioBusqueda() {
		super();
	}

	public Nodo<T> buscar(T dato) {
		if (getRaiz() == null)
			return null;
		else
			return localizar(getRaiz(), dato);
	}

	private Nodo<T> localizar(Nodo<T> raizSub, T dato) {
		if (raizSub == null)
			return null;
		int comparacion = ((Comparable<T>) dato).compareTo(raizSub.getDato());
		if (comparacion == 0)
			return raizSub;
		else if (comparacion < 0)
			return localizar(raizSub.getIzdo(), dato);
		else
			return localizar(raizSub.getDcho(), dato);
	}

	public static <T> void insert(Nodo<T> nuevoNodo, Nodo<T> pivote) {
		if(pivote != null) {
			int comparacion = ((Comparable<T>) nuevoNodo.getDato()).compareTo(pivote.getDato());
			if (comparacion < 0) {
				if(pivote.getIzdo() == null)
					pivote.setIzdo(nuevoNodo);
				else
					insert(nuevoNodo ,pivote.getIzdo());
			}
			else if(comparacion > 0){
				if(pivote.getDcho() == null)
					pivote.setDcho(nuevoNodo);
				else
					insert(nuevoNodo ,pivote.getDcho());
			}
		}
	}

	public boolean insert(Nodo<T> nuevoNodo) {
		if(nuevoNodo == null)
			return false;
		insert(nuevoNodo, getRaiz());
		return true;
	}
	
	public void refactor(Nodo<T> pivote) {
		if(pivote.getDcho() != null) {
			pivote = pivote.getDcho();
			pivote.setDcho(null);
			refactor(pivote.getDcho());
		}else if(pivote.getIzdo() != null) {
			refactor(pivote.getIzdo());
		}
	}
	
	
	public Nodo<T> delete(T dato){
		if(getRaiz() == null)
			return null;
		Nodo<T> deleteado = localizar(getRaiz(), dato);
		refactor(deleteado);
		return deleteado; 
	}
	
	public static void main(String[] args) {
		Nodo<Integer> izdo, dcho, centro1, centro2, centro3, nuevoNodo;
		dcho = new Nodo<>(null,15,null);
		centro1 = new Nodo<>(null, 10, dcho);
		izdo = new Nodo<>(null,30,null);
		dcho = new Nodo<>(null,64,null);
		centro2 = new Nodo<>(izdo,36,dcho);
		centro3 = new Nodo<>(centro1, 25 , centro2);
		ArbolBinarioBusqueda<Integer> abb = new ArbolBinarioBusqueda<>(centro3);
		nuevoNodo = new Nodo<>(null,8,null);
		abb.insert(nuevoNodo);
		abb.inorden();
		nuevoNodo = new Nodo<>(null,12,null);
		abb.insert(nuevoNodo);
		System.out.println();
		abb.inorden();
	}

}
