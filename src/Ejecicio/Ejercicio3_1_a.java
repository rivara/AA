package Ejecicio;

public class Ejercicio3_1_a {

	static int nodes;
	public static int sedes(int[] c0, int[] c1, int f) {
		int[] solActual = new int[c0.length];
		int[] solOptima = new int[c0.length];
		int coste[][]={c0, c1};  
	    int cOpt = buscar (coste, 0, f, solActual, 0, solOptima, Integer.MAX_VALUE);
		
	    return cOpt;
	}
	


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
			   			
			   			   if (cParc<cOpt) {
			   				   cOpt = cParc;
			   			   }
			   		   }
			   		   else 
			   			
			   			   cOpt = buscar (coste, etapa+1, f, solParc, cParc, solOpt, cOpt);
			   		 System.out.println("opcion:"+j+" etapa:"+etapa+" coste:"+cParc);
			   		   //restaurar valorActual
			   		   cParc -= gasto;  
	  		   	   }
			   	   return cOpt;
	   }

	
	/// Método extra añade costes cuando es necesario
	
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
	
	
	

	public static void main(String[] args) {

		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		//int c0[] = { 9, 3, 7, 30 };
		//int c1[] = { 2, 20, 2, 3 };
		int f = 10;
		System.out.println(sedes(c0, c1, f));

	}

}
