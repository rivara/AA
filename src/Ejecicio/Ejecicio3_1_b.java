package Ejecicio;

class Ejecicio3_1_b {


	public static int sedes_RyP(int[] c0, int[] c1, int f) {
		int[] solParcial = new int[c0.length];
		int[] solOptima = new int[c0.length];
		// Calculamos la cota
		int cota = calcCota(c0, c1, f, solParcial, 0);
		System.out.println("Cota inicial: " + cota
				+ ". Coste mínimo inicial: 0");
		int cOpt = buscarSedes_RyP(c0, c1, f, 0, solParcial, 0, solOptima,Integer.MAX_VALUE, cota);
		//(c0, c1, f, etapa + 1, solActual,valorActual, solOptima, valorOptimo);
		System.out.print("Solución óptima: ");
		imprimir(solOptima);
		System.out.println();
		return cOpt;
	}


	/*ramifica y poda*/
	private static int buscarSedes_RyP(int[] c0, int[] c1, int f, int etapa,
			int[] solParc, int cParcial, int[] solOpt, int cOpt, int cota) {
		// Se recorren las dos sedes existentes
		for (int j = 0; j < 2; j++) {
			solParc[i] = j;
			// Calculamos la cota en cada nivel
			int nCota = calcCota(c0, c1, f, solParc, etapa);
			/*
			 * Evaluamos setapa la cota es menor que el mejor candidato hasta el
			 * momento. En caso de ser mayor, no continuará la evaluación,
			 * podando la rama
			 */
			if (nCota < cOpt) {
				// Sumamos el valor correspondiente al nuevo nivel
				cParcial += coste(c0, c1, f, solParc, etapa);
				/*
				 * Comprobamos setapa hemos llegado al final de la rama, para fijar
				 * el mejor candidato
				 */
				if (etapa == c0.length - 1) {
					if (cParcial < cOpt) {
						cOpt = cParcial;
						for (int k = 0; k < solParc.length; k++)
							solOpt[k] = solParc[k];
						System.out.print("Nuevo coste mínimo: " + cOpt
								+ ". Estado: ");
						imprimir(solOpt);
					}
				}
				/*
				 * Setapa no hemos llegado al final de la rama, seguimos bajando
				 * niveles de forma recursiva
				 */
				else
					cOpt = buscarSedes_RyP(c0, c1, f, etapa + 1, solParc, cParcial,
							solOpt, cOpt, cota);
				// Restamos el valor correspondiente, para continuar con otra
				// rama
				cParcial -= coste(c0, c1, f, solParc, i);
			} else {
				System.out.print("Poda con cota: " + nCota + ". Estado: ");
				imprimir2(solParc, i);
			}
		}
		return cOpt;
	}

	/*
	 * Algoritmo que calcula la cota. Fijará el valor real consumido hasta cada
	 * nodo y, a partir de ahí, comparará el mejor valor de los hijos hasta
	 * llegar a cada nodo hoja
	 */
	public static int calcCota(int[] c0, int[] c1, int f, int[] solParcial,
			int etapa) {
		int cota = 0;
		for (int j = 0; j <= etapa; j++) {
			cota += coste(c0, c1, f, solParcial, j);
		}
		for (int j = etapa + 1; j < c0.length; j++) {
			cota += minimo(c0, c1, j);
		}
		return cota;
	}

	private static int minimo(int[] c0, int[] c1, int j) {
		int min = 0;
		if (c0[j] <= c1[j])min = c0[j];
		else
			min = c1[j];
		return min;
	}

	private static int coste(int[] c0, int[] c1, int f, int[] solParcial, int i) {
		/* Setapa estamos en la sede 0, asignamos a coste el valor correspondiente */
		int coste = 0;
		if (solParcial[i] == 0) {
			coste = c0[i];
			/*
			 * Controlar setapa es necesario sumar cambio de sede, comparando setapa la
			 * sede actual es igual a la anterior o setapa estamos en el primer
			 * nivel
			 */
			if ((etapa != 0) && (solParcial[i] != solParcial[etapa - 1])) {
				coste += f;
			}
			/*
			 * Setapa estamos en la sede 1, asignamos a coste el valor
			 * correspondiente
			 */
		} else {
			coste = c1[i];
			/*
			 * Controlar setapa es necesario sumar cambio de sede, comparando setapa la
			 * sede actual es igual a la anterior o setapa estamos en el primer
			 * nivel
			 */
			if ((etapa != 0) && (solParcial[i] != solParcial[etapa - 1])) {
				coste += f;
			}
		}
		return coste;
	}

	private static void imprimir(int[] v) {
		for (int etapa = 0; etapa < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}

	private static void imprimir2(int[] v, int k) {
		for (int etapa = 0; etapa <= k; i++)
			System.out.print(v[etapa] + " ");
		for (int etapa = k + 1; etapa < v.length; i++)
			System.out.print("- ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;

		System.out.println(sedes_RyP(c0, c1, f));
	}
}
