package Ejecicio;
public class Ejercicio3_1_a {

	static int nodes;

	public static int sedes_VA(int[] c0, int[] c1, int f) {
		int[] solActual = new int[c0.length];
		int[] solOptimaima = new int[c0.length];
		int cost[][] = { c0, c1 };
		int cOptimaima = buscar(cost, 0, f, solActual, 0, solOptimaima, Integer.MAX_VALUE);
		imprimir(solOptimaima);
		return cOptimaima;
	}

	private static int buscar(int[][] coste, int etapa, int f, int[] solActual, int cParcial, int[] solOptima,int cOptima) {
		// versión basada en el esquema de la técnica de vuelta atrás para solución optima
		for (int j = 0; j < coste.length; j++) {
			nodes++;
			solActual[etapa] = j;
			int gasto = coste[j][etapa];

			if (etapa > 0 && solActual[etapa - 1] != j) // Setapa hay traslado
				gasto += f;

			cParcial += gasto;

			if (etapa == solOptima.length - 1) {

				if (cParcial < cOptima) {
					cOptima = cParcial;
					// aqui actualizo el array de la solucion optima
					for (int k = 0; k < solActual.length; k++)
						solOptima[k] = solActual[k];
				}

			} else

			cOptima = buscar(coste, etapa + 1, f, solActual, cParcial, solOptima, cOptima);
			//System.out.println("opcion:" + j + " etapa:" + etapa + " coste:" + cParcial);
			// restaurar valorActual
			cParcial -= gasto;
		}
		return cOptima;
	}

	private static void imprimir(int[] v) {
		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;
		System.out.println(sedes_VA(c0, c1, f));
		System.out.println("numero de nodos creados: " + nodes);
	}

}
