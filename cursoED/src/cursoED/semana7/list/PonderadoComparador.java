package cursoED.semana7.list;

import java.util.Comparator;

class PonderadoComparador implements Comparator<Estudiante> {
	@Override
	public int compare(Estudiante e1, Estudiante e2) {
		float diferencia = e1.getPromedioPonderado() - e2.getPromedioPonderado();
		if (diferencia == 0)
			return 0;
		if (diferencia > 0)
			return 1;
		return -1;
	}
}