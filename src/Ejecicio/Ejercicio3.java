package Ejecicio;

public class Ejercicio3 {

	public static void sedes(int[] c0, int[] c1, int f) {
		int etapa = 0;
		int algo=buscarOptima(etapa, c1.length, c1, c1[etapa], c0,c0[etapa]);
		System.out.println(algo);

	}

	// vuelta atras

	private static int buscarOptima(int etapa, int fin, int[] solActual,int valorActual, int[] solOptima, int valorOptimo) {
		int valor;
		for (int k = 0; k < solActual.length ; k++) {
			
				if (etapa == fin) {
					//FILTRADO 
					/*if (valorActual > valorOptimo) {
						// <<solOptima = solActual>>
						valorOptimo += valorOptimo;}else{
							valorOptimo+=valorActual;
						}*/
					System.out.println(solActual[k]+"-"+solOptima[k]);
					System.out.println("--"+valorActual+"-"+valorOptimo);
					} else {
						
						//se desarrollan todas las ramas
						valorOptimo = buscarOptima(etapa + 1, fin, solActual,valorActual, solOptima, valorOptimo);
						// <<borrarlo de solActual y restaurar valorActual>>;
						//solActual=0;
						//valorActual
				}
			}
		
		return valorOptimo;
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
