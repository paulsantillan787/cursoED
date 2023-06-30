package cursoED.semana3;

public class BusquedaSecuencial {
	public static int buscaSecuencial(int[] a, int clave) {
		for(int i = 0;i < a.length;i++) {
			if(clave == a[i])
				return i; // Si lo encontro
		}
		return -1;    //No se encontro
	}
	
	public static void demo() {
		int[] a = { 6, 2, 1, 4, 3, 5 };
		int n = 100;
		int aux = buscaSecuencial(a, n);
		if(aux == -1)
			System.out.println("No encontrado");
		else
			System.out.println("Número: " + n + " Lugar: " + aux);
	}
	
	public static void main(String[] args) {
		demo();
	}
}
