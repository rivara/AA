package Ejecicio;

public class Ejercicio3_1_a {

	public static int sedes(int[] c0, int[] c1, int f) {
		int[] solActual = new int[c0.length];
		int[] solOptima = new int[c0.length];
		int fin = buscar(c0, c1, f, 0, solActual, 0, solOptima,Integer.MAX_VALUE);
		return fin;
	}

	// vuelta atras
	private static int buscar(int[] c0, int[] c1, int f, int etapa,
			int[] solActual, int valorActual, int[] solOptima, int valorOptimo) {
		// Se recorren las dos sedes
		for (int j = 0; j < 2; j++) {
			solActual[etapa] = j;
			valorActual += coste(c0, c1, f, solActual, etapa);
			/*
			 * incluirlo en solActual y actualizar valorActual
			 */
			if (etapa == c0.length - 1) {
				if (valorActual <= valorOptimo) {
					valorOptimo = valorActual;
					for (int k = 0; k < solActual.length; k++)
						solOptima[k] = solActual[k];
				}
			}
			/*
			 * seguimos bajando niveles de forma recursiva
			 */
			else
				valorOptimo = buscar(c0, c1, f, etapa + 1, solActual,valorActual, solOptima, valorOptimo);
			// restaurar valorActual en función del coste
			valorActual -= coste(c0, c1, f, solActual, etapa);
		}
		return valorOptimo;
	}

	/*
	 * Método extra añade costes cuando sea necesario
	 */
	private static int coste(int[] c0, int[] c1, int f, int[] solActual, int i) {
		int coste = 0;
		if (solActual[i] == 0) {
			coste = c0[i];
			/*
			 * suma cambio de sede
			 */
			if ((i != 0) && (solActual[i] != solActual[i - 1])) {
				coste += f;
			}
			/*
			 * asignanar a coste el valor correspondiente
			 */
		} else {
			coste = c1[i];
			/*
			 * Ver si es necesario sumar cambio de sede
			 */
			if ((i != 0) && (solActual[i] != solActual[i - 1])) {
				coste += f;
			}
		}
		return coste;

	}
	
	
	 private static int buscar1Nueva (int[][] coste,int i, int f,int[] solParc, int cParc, int[] solOpt, int cOpt) {
			// versión basada en el esquema de la técnica de vuelta atrás para solución óptima   
				   	   for (int j=0; j<coste.length; j++)
				   	   {
				   		   //nodos++;
				   		   solParc[i] = j;
			   			   int gasto= coste[j][i];
			   			   if(i > 0 && solParc[i-1]!=j) //Si hay traslado
				   			   gasto += f;
			   			   
			   			   cParc += gasto;
			   			   
				   		   if (i==solOpt.length-1) {
				   			   if (cParc<cOpt) {
				   				   cOpt = cParc;
				   				   for (int k=0; k<solParc.length; k++)
										solOpt[k] = solParc[k];
				   			   }
				   		   }
				   		   else 
				   			   cOpt = buscar1Nueva (coste, i+1, f, solParc, cParc, solOpt, cOpt);
				   		   
				   		   cParc -= gasto;  
		  		   	   }
				   	   return cOpt;
		   }
			   

	private static void imprimir(int[] c0, int[] c1, int f) {
		int[] solActualial = new int[c0.length];
		int[] solOptima = new int[c0.length];
		int fin = buscar(c0, c1, f, 0, solActualial, 0, solOptima,Integer.MAX_VALUE);
		for (int i = 0; i < solOptima.length; i++) {
			System.out.print(solOptima[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;
		imprimir(c0, c1, f);
		System.out.println(sedes(c0, c1, f));

	}

}
