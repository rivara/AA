package Ejecicio;

class Ejecicio3_1_b {

	public static void main(String[] args) {
		public static int sedes_RyP (int[] c0, int[] c1, int f) {
			nodos2 = 0;
			int[] solParcial = new int[c0.length];
			int[] solOptima = new int[c0.length];
			// Calculamos la cota
			int cota = calcCota(c0, c1, f, solParcial, 0);
			System.out.println ("Cota inicial: "+cota+". Coste mínimo inicial: 0");
			int cOpt = buscarSedes_RyP (c0,c1,f,0,solParcial,0,solOptima,Integer.MAX_VALUE,cota);
			System.out.println("Número de nodos creados durante la búsqueda: " + nodos2);
			System.out.print ("Solución óptima: "); imprimir (solOptima); System.out.println();
			return cOpt;
			}
			private static int buscarSedes_RyP (int[] c0, int[] c1, int f, int i, int[] solParc,
			int cParc, int[] solOpt, int cOpt, int cota) {
			// Se recorren las dos sedes existentes
			for (int j=0; j<2; j++){
			solParc[i] = j;
			// Calculamos la cota en cada nivel
			int nCota = calcCota(c0, c1, f, solParc, i);
			/* Evaluamos si la cota es menor que el mejor candidato hasta el momento.
			En caso de ser mayor, no continuará la evaluación, podando la rama */
			if (nCota < cOpt){
			nodos2 ++;
			// Sumamos el valor correspondiente al nuevo nivel
			cParc += coste (c0, c1, f, solParc, i);
			/* Comprobamos si hemos llegado al final de la rama, para fijar
			el mejor candidato */
			if (i == c0.length-1) {
			if (cParc<cOpt) {
			cOpt = cParc;
			for (int k=0; k<solParc.length; k++)
			solOpt[k] = solParc[k];
			System.out.print ("Nuevo coste mínimo: "+cOpt+". Estado: ");
			imprimir (solOpt);
			}
			}
			/* Si no hemos llegado al final de la rama, seguimos bajando niveles
			de forma recursiva */
			else
			cOpt = buscarSedes_RyP (c0,c1,f,i+1,solParc,cParc,solOpt,cOpt,cota);
			// Restamos el valor correspondiente, para continuar con otra rama
			cParc -= coste (c0, c1, f, solParc, i);
			}else{
			System.out.print ("Poda con cota: "+nCota+". Estado: ");
			imprimir2 (solParc, i);
			}
			}
			return cOpt;
			}
			Código del algoritmo de Ramificación y Poda 8
			PRÁCTICA 1 | Algoritmos de Búsqueda
			Métodos implicados en el cálculo de la cota
			/* Algoritmo que calcula la cota. Fijará el valor real consumido hasta cada
			nodo y, a partir de ahí, comparará el mejor valor de los hijos hasta llegar
			a cada nodo hoja */
			public static int calcCota (int[] c0, int[] c1, int f, int[] solParcial, int i){
			int cota = 0;
			for (int j=0; j<=i; j++){
			cota += coste (c0, c1, f, solParcial, j);
			}
			for (int j=i+1; j<c0.length; j++){
			cota += minimo (c0, c1, j);
			}
			return cota;
			}
			private static int minimo (int[] c0, int[] c1, int j) {
			int min = 0;
			if (c0[j] < c1[j])
			min = c0[j];
			else
			min = c1[j];
			return min;
			}
			Métodos adicionales
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
			private static void imprimir2 (int[] v, int k) {
			for (int i=0; i<=k; i++)
			System.out.print (v[i]+" ");
			for (int i=k+1; i<v.length; i++)
			System.out.print ("- ");
			System.out.println();
			}

	}

}
