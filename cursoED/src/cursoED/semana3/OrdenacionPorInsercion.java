package cursoED.semana3;

public class OrdenacionPorInsercion {
	public static void ordenarPorInsercion(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int j = i;
			int aux = a[i];
			while (j > 0 && aux < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = aux;
		}
	}
	
	private static void demo() {
		int[] a = { 6, 2, 1, 4, 3, 5 };
		ordenarPorInsercion(a);
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
