package cursoED.semana3.trabajo;

public class OrdenacionBurbuja {

	public static void burbuja(int[] a) {
		int n = a.length;
		boolean interruptor = true;
		for(int i = 0; i<n-1 && interruptor;i++) {
			interruptor = false;
			for(int j = 0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					interruptor = true;
					intercambiar(a,j,j+1);
				}
			}
		}
	}
	
	private static void intercambiar(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}


	private static void demo(){
		int[] a = { 5, 3, 2, 1, 9, 6, 8 };
		burbuja(a);
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
