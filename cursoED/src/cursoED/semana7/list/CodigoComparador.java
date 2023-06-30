package cursoED.semana7.list;

import java.util.Comparator;

class CodigoComparador implements Comparator<Estudiante> {
	@Override
	public int compare(Estudiante e1, Estudiante e2) {
		return e1.getCodigo().compareTo(e2.getCodigo());
	}
}
