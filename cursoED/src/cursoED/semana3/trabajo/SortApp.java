package cursoED.semana3.trabajo;

import java.util.Arrays;
import java.util.Scanner;

import cursoED.semana3.OrdenacionPorInsercion;
import cursoED.semana3.OrdenacionPorIntercambio;
import cursoED.semana3.OrdenarPorSeleccion;
import cursoED.semana3.OrdenacionRapida;

public class SortApp {

	private static int[] data;

	public static void main(String[] args) {
		String opcion = "";
		String[] menu = { "1.-Generar datos", "2.-Ordenar Por Insercion", "3.-Ordenar por Intercambio",
				"4.-Ordenar por Seleccion", "5.-Quicksort", "q.-Salir" };
		do {
			mostrarMenu(menu);
			opcion = leerOpcion("Ingrese una opcion: ");
			procesar(opcion);
		} while (!opcion.equals("q"));

	}

	private static void procesar(String opcion) {
		switch (opcion) {
		case "1":
			data = generarData();
			mostrarArray(data);
			break;
		case "2":
		case "3":
		case "4":
		case "5":
			ordenar(data, opcion);
			break;
		case "q":
			break;
		default:
			System.out.println("Opcion ingresada no es correcta");
			break;
		}

	}

	private static void ordenar(int[] data, String opcion) {
		int[] input = Arrays.copyOf(data, data.length);
		long instante1 = System.nanoTime(); //Toma el tiempo actual (inicial, instante1)
		switch (opcion) {
		case "2":
			OrdenacionPorInsercion.ordenarPorInsercion(input);
			break;
		case "3":
			OrdenacionPorIntercambio.ordenarPorIntercambio(input);
			break;
		case "4":
			OrdenarPorSeleccion.ordenarPorSeleccion(input);
			break;
		case "5":
			OrdenacionRapida.quickSort(input);
			break;
		}
		long instante2 = System.nanoTime(); //Toma el tiempo actual (final, instante2)
		long transcurrido = instante2 - instante1; //Calcula el tiempo transcurrido (instante2-instance1)
		System.out.printf("El instante 1 fue de: %d nanosegundos || %.6f milisegundos || %.6f segundos%n",instante1,instante1/(Math.pow(10, 6)),instante1/(Math.pow(10, 9)));
		System.out.printf("El instante 2 fue de: %d nanosegundos || %.6f milisegundos || %.6f segundos%n",instante2,instante2/(Math.pow(10, 6)),instante2/(Math.pow(10, 9)));
		System.out.printf("El tiempo transcurrido fue de: %d nanosegundos || %.6f milisegundos || %.6f segundos%n%n",transcurrido,transcurrido/(Math.pow(10, 6)),transcurrido/(Math.pow(10, 9)));
		//NOTA: Profesor, por alguna razón el instante1 y el instante2 me salen cifras muy altas.
		//      no se cual pueda ser el problema.
		mostrarArray(input);
	}

	private static void mostrarArray(int[] input) {
		for (int elem : input) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	private static int[] generarData() {
		System.out.println("Ingrese la cantidad de data a generar:");
		Scanner scan = new Scanner(System.in);
		int cantidad = scan.nextInt();
		int[] data = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			data[i] = (int) (Math.random() * cantidad);
		}
		return data;
	}

	private static String leerOpcion(String prompt) {
		System.out.print(prompt);
		Scanner scan = new Scanner(System.in);
		String opcion = scan.next();
		return opcion;
	}

	private static void mostrarMenu(String[] menu) {
		for (String m : menu) {
			System.out.println(m);
		}
	}

}
