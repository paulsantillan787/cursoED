package cursoED.semana2;

import java.util.Scanner;

public class FactorialSimple {
	public static long factorial(int n) {
		long result = 1;
		if(n>20)
			throw new RuntimeException("No soportado");
		for(int i=1; i<=n; i++)
			result *= i;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n = scanner.nextInt();
		long result = factorial(n);
		System.out.println("El factorial es " + result);
		scanner.close();
	}
}