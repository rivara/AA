
package Ejecicio;
public class Ejercicio2 {
	/* H1 */
	public static int sedes1(int[] c0, int[] c1, int f) {
		int result = 0;
		boolean esta = false;
		for (int d = 0; d < c0.length; d++) {
			if (c0[d] <= c1[d]) {
				result = result + c0[d];
			}
		}
		esta = false;
		for (int d = 0; d < c0.length; d++) {
			if (c0[d] > c1[d]) {
				result = result + c1[d];
				esta = false;
			} else {
				if (!esta) {
					result = result + f;
					esta = true;
				}
			}
		}

		return result;
	}

	/* H2 */
	public static int sedes2(int[] c0, int[] c1, int f) {
		int sede = 0;
		int result = 0;
		int coste = 0;
		for (int i = 0; i < c0.length; i++) {
			if (sede == 0) {
				if (c0[i] <= (c1[i] + f)) {
					result = result + c0[i];
				} else {
					sede = 1;
					result = result + c1[i] + f;
				}
			} else {
				if (c1[i] <= (c0[i] + f)) {
					result = result + c1[i];
				} else {
					sede = 0;
					result = result + c0[i] + f;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;
		System.out.println(sedes1(c0, c1, f));
		System.out.println(sedes2(c0, c1, f));

	}
}
