package Ejecicio;

class Ejecicio3_1_b {

static int nodos;
	public static int sedes_RyP(int[] c0, int[] c1, int f) {

		
		 int[] solParcial = new int[c0.length];
	      int[] solOptima = new int[c0.length];
	      int coste[][]={c0, c1};
	      
	      int cota = calcularCota_Nueva (coste, solParcial, -1);
	      
	      System.out.println ("Cota inicial: "+cota+". Coste mínimo inicial: 0");
	      int cOpt2 = buscar2_Nueva (coste, 0, f, solParcial, 0, solOptima, Integer.MAX_VALUE, cota);
	      System.out.println("Número de nodos creados durante la búsqueda: " );
	      System.out.print ("Solución óptima: "); imprimir (solOptima); //System.out.println();
	     // return cOpt;
		return cOpt2;
	}


	/*ramifica y poda*/
	private static int buscar2_Nueva (int[][] coste, int i, int f, int[] solParc, int cParc, int[] solOpt, int cOpt, int cota) 
	   {
		   		// versión de ramificación y poda, tomando como cota inferior el coste mínimo de costes de sedes sin traslado
		   			
		   		for (int j=0; j<coste.length; j++)
		   			{
		   				solParc[i] = j;
		   				
		   				int nCota = calcularCota_Nueva (coste, solParc, i);
		   				
		   				if (nCota < cOpt) 
		   				{
		   					nodos++;
		   					
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

	   private static void imprimir (int[] v) {
	      for (int i=0; i<v.length; i++)
	         System.out.print (v[i]+" ");
	      System.out.println();
	   }

	public static void main(String[] args) {
		
		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;

		System.out.println(sedes_RyP(c0, c1, f));
	}
}
