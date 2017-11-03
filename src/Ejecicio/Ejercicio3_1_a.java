package Ejecicio;

public class Ejercicio3_1_a {
static int nodos;
	public static int sedes(int[] c0, int[] c1, int f) {
		int nodos = 0;
		int[] solParcial = new int[c0.length];
		int[] solOptima = new int[c0.length];
		int cOpt = buscar (c0, c1, f, 0, solParcial, 0, solOptima, Integer.MAX_VALUE);
		System.out.println("Número de nodos creados durante la búsqueda: " + nodos);
		System.out.print ("Solución óptima: ");
		imprimir (solOptima); System.out.println();
		return cOpt;
	}

	// vuelta atras

	/*private static int buscarOptima(int[] c0, int[] c1,int etapa, int fin, int[] solActual,int valorActual, int[] solOptima, int valorOptimo) {
		int valor;
         //hacemos el bucle hasta qu encontramos la mejor opcion
		for (int k = 0; k < 2; k++) {	
			solActual[etapa] = k;
				if (etapa == fin) { 
					if (valorActual < valorOptimo) {
						valorOptimo = valorActual;
						for (int d = 0; d< solActual.length; d++)
							solOptima[d] = solActual[d];
					}
				
					} else {
						
						//se desarrollan todas las ramas
						valorOptimo += buscarOptima(c0,c1,etapa + 1, fin, solActual,valorActual, solOptima, valorOptimo);
						// <<borrarlo de solActual y restaurar valorActual>>;
						
				
			}
			
	
		}
		return valorOptimo;
	}*/

	private static int buscar (int[] c0, int[] c1, int f, int i, int[] solParc,
			int cParc, int[] solOpt, int cOpt) {
			// Se recorren las dos sedes existentes
			for (int j=0; j<2; j++){
			nodos ++;
			solParc[i] = j;
			// Sumamos el valor correspondiente al nuevo nivel
			cParc += coste (c0, c1, f, solParc, i);
			/* Comprobamos si hemos llegado al final de la rama, para fijar
			el mejor candidato */
			if (i == c0.length-1) {
			if (cParc<cOpt) {
			cOpt = cParc;
			for (int k=0; k<solParc.length; k++)
			solOpt[k] = solParc[k];
			}
			}
			/* Si no hemos llegado al final de la rama, seguimos bajando niveles
			de forma recursiva */
			else
			cOpt = buscar (c0, c1, f, i+1, solParc, cParc, solOpt, cOpt);
			// Restamos el valor correspondiente, para continuar con otra rama
			cParc -= coste (c0, c1, f, solParc, i);
			}
			return cOpt;
			}
	
	/* Método que selecciona el valor que hay que sumar en el nivel
	correspondiente */
	private static int coste (int[] c0, int[] c1, int f, int[] solParcial, int i) {
	/* Si estamos en la sede 0, asignamos a coste el valor correspondiente */
	int coste = 0;
	if (solParcial[i] == 0){
	coste = c0[i];
	/* Controlar si es necesario sumar cambio de sede, comparando
	si la sede actual es igual a la anterior o si estamos en el primer
	nivel */
	if ((i != 0) && (solParcial[i] != solParcial[i-1])){
	coste += f;
	}
	/* Si estamos en la sede 1, asignamos a coste el valor correspondiente */
	}else{
	coste = c1[i];
	/* Controlar si es necesario sumar cambio de sede, comparando
	si la sede actual es igual a la anterior o si estamos en el primer
	nivel */
	if ((i != 0) && (solParcial[i] != solParcial[i-1])){
	coste += f;
	}
	}
	return coste;
	
	}
	
	
	
	
	private static void imprimir (int[] v) {
		for (int i=0; i<v.length; i++)
		System.out.print (v[i]+" ");
		System.out.println();
		}
	
	


	public static void main(String[] args) {

		int c0[] = { 3, 8, 5, 2, 4 };
		int c1[] = { 7, 1, 6, 9, 6 };
		
		int f = 5;

		sedes(c0, c1, f);

	}

}
