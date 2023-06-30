package cursoED.semana3;

public class OrdenacionPorIntercambio {
	
	public static void ordenarPorIntercambio(int[] a) {
		int n = a.length;
		int comparaciones = 0;
		int intercambios = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				comparaciones++;
				if (a[i] > a[j]) {
					intercambiar(a, i, j);
					intercambios++;
				}
			}
		}
		System.out.printf("n=%d, comparaciones=%d, intercambios=%d.%n", n, comparaciones, intercambios);
	}

	private static void intercambiar(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	private static void demo() {
		int[] a = { 8, 4, 6, 2 };
//		int[] a = { 8, 6, 4, 2 };
//		int[] a = { 2, 4, 6, 8 };
		ordenarPorIntercambio(a);
		imprimir(a);
	}

	private static void imprimir(int[] a) {
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		demo();

	}
}
