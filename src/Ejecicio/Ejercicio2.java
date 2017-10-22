package Ejecicio;

public class Ejercicio2 {

	public static int sedes1(int[] c0, int[] c1, int f) {
		// int[] result= new int[f+c0.length+c1.length];
		int result = 0;
		boolean esta = false;
		for (int d = 0; d < c0.length; d++) {

			// if a >b coge a
			if (c0[d] <= c1[d]) {
				result = result + c0[d];
				esta = false;
			} else {
				if (!esta) {
					result = result + f;
					esta = true;
				} else {

				}
			}
		}

		esta = false;
		for (int d = 0; d < c0.length; d++) {

			// if a<b coge a
			if (c0[d] >= c1[d]) {

				result = result + c1[d];

				esta = false;
			} else {
				if (!esta) {
					result = result + f;
					esta = true;
				} else {

				}
			}
		}

		return result -f;
	}
	
	/**/
	/* Segundo algoritmo, H2, que toma el coste menor teniendo en cuenta el
	coste de cambio de sede (f) al comparar los elementos */
	public static int sedes2 (int[] c0, int[] c1, int f){
	int sede;
	int costeTotal = 0;
	/* Partimos de la base de que al inicio no hay coste f de cambio de
	sede, por lo tanto seleccionamos la de menor coste */
	if (c0[0]<=c1[0]){
	sede = 0;
	costeTotal = costeTotal + c0[0];
	// System.out.print("Nuevo array: " + c0[0]);
	} else{
	sede = 1;
	costeTotal = costeTotal + c1[0];
	// System.out.print("Nuevo array: " + c0[0]);
	}
	/* Una vez sumado el primer coste menor, recorremos el resto de valores
	para determinar si interesa un cambio de sede. Es decir, que si al
	cambiar de sede el valor del nuevo coste más el del cambio de sede (f)
	es menor que el de la sede actual */
	for (int i=1; i<c0.length; i++){
	// Partimos de la sede 0
	if (sede == 0){
	if (c0[i] <= (c1[i] + f)){
	costeTotal = costeTotal + c0[i];
	// System.out.print("+" + c0[i]);
	} else{
	sede = 1; // cambiamos a la sede 1
	/* sumamos el coste correspondiente más el coste por cambio
	de sede, f */
	costeTotal = costeTotal + c1[i] + f;

	// System.out.print("+" + "(" + c1[i] + "+" + f + ")");
	}
	} else{ // Partimos de la sede 1
	if (c1[i] <= (c0[i] + f)){
	costeTotal = costeTotal + c1[i];
	// System.out.print("+" + c1[i]);
	} else{
	sede = 0; // cambiamos a la sede 0
	/* Sumamos el coste correspondiente más el coste por cambio
	de sede, f */
	costeTotal = costeTotal + c0[i] + f;
	// System.out.print("+" + "(" + c0[i] + "+" + f + ")");
	}
	}
	}
	return costeTotal; // Se devuelve el resultado del coste total
	} // Fin de sedes2 (algoritmo H2)
	
	
	
	/**/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public static int sedes2 (int[] c0, int[] c1, int f) {}
	 */

	public static void main(String[] args) {
		int c0[] = {3,8,5,2,4};
		int c1[] = {7,1,6,9,6};
		int f = 5;
		System.out.print(sedes1(c0, c1, f));

	}
}
