package Ejecicio;

public class Ejercicio3 {

	public static void sedes(int[] c0, int[] c1, int f) {
		int etapa = 0;
		int algo=buscarOptima(etapa, c1.length, c1, 1, c0,0);
		System.out.println(algo);

	}

	// vuelta atras

	private static int buscarOptima(int etapa, int fin, int[] solActual,int valorActual, int[] solOptima, int valorOptimo) {
		int valor;
         //hacemos el bucle hasta qu encontramos la mejor opcion
		for (int k = 0; k < solActual.length ; k++) {
			System.out.println(etapa);
			if (k-1>-1 ) {// es factible si la suma es mayor 
				if (etapa == fin) { 
					//PODA 
				
					//si es optimo mas pequeño se coge el optimo
					/*if(solActual[k]>solOptima[k]) {	
						// se comprueba antecedentes si es el mismo no se le suma nada 
						if(solOptima[k-1]!=valorActual){
						// System.out.println(solOptima[k-1]+"-"+valorActual);
						 	// si es distinto se le suma 10
							
						}
							valorActual=solOptima[k];
							 System.out.println("-"+valorActual);
							valorOptimo+=valorActual;
						}
					///si no escojemos 
					else {
						// se comprueba antecedentes 
						if(solActual[k-1]!=valorActual){
						//System.out.println(solActual[k-1]+"-"+valorActual);
							// si es distinto se le suma 10
							
						}
						//se mete en optimo el mejor y en actual tb
						 valorActual=solActual[k];
						 System.out.println("-"+valorActual);
						 valorOptimo+=valorActual;
					}*/
					
					 valorOptimo+=1;
					} else {
						 System.out.println("**********");
						//se desarrollan todas las ramas
						valorOptimo = buscarOptima(etapa + 1, fin, solActual,valorActual, solOptima, valorOptimo);
						// <<borrarlo de solActual y restaurar valorActual>>;
						//solActual=0;
						//valorActual
						//valorOptimo=0;
				}
			}
	
		}
		return valorOptimo;
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
