package cursoED.semana2;

public class MCD {
	public static int mcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return mcd(b, a % b);
	}
}
