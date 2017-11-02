package Ejecicio;

public class Ejercicio3 {
	static int nodos = 0;
	public static void sedes(int[] c0, int[] c1, int f) {
		int etapa = 0;
		int copt=0;
		int algo=buscarOptima(etapa, c1.length, c1, 1, c0,0);
	System.out.println(algo);

	}

	// vuelta atras

	private static int buscarOptima(int etapa, int fin, int[] solActual,int valorActual, int[] solOptima, int valorOptimo) {
		int valor;
         //hacemos el bucle hasta qu encontramos la mejor opcion
		for (int k = 0; k < 2; k++) {		
				if (etapa == fin) { 
					if (k-1>-1 ) {// es factible si la suma es mayor 
					valorOptimo=solActual[k];
					valorActual=solOptima[k];
					//si es optimo mas pequeño se coge el optimo
					if(solActual[k]>solOptima[k]) {	
						// se comprueba antecedentes si es el mismo no se le suma nada 
						if(solOptima[k-1]!=valorActual){
						}
							valorOptimo=solOptima[k];
						}
					///si no escojemos 
					else {
						// se comprueba antecedentes 
						if(solActual[k-1]!=valorActual){
		
						}
						//se mete en optimo el mejor y en actual tb
							valorOptimo=solActual[k];

					}
		
				}
					} else {
						
						//se desarrollan todas las ramas
						valorOptimo += buscarOptima(etapa + 1, fin, solActual,valorActual, solOptima, valorOptimo);
						// <<borrarlo de solActual y restaurar valorActual>>;
				
			}
			
	
		}
		return valorOptimo;
	}

	private static int buscar(int[] c0, int[] c1, int f, int i, int[] solParc,
			int cParc, int[] solOpt, int cOpt) {
		// Se recorren las dos sedes existentes
		for (int j = 0; j < 2; j++) {
			nodos++;
			solParc[i] = j;
			// Sumamos el valor correspondiente al nuevo nivel
			cParc += coste(c0, c1, f, solParc, i);
			/*
			 * Comprobamos si hemos llegado al final de la rama, para fijar el
			 * mejor candidato
			 */
			if (i == c0.length - 1) {
				if (cParc < cOpt) {
					cOpt = cParc;
					for (int k = 0; k < solParc.length; k++)
						solOpt[k] = solParc[k];
				}
			}
			/*
			 * Si no hemos llegado al final de la rama, seguimos bajando niveles
			 * de forma recursiva
			 */
			else
				cOpt = buscar(c0, c1, f, i + 1, solParc, cParc, solOpt, cOpt);
			// Restamos el valor correspondiente, para continuar con otra rama
			cParc -= coste(c0, c1, f, solParc, i);
		}
		return cOpt;
	}

	
	
	
	/*
	 * Método que selecciona el valor que hay que sumar en el nivel
	 * correspondiente
	 */
	private static int coste(int[] c0, int[] c1, int f, int[] solParcial, int i) {
		/* Si estamos en la sede 0, asignamos a coste el valor correspondiente */
		int coste = 0;
		if (solParcial[i] == 0) {
			coste = c0[i];
			/*
			 * Controlar si es necesario sumar cambio de sede, comparando si la
			 * sede actual es igual a la anterior o si estamos en el primer
			 * nivel
			 */
			if ((i != 0) && (solParcial[i] != solParcial[i - 1])) {
				coste += f;
			}
			/*
			 * Si estamos en la sede 1, asignamos a coste el valor
			 * correspondiente
			 */
		} else {
			coste = c1[i];
			/*
			 * Controlar si es necesario sumar cambio de sede, comparando si la
			 * sede actual es igual a la anterior o si estamos en el primer
			 * nivel
			 */
			if ((i != 0) && (solParcial[i] != solParcial[i - 1])) {
				coste += f;
			}
		}
		return coste;
	}
	private static boolean EsFactible(int valorOptimo) {
		// TODO Auto-generated method stub
		return false;
	}

	// ramificación y poda

	/*
	 * private static int buscarOptima (int n_1, int i, Valor[ ] solActual, int
	 * valorActual, Valor[ ] solOptima, int valorOptimo) { int valor; for (int
	 * k=0; k<m; k++) { <<generar candidato k-ésimo>>; if (<<candidato válido>>)
	 * { <<calcular cota superior>> if cota > valorOptimo { <<incluirlo en
	 * solActual y actualizar valorActual>>; if (i==n_1) if
	 * (valorActual>valorOptimo) { <<solOptima = solActual>> valorOptimo =
	 * valorActual; { else valorOptimo = buscarOptima (n, i+1, solActual,
	 * valorActual, solOptima, valorOptimo); <<borrarlo de solActual y restaurar
	 * valorActual>>; } } } return valorOptimo; }
	 */
	public static void main(String[] args) {
		int c0[] = { 3, 8, 5, 2, 4 };
		int c1[] = { 7, 1, 6, 9, 6 };
		
		int f = 5;

		sedes(c0, c1, f);

	}

}
