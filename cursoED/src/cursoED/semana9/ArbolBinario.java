package cursoED.semana9;

public class ArbolBinario<T> {
	protected Nodo<T> raiz;

	public ArbolBinario(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public ArbolBinario() {
		this(null);
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	boolean esVacio() {
		return raiz == null;
	}

	public static <T> void preorden(Nodo<T> r) {
		if (r != null) {
			procesar(r);
			preorden(r.getIzdo());
			preorden(r.getDcho());
		}
	}

	private static <T> void procesar(Nodo<T> n) {
		System.out.print(n.getDato() + " ");
	}

	public void preorden() {
		preorden(this.getRaiz());
	}
	
	public static <T> void procesarPreOrden(Nodo<T> r, StringBuilder cadena) {
		if(r != null) {
			cadena.append(r.getDato() + " ");
			procesarPreOrden(r.getIzdo(), cadena);
			procesarPreOrden(r.getDcho(), cadena);
		}
	}
	
	public String preordenSTR() {
		StringBuilder cadena = new StringBuilder();
		procesarPreOrden(getRaiz(),cadena);
		return cadena.toString();	
	}
	
	public static <T> void inorden(Nodo<T> r) {
		if (r != null) {
			inorden(r.getIzdo());
			procesar(r);
			inorden(r.getDcho());
		}
	}

	public void inorden() {
		inorden(this.getRaiz());
	}
	
	public static <T> void procesarInOrden(Nodo<T> r, StringBuilder cadena) {
		if(r != null) {
			procesarInOrden(r.getIzdo(), cadena);
			cadena.append(r.getDato()+" ");
			procesarInOrden(r.getDcho(), cadena);
		}
	}
	
	public String inordenSTR() {
		StringBuilder cadena = new StringBuilder();
		procesarInOrden(getRaiz(),cadena);
		return cadena.toString();	
	}
	
	public static <T> void postorden(Nodo<T> r) {
		if (r != null) {
			postorden(r.getIzdo());
			postorden(r.getDcho());
			procesar(r);
		}
	}

	public void postorden() {
		postorden(this.getRaiz());
	}
	
	public static <T> void procesarPostOrden(Nodo<T> r, StringBuilder cadena) {
		if(r != null) {
			procesarPostOrden(r.getIzdo(), cadena);
			procesarPostOrden(r.getDcho(), cadena);
			cadena.append(r.getDato() + " ");
		}
	}
	
	public String postordenSTR() {
		StringBuilder cadena = new StringBuilder();
		procesarPostOrden(getRaiz(),cadena);
		return cadena.toString();	
	}
	
	public static void main(String[] args) {
		Nodo<String> izdo, dcho, centro1, centro2, centro3;
		ArbolBinario<String> arbol;
		izdo = new Nodo<>(null, "Maria",null);
		dcho = new Nodo<>(null,"Rodrigo",null);
		centro1 = new Nodo<>(izdo, "Esperanza", dcho);
		izdo = new Nodo<>(null,"Anyora",null);
		dcho = new Nodo<>(null,"Abel",null);
		centro2 = new Nodo<>(izdo,"M Jesus",dcho);
		centro3 = new Nodo<>(centro1, "Esperanza", centro2);
		arbol = new ArbolBinario<>(centro3);
		System.out.print("Pre-orden:   ");
		arbol.preorden();
		System.out.println();
		System.out.print("En-orden:     ");
		arbol.inorden();
		System.out.println();
		System.out.print("Post-orden:   ");
		arbol.postorden();
		System.out.println();
	}
}
