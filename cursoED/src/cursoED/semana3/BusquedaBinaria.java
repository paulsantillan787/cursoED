package cursoED.semana3;

public class BusquedaBinaria {
	public static int busquedaBinaria(int a[], int clave) {
		int central, bajo, alto;
		int valorCentral;
		bajo = 0;
		alto = a.length - 1;
		while (bajo <= alto) {
			central = (bajo + alto) / 2; // índice de elemento central
			valorCentral = a[central]; // valor del índice central
			if (clave == valorCentral)
				return central; // encontrado, devuelve posición
			else if (clave < valorCentral)
				alto = central - 1; // ir a sublista inferior
			else
				bajo = central + 1; // ir a sublista superior
		}
		return -1; // elemento no encontrado
	}
	
	public static void demo() {
		int[] a = { 6, 2, 1, 4, 3, 5 };
		int n = 5;
		int aux = busquedaBinaria(a, n);
		if(aux == -1)
			System.out.println("No encontrado");
		else
			System.out.println("Número: " + n + " Lugar: " + aux);
	}
	
	public static void main(String[] args) {
		demo();
	}
}
