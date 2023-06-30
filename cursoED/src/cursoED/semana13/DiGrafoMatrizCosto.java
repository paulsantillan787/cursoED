package cursoED.semana13;

import java.util.HashMap;
import java.util.Map;

public class DiGrafoMatrizCosto<T> {
	T[] vertices;
	Map<T, Integer> verticesIndex = new HashMap<>();
	int[][] adyacencia;

	public DiGrafoMatrizCosto(T... vertices) {
		this.vertices = vertices;
		int indice = 0;
		for (T v : vertices) {
			verticesIndex.put(v, indice++);
		}
		final int tamanyo = vertices.length;
		adyacencia = new int[tamanyo][tamanyo];
	}

	public void agregarArco(int i, int j, int costo) {
		adyacencia[i][j] = costo;
	}

	public void agregarArco(T verticeDesde, T verticeHasta, int costo) {
		int i = verticesIndex.get(verticeDesde);
		int j = verticesIndex.get(verticeHasta);
		agregarArco(i, j, costo);
	}

	public boolean esAdyacente(int i, int j) {
		return adyacencia[i][j] > 0;
	}

	public boolean esAdyacente(T verticeDesde, T verticeHasta) {
		int i = verticesIndex.get(verticeDesde);
		int j = verticesIndex.get(verticeHasta);
		return esAdyacente(i, j);
	}

	public int[] getFilaAdyacencia(int filaIndex) {
		return adyacencia[filaIndex];
	}

	public int[] getFilaAdyacencia(T fila) {
		return adyacencia[verticesIndex.get(fila)];
	}

}