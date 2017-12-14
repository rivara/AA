package Ejejercicio;

public class Ejercicio5 {

	public static boolean esta = false;
	public static int cont = 0;

	// controlamos cual es el mayor y si se ha cambiado de sede
	// respecto al anterior
	static int min(int a, int b) {
		if (a <= b) {
			return a;
		} else {
			return b;

		}
	}

	public static int sedes(int[] c0, int[] c1, int f) {
		return sedesAux(c0, c1, f, c0.length - 1);
	}

	public static int sedesAux(int[] c0, int[] c1, int f, int n) {
		// Caso base
		if (n == 0)
			return 0;

		// compruebo si cambia de sede
		if (c0[n] > c1[n]) {
			esta = false;
			cont = 0;
		} else {
			if (!esta) {
				cont = f;
				esta = true;
			}
		}
		// devuelve el minimo de las 2 sedes
		// (1) sede 0 sea mayor que la sede 1
		// (2) sede 1 sea mayor que la sede 0
		return min(sedesAux(c0, c1, f, n - 1) + cont + c0[n - 1], sedesAux(c0, c1, f, n - 1) + cont + c1[n - 1]);
	}

	public static void main(String args[]) {
		int c0[] = new int[] { 1, 3, 20, 3, 2 };
		int c1[] = new int[] { 50, 20, 2, 4, 7 };
		int f = 10;
		System.out.println(sedes(c0, c1, f));
	}
}
