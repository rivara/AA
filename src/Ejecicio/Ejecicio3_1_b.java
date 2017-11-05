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
			solParc[etapa] = j;
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
				cParcial -= coste(c0, c1, f, solParc, etapa);
			} else {
				System.out.print("Poda con cota: " + nCota + ". Estado: ");
				imprimir2(solParc, etapa);
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

	private static int coste(int[] c0, int[] c1, int f, int[] solParcial, int etapa) {
		/* Setapa estamos en la sede 0, asignamos a coste el valor correspondiente */
		int coste = 0;
		if (solParcial[etapa] == 0) {
			coste = c0[etapa];
			/*
			 * Controlar setapa es necesario sumar cambio de sede, comparando setapa la
			 * sede actual es igual a la anterior o setapa estamos en el primer
			 * nivel
			 */
			if ((etapa != 0) && (solParcial[etapa] != solParcial[etapa - 1])) {
				coste += f;
			}
			/*
			 * Setapa estamos en la sede 1, asignamos a coste el valor
			 * correspondiente
			 */
		} else {
			coste = c1[etapa];
			/*
			 * Controlar setapa es necesario sumar cambio de sede, comparando setapa la
			 * sede actual es igual a la anterior o setapa estamos en el primer
			 * nivel
			 */
			if ((etapa != 0) && (solParcial[etapa] != solParcial[etapa - 1])) {
				coste += f;
			}
		}
		return coste;
	}

	private static void imprimir(int[] v) {
		for (int etapa = 0; etapa < v.length; etapa++)
			System.out.print(v[etapa] + " ");
		System.out.println();
	}

	private static void imprimir2(int[] v, int k) {
		for (int etapa = 0; etapa <= k; etapa++)
			System.out.print(v[etapa] + " ");
		for (int etapa = k + 1; etapa < v.length; etapa++)
			System.out.print("- ");
		System.out.println();
	}
	
	
	
	
	 private static int buscar2_Nueva (int[][] coste, int i, int f, int[] solParc, int cParc, int[] solOpt, int cOpt, int cota) 
	   {
		   		// versión de ramificación y poda, tomando como cota inferior el coste mínimo de costes de sedes sin traslado
		   			
		   		for (int j=0; j<coste.length; j++)
		   			{
		   				solParc[i] = j;
		   				
		   				int nCota = calcularCota_Nueva (coste, solParc, i);
		   				
		   				if (nCota < cOpt) 
		   				{
		   					//nodos++;
		   					
		   					int gasto=coste[j][i];
		   					
		   					if(i > 0 && solParc[i-1]!=j) //Si hay traslado
		 		   			   gasto += f;
		   					
		   					cParc += gasto;
		   					
		   					if (i==solOpt.length-1) 
		   					{
		   						if (cParc<cOpt) 
		   						{
		   							cOpt = cParc;
		   							for (int k=0; k<solParc.length; k++)
		   								solOpt[k] = solParc[k];
		   							System.out.print ("Nuevo coste mínimo: "+cOpt+". Estado: ");
		   							imprimir (solOpt);
		   						}
		   					}
		   					else 
		   						cOpt = buscar2_Nueva (coste, i+1, f, solParc, cParc, solOpt, cOpt, cota);
		   					
		   					cParc -= gasto;
		   				}
		   			}
		   		return cOpt;
	   }
	   
	   private static int calcularCota_Nueva (int[][] coste, int[] solParcial, int i) {
		      int cota = 0;
		      for (int j=0; j<=i; j++)
		         cota += coste[solParcial[j]][j];
		      for (int j=i+1; j<solParcial.length; j++)
		         cota += minimoNuevo (coste,j);
		      return cota;
	   }
	   
	   private static int minimoNuevo (int[][] coste,int j) {
		      int min = Integer.MAX_VALUE;
		      
		      for (int i=0; i<coste.length; i++)
		         if (coste[i][j]<min)
		            min = coste[i][j];
		      return min;
	   }

	public static void main(String[] args) {
		
		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;

		System.out.println(sedes_RyP(c0, c1, f));
	}
}
