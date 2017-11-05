package Ejecicio;

public class Ejercicio3_1_a {

	static int nodes;
	public static int sedes(int[] c0, int[] c1, int f) {
		int[] solActual = new int[c0.length];
		int[] solOptima = new int[c0.length];
		//int fin = buscar2(c0, c1, f, 0, solActual, 0, solOptima,Integer.MAX_VALUE);
		int coste[][]={c0, c1};  
	    int cOpt = buscar (coste, 0, f, solActual, 0, solOptima, Integer.MAX_VALUE);
		
	    return cOpt;
	}
	
	//int[] solActual, int valorActual, int[] solOptima, int valorOptimo
	

	private static int buscar (int[][] coste,int etapa, int f,int[] solParc, int cParc, int[] solOpt, int cOpt) {
		// versión basada en el esquema de la técnica de vuelta atrás para solución óptima   
			   	   for (int j=0; j<coste.length; j++)
			   	   {
			   		nodes++;
			   		   solParc[etapa] = j;
		   			   int gasto= coste[j][etapa];
		   			  
		   			   if(etapa > 0 && solParc[etapa-1]!=j) //Setapa hay traslado
			   			   gasto += f;
		   			   
		   			   cParc += gasto;
		   			   
			   		   if (etapa==solOpt.length-1) {
			   			   System.out.println("hola"+cParc);
			   			   if (cParc<cOpt) {
			   				   cOpt = cParc;
			   			   }
			   		   }
			   		   else 
			   			   cOpt = buscar (coste, etapa+1, f, solParc, cParc, solOpt, cOpt);
			   		   //restaurar valorActual
			   		   cParc -= gasto;  
	  		   	   }
			   	   return cOpt;
	   }

	// vuelta atras
	private static int buscar2(int[] c0, int[] c1, int f, int etapa,
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
				valorOptimo = buscar2(c0, c1, f, etapa + 1, solActual,valorActual, solOptima, valorOptimo);
			// restaurar valorActual en función del coste
			valorActual -= coste(c0, c1, f, solActual, etapa);
		}
		return valorOptimo;
	}
	
		   

	/*
	 * Método extra añade costes cuando sea necesario
	 */
	private static int coste(int[] c0, int[] c1, int f, int[] solActual, int etapa) {
		int coste = 0;
		if (solActual[etapa] == 0) {
			coste = c0[etapa];
			/*
			 * suma cambio de sede
			 */
			if ((etapa != 0) && (solActual[etapa] != solActual[etapa - 1])) {
				coste += f;
			}
			/*
			 * asignanar a coste el valor correspondiente
			 */
		} else {
			coste = c1[etapa];
			/*
			 * Ver setapa es necesario sumar cambio de sede
			 */
			if ((etapa != 0) && (solActual[etapa] != solActual[etapa - 1])) {
				coste += f;
			}
		}
		return coste;

	}
	
	
	

	private static void imprimir(int[] c0, int[] c1, int f) {
		int[] solActualial = new int[c0.length];
		int[] solOptima = new int[c0.length];
		int fin = buscar2(c0, c1, f, 0, solActualial, 0, solOptima,Integer.MAX_VALUE);
		for (int etapa = 0; etapa < solOptima.length; etapa++) {
			System.out.print(solOptima[etapa] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		//int c0[] = { 9, 3, 7, 30 };
		//int c1[] = { 2, 20, 2, 3 };
		int f = 10;
		imprimir(c0, c1, f);
		System.out.println(sedes(c0, c1, f));

	}

}
